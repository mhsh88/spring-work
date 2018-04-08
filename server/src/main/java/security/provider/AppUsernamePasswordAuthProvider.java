package security.provider;

import com.feth.play.module.mail.Mailer;
import com.feth.play.module.mail.Mailer.Mail.Body;
import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.providers.password.UsernamePasswordAuthProvider;
import com.feth.play.module.pa.providers.password.UsernamePasswordAuthUser;
import com.google.inject.Inject;
import controllers.routes;
import daos.users.TokenActionDao;
import daos.users.UserDao;
import models.users.LinkedAccountEntity;
import models.users.UserEntity;
import enumerations.security.ActionTokenType;
import play.Logger;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.Lang;
import play.i18n.Messages;
import play.inject.ApplicationLifecycle;
import play.mvc.Call;
import play.mvc.Http.Context;
import security.structure.AppLogin;
import security.structure.AppSignup;

import javax.inject.Singleton;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Developer: Payam Mostafaei
 * Creation Time: 2015/Sep/21 - 10:43 PM
 */
@Singleton
public class AppUsernamePasswordAuthProvider extends
		UsernamePasswordAuthProvider<String, AppLoginUsernamePasswordAuthUser, AppUsernamePasswordAuthUser, AppLogin, AppSignup> {

	private static final String SETTING_KEY_VERIFICATION_LINK_SECURE = SETTING_KEY_MAIL + "." + "verificationLink.secure";
	private static final String SETTING_KEY_PASSWORD_RESET_LINK_SECURE = SETTING_KEY_MAIL + "." + "passwordResetLink.secure";
	private static final String SETTING_KEY_LINK_LOGIN_AFTER_PASSWORD_RESET = "loginAfterPasswordReset";

	private static final String EMAIL_TEMPLATE_FALLBACK_LANGUAGE = "fa";

	@Override
	protected List<String> neededSettingKeys() {
		final List<String> needed = new ArrayList<>(super.neededSettingKeys());
		needed.add(SETTING_KEY_VERIFICATION_LINK_SECURE);
		needed.add(SETTING_KEY_PASSWORD_RESET_LINK_SECURE);
		needed.add(SETTING_KEY_LINK_LOGIN_AFTER_PASSWORD_RESET);
		return needed;
	}

	private final Form<AppSignup> SIGNUP_FORM;
	private final Form<AppLogin> LOGIN_FORM;
	//private final Messages messages;
	private final UserDao userDao;
	private final TokenActionDao tokenActionDao;

	@Inject
	public AppUsernamePasswordAuthProvider(final PlayAuthenticate auth, final FormFactory formFactory,
										   final ApplicationLifecycle lifecycle, Mailer.MailerFactory mailerFactory,
										   /*MessagesApi messages, */UserDao userDao, TokenActionDao tokenActionDao) {
		super(auth, lifecycle, mailerFactory);

		//this.messages = messages.preferred(Http.Context.current().request());

		this.SIGNUP_FORM = formFactory.form(AppSignup.class);
		this.LOGIN_FORM = formFactory.form(AppLogin.class);

		this.userDao = userDao;
		this.tokenActionDao = tokenActionDao;
	}

	protected Form<AppSignup> getSignupForm() {
		return SIGNUP_FORM;
	}

	public Form<AppLogin> getLoginForm() {
		return LOGIN_FORM;
	}

	@Override
	protected SignupResult signupUser(final AppUsernamePasswordAuthUser user) {
		final UserEntity u = userDao.findByUsernamePasswordIdentity(user);
		if (u != null) {
			if (u.emailActivated || u.mobileActivated) {
				// This user exists, has its username validated and is active
				return SignupResult.USER_EXISTS;
			} else {
				// this user exists, is active but has not yet validated its username
				return SignupResult.USER_EXISTS_UNVERIFIED;
			}
		}
		// The user either does not exist or is inactive - create a new one
		@SuppressWarnings("unused")
		final UserEntity newUser = userDao.create(user);
		// Usually the username should be verified before allowing login, however
		// if you return
		// return SignupResult.USER_CREATED;
		// then the user gets logged in directly
		return SignupResult.USER_CREATED_UNVERIFIED;
	}

	@Override
	protected LoginResult loginUser(final AppLoginUsernamePasswordAuthUser authUser) {
		final UserEntity u = userDao.findByUsernamePasswordIdentity(authUser);
		if (u == null) return LoginResult.NOT_FOUND;
		else {
			for (final LinkedAccountEntity acc : u.linkedAccounts) {
				if (getKey().equals(acc.providerKey)) {
					if (authUser.checkPassword(acc.providerUserId, authUser.getPassword()))
						return LoginResult.USER_LOGGED_IN;
					else return LoginResult.WRONG_PASSWORD;
				}
			}
			return LoginResult.WRONG_PASSWORD;
		}
	}

	@Override
	protected Call userExists(final UsernamePasswordAuthUser authUser) {
		return routes.Account.exists();
	}

	@Override
	protected Call userUnverified(final UsernamePasswordAuthUser authUser) {
		return routes.Account.unverified();
	}

	@Override
	protected AppUsernamePasswordAuthUser buildSignupAuthUser(final AppSignup signup, final Context ctx) {
		return new AppUsernamePasswordAuthUser(signup);
	}

	@Override
	protected AppLoginUsernamePasswordAuthUser buildLoginAuthUser(
			final AppLogin login, final Context ctx) {
		return new AppLoginUsernamePasswordAuthUser(login.getPassword(),
				login.getEmail());
	}
	

	@Override
	protected AppLoginUsernamePasswordAuthUser transformAuthUser(final AppUsernamePasswordAuthUser authUser, final Context context) {
		return new AppLoginUsernamePasswordAuthUser(authUser.getEmail());
	}

	@Override
	protected String getVerifyEmailMailingSubject(
			final AppUsernamePasswordAuthUser user, final Context ctx) {
		//return messages.at("playauthenticate.password.verify_signup.subject");
		return Messages.get("playauthenticate.password.verify_signup.subject");
	}

	@Override
	protected String onLoginUserNotFound(final Context context) {
		context.flash()
				.put(/*controllers.Application.FLASH_ERROR_KEY, */"error",
						Messages.get("playauthenticate.password.login.unknown_user_or_pw"));
		return super.onLoginUserNotFound(context);
	}

	@Override
	protected Body getVerifyEmailMailingBody(final String token,
			final AppUsernamePasswordAuthUser user, final Context ctx) {

		final boolean isSecure = getConfiguration().getBoolean(
				SETTING_KEY_VERIFICATION_LINK_SECURE);
		final String url = routes.Account.verify(token).absoluteURL(ctx.request(), isSecure);

		//final Lang lang = messages.lang();
		final Lang lang = Lang.preferred(ctx.request().acceptLanguages());
		final String langCode = lang.code();

		final String html = getEmailTemplate(
				"views.html.account.signup.username.verify_email", langCode, url,
				token, user.getName(), user.getEmail());
		final String text = getEmailTemplate(
				"views.txt.account.signup.username.verify_email", langCode, url,
				token, user.getName(), user.getEmail());

		return new Body(text, html);
	}

	private static String generateToken() {
		return UUID.randomUUID().toString();
	}

	@Override
	protected String generateVerificationRecord(
			final AppUsernamePasswordAuthUser user) {
		return generateVerificationRecord(userDao.findByAuthUserIdentity(user));
	}

	protected String generateVerificationRecord(final UserEntity user) {
		final String token = generateToken();
		// Do database actions, etc.
		tokenActionDao.create(ActionTokenType.EMAIL_VERIFICATION, token, user);
		return token;
	}

	protected String generatePasswordResetRecord(final UserEntity user) {
		final String token = generateToken();
		tokenActionDao.create(ActionTokenType.PASSWORD_RESET, token, user);
		return token;
	}

	protected String getPasswordResetMailingSubject(final UserEntity user, final Context ctx) {
		return Messages.get("playauthenticate.password.reset_email.subject");
	}

	protected Body getPasswordResetMailingBody(final String token, final UserEntity user, final Context ctx) {

		final boolean isSecure = getConfiguration().getBoolean(SETTING_KEY_PASSWORD_RESET_LINK_SECURE);
		final String url = routes.Account.resetPassword(token).absoluteURL(ctx.request(), isSecure);

		//final Lang lang = messages.lang();
		final Lang lang = Lang.preferred(ctx.request().acceptLanguages());
		final String langCode = lang.code();

		final String html = getEmailTemplate(
				"views.html.account.username.password_reset", langCode, url,
				token, user.getFullName(), user.getEmail());
		final String text = getEmailTemplate(
				"views.txt.account.username.password_reset", langCode, url, token,
				user.getFullName(), user.getEmail());

		return new Body(text, html);
	}

	public void sendPasswordResetMailing(final UserEntity user, final Context ctx) {
		final String token = generatePasswordResetRecord(user);
		final String subject = getPasswordResetMailingSubject(user, ctx);
		final Body body = getPasswordResetMailingBody(token, user, ctx);
		sendMail(subject, body, getEmailName(user));
	}

	public boolean isLoginAfterPasswordReset() {
		return getConfiguration().getBoolean(SETTING_KEY_LINK_LOGIN_AFTER_PASSWORD_RESET);
	}

	protected String getVerifyEmailMailingSubjectAfterSignup(final UserEntity user, final Context ctx) {
		return Messages.get("playauthenticate.password.verify_email.subject");
	}

	protected String getEmailTemplate(final String template,
			final String langCode, final String url, final String token,
			final String name, final String email) {
		Class<?> cls = null;
		String ret = null;
		try {
			cls = Class.forName(template + "_" + langCode);
		} catch (ClassNotFoundException e) {
			Logger.warn("Template: '"
					+ template
					+ "_"
					+ langCode
					+ "' was not found!");
		}
		if (cls == null) {
			try {
				cls = Class.forName(template + "_" + EMAIL_TEMPLATE_FALLBACK_LANGUAGE);
			} catch (ClassNotFoundException e) {
				Logger.error("Fallback template: '" + template + "_" + EMAIL_TEMPLATE_FALLBACK_LANGUAGE + "' was not found either!");
			}
		}
		if (cls != null) {
			Method htmlRender = null;
			try {
				htmlRender = cls.getMethod("render", String.class,
						String.class, String.class, String.class);
				ret = htmlRender.invoke(null, url, token, name, email)
						.toString();

			} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	protected Body getVerifyEmailMailingBodyAfterSignup(final String token, final UserEntity user, final Context ctx) {

		final boolean isSecure = getConfiguration().getBoolean(SETTING_KEY_VERIFICATION_LINK_SECURE);
		final String url = routes.Account.verify(token).absoluteURL(ctx.request(), isSecure);

		//final Lang lang = messages.lang();
		final Lang lang = Lang.preferred(ctx.request().acceptLanguages());
		final String langCode = lang.code();

		final String html = getEmailTemplate(
				"views.html.account.username.verify_email", langCode, url, token,
				user.getFullName(), user.getEmail());
		final String text = getEmailTemplate(
				"views.txt.account.username.verify_email", langCode, url, token,
				user.getFullName(), user.getEmail());

		return new Body(text, html);
	}

	public void sendVerifyEmailMailingAfterSignup(final UserEntity user,
			final Context ctx) {

		final String subject = getVerifyEmailMailingSubjectAfterSignup(user, ctx);
		final String token = generateVerificationRecord(user);
		final Body body = getVerifyEmailMailingBodyAfterSignup(token, user, ctx);
		sendMail(subject, body, getEmailName(user));
	}

	private String getEmailName(final UserEntity user) {
		/*final Lang lang = messages.lang();
		final String langCode = lang.code();
		return getEmailName(user.getEmail(), user.getFullName());*/
		return getEmailName(user.getEmail(), user.getFullName());
	}
}

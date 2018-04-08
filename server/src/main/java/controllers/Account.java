package controllers;

import com.payAm.core.ebean.BaseController;
import com.payAm.core.i18n.CoreMessagesCodes;
import daos.users.TokenActionDao;
import daos.users.UserDao;
import enumerations.security.ActionTokenType;
import models.users.TokenActionEntity;
import models.users.UserEntity;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import security.provider.AppUsernamePasswordAuthProvider;
import security.structure.AppLogin;

import javax.inject.Inject;

/**
 * Created by Payam Mostafaei
 * Creation Time: 2015/Nov/14 - 9:43 AM
 */
public class Account extends BaseController {

    @Inject
    UserDao userDao;

    @Inject
    TokenActionDao tokenActionDao;

    public Result doLogin() {
        UserEntity user = new UserEntity();
        user.username = request().body().asJson().get("username").asText();
        user.password = request().body().asJson().get("password").asText();
//        UserEntity user = Json.fromJson(request().body().asJson(), UserEntity.class);
        user = userDao.findByUsernamePassword(user);
        if (user == null) {
            return unauthorized(CoreMessagesCodes.ERROR_LOGIN_NOT_FOUND);
        }
        TokenActionEntity tokenAction = tokenActionDao.create(ActionTokenType.ACCESS, TokenActionDao.generateToken(), user);
        return ok(Json.toJson(tokenAction));
    }

    public Result doForgotPassword() {
        /*com.feth.play.module.pa.controllers.Authenticate.noCache(response());
        final Form<AppUsernamePasswordAuthProvider.AppIdentity> filledForm = FORGOT_PASSWORD_FORM.bindFromRequest();
        if (filledForm.hasErrors()) {
            // User did not fill in his/her username
            return badRequest(password_forgot.render(filledForm));
        } else {
            // The username address given *BY AN UNKNWON PERSON* to the form - we
            // should find out if we actually have a user with this username
            // address and whether password login is enabled for him/her. Also
            // only send if the username address of the user has been verified.
            final String username = filledForm.get().username;

            // We don't want to expose whether a given username address is signed
            // up, so just say an username has been sent, even though it might not
            // be true - that's protecting our user privacy.
            flash(Application.FLASH_MESSAGE_KEY, Messages.get("playauthenticate.reset_password.message.instructions_sent", username));

            final User user = User.findByEmail(username);
            if (user != null) {
                // yep, we have a user with this username that is active - we do
                // not know if the user owning that account has requested this
                // reset, though.
                final AppUsernamePasswordAuthProvider provider = AppUsernamePasswordAuthProvider.getProvider();
                // User exists
                if (user.emailValidated) {
                    provider.sendPasswordResetMailing(user, ctx());
                    // In case you actually want to let (the unknown person)
                    // know whether a user was found/an username was sent, use,
                    // change the flash message
                } else {
                    // We need to change the message here, otherwise the user
                    // does not understand whats going on - we should not verify
                    // with the password reset, as a "bad" user could then sign
                    // up with a fake username via OAuth and get it verified by an
                    // a unsuspecting user that clicks the link.
                    flash(Application.FLASH_MESSAGE_KEY, Messages.get("playauthenticate.reset_password.message.email_not_verified"));

                    // You might want to re-send the verification username here...
                    provider.sendVerifyEmailMailingAfterSignup(user, ctx());
                }
            }

            return redirect(routes.Application.index());
        }*/
        return ok();
    }

    public Result doSignup() {
        /*com.feth.play.module.pa.controllers.Authenticate.noCache(response());
        final Form<AppUsernamePasswordAuthProvider.AppSignup> filledForm = AppUsernamePasswordAuthProvider.SIGNUP_FORM
                .bindFromRequest();
        if (filledForm.hasErrors()) {
            // User did not fill everything properly
            return badRequest(signup.render(filledForm));
        } else {
            // Everything was filled
            // do something with your part of the form before handling the user
            // signup
            return UsernamePasswordAuthProvider.handleSignup(ctx());
        }*/
        return ok();
    }

    public Result exists() {
        com.feth.play.module.pa.controllers.Authenticate.noCache(response());
        return ok(/*exists.render()*/);
    }

    public Result unverified() {
        com.feth.play.module.pa.controllers.Authenticate.noCache(response());
        return ok(/*unverified.render()*/);
    }

    private TokenActionEntity tokenIsValid(final String token, final ActionTokenType type) {
        TokenActionEntity ret = null;
        if (token != null && !token.trim().isEmpty()) {
            final TokenActionEntity ta = tokenActionDao.findByToken(token, type);
            if (ta != null && ta.isValid()) {
                ret = ta;
            }
        }

        return ret;
    }

    public Result resetPassword(final String token) {
        /*com.feth.play.module.pa.controllers.Authenticate.noCache(response());
        final TokenAction ta = tokenIsValid(token, Type.PASSWORD_RESET);
        if (ta == null) {
            return badRequest(no_token_or_invalid.render());
        }

        return ok(password_reset.render(PASSWORD_RESET_FORM
                .fill(new PasswordReset(token))));*/
        return ok();
    }

    public Result doResetPassword() {
        /*com.feth.play.module.pa.controllers.Authenticate.noCache(response());
        final Form<PasswordReset> filledForm = PASSWORD_RESET_FORM
                .bindFromRequest();
        if (filledForm.hasErrors()) {
            return badRequest(password_reset.render(filledForm));
        } else {
            final String token = filledForm.get().token;
            final String newPassword = filledForm.get().password;

            final TokenAction ta = tokenIsValid(token, Type.PASSWORD_RESET);
            if (ta == null) {
                return badRequest(no_token_or_invalid.render());
            }
            final User u = ta.targetUser;
            try {
                // Pass true for the second parameter if you want to
                // automatically create a password and the exception never to
                // happen
                u.resetPassword(new MyUsernamePasswordAuthUser(newPassword),
                        false);
            } catch (final RuntimeException re) {
                flash(Application.FLASH_MESSAGE_KEY,
                        Messages.get("playauthenticate.reset_password.message.no_password_account"));
            }
            final boolean login = MyUsernamePasswordAuthProvider.getProvider()
                    .isLoginAfterPasswordReset();
            if (login) {
                // automatically log in
                flash(Application.FLASH_MESSAGE_KEY,
                        Messages.get("playauthenticate.reset_password.message.success.auto_login"));

                return PlayAuthenticate.loginAndRedirect(ctx(),
                        new MyLoginUsernamePasswordAuthUser(u.username));
            } else {
                // send the user to the login page
                flash(Application.FLASH_MESSAGE_KEY,
                        Messages.get("playauthenticate.reset_password.message.success.manual_login"));
            }
            return redirect(routes.Application.login());
        }*/
        return ok();
    }

    public Result oAuthDenied(final String getProviderKey) {
        com.feth.play.module.pa.controllers.Authenticate.noCache(response());
        return ok(/*oAuthDenied.render(getProviderKey)*/);
    }

    public Result verify(String token) {
        return ok();
    }
}
//package security.provider;
//
//import com.feth.play.module.pa.providers.password.UsernamePasswordAuthUser;
//import com.feth.play.module.pa.user.NameIdentity;
//import security.structure.AppLogin;
//import security.structure.AppSignup;
//import security.structure.MobileIdentity;
//
///**
// * Developer: Payam Mostafaei
// * Creation Time: 2015/Sep/21 - 10:44 PM
// */
//public class AppUsernamePasswordAuthUser extends UsernamePasswordAuthUser
//		implements NameIdentity, MobileIdentity {
//
//	final static java.util.regex.Pattern emailRegex = java.util.regex.Pattern.compile(
//			"\\b[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*\\b");
//	final static java.util.regex.Pattern mobileRegex = java.util.regex.Pattern.compile(
//			"^\\+?\\d+$");
//
//	private static final long serialVersionUID = 1L;
//	private final String name;
//	private final String phoneNumber;
//
//	public AppUsernamePasswordAuthUser(final AppSignup signup) {
//		super(signup.password, signup.username);
//		this.name = signup.name;
//		this.phoneNumber = signup.username;
//	}
//
//	@Override
//	public String getName() {
//		return name;
//	}
//
//	@Override
//	public String getPhoneNumber() {
//		if (mobileRegex.matcher(phoneNumber).matches())
//			return phoneNumber;
//		return null;
//	}
//
//	@Override
//	public String getEmail() {
//		if (emailRegex.matcher(super.getEmail()).matches())
//			return super.getEmail();
//		return null;
//	}
//}

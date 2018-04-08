package security.provider;

import com.feth.play.module.pa.providers.password.DefaultUsernamePasswordAuthUser;

/**
 * Developer: Payam Mostafaei
 * Creation Time: 2015/Sep/21 - 10:42 PM
 */
public class AppLoginUsernamePasswordAuthUser extends DefaultUsernamePasswordAuthUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The session timeout in seconds
	 * Defaults to two weeks
	 */
	final static long SESSION_TIMEOUT = 24 * 14 * 3600;
	private long expiration;

	/**
	 * For logging the user in automatically
	 * 
	 * @param email
	 */
	public AppLoginUsernamePasswordAuthUser(final String email) {
		this(null, email);
	}

	public AppLoginUsernamePasswordAuthUser(final String clearPassword,
											final String email) {
		super(clearPassword, email);

		expiration = System.currentTimeMillis() + 1000 * SESSION_TIMEOUT;
	}

	@Override
	public long expires() {
		return expiration;
	}

}

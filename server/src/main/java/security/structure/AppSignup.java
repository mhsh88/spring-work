package security.structure;

import play.data.validation.Constraints.MinLength;
import play.data.validation.Constraints.Required;
import play.i18n.Messages;

/**
 * Created by Payam Mostafaei
 * Creation Time: 2017/Feb/06 - 09:32 PM
 */
public class AppSignup extends AppLogin {

    @Required
    @MinLength(6)
    public String repeatPassword;

    @Required
    public String name;

    public String validate() {
        if (password == null || !password.equals(repeatPassword)) {
            return Messages.get("playauthenticate.password.signup.error.passwords_not_same");
        }
        return null;
    }
}

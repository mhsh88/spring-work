package security.structure;

import com.feth.play.module.pa.user.AuthUserIdentity;

/**
 * Created by Payam Mostafaei
 * Creation Time: 2017/Feb/06 - 09:57 PM
 */
public interface MobileIdentity extends AuthUserIdentity {

    String getPhoneNumber();
}

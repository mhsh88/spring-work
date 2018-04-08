package security.provider;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.user.AuthUser;
import daos.users.UserDao;
import models.users.UserEntity;
import org.jetbrains.annotations.Nullable;
import play.mvc.Http;

import javax.inject.Inject;

/**
 * Created by Payam Mostafaei
 * Creation Time: 2017/Jan/08 - 09:45 PM
 */
public class UserProvider {

    private final PlayAuthenticate auth;
    private final UserDao userDao;

    @Inject
    public UserProvider(final PlayAuthenticate auth, final UserDao userDao) {
        this.auth = auth;
        this.userDao = userDao;
    }

    @Nullable
    public UserEntity getUser(Http.Session session) {
        final AuthUser currentAuthUser = this.auth.getUser(session);
        final UserEntity localUser = userDao.findByAuthUserIdentity(currentAuthUser);
        return localUser;
    }
}

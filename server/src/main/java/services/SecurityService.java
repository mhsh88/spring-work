package services;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.service.AbstractUserService;
import com.feth.play.module.pa.user.AuthUser;
import com.feth.play.module.pa.user.AuthUserIdentity;
import com.google.inject.Inject;
import daos.users.UserDao;
import models.users.UserEntity;
import play.db.ebean.Transactional;

import javax.inject.Singleton;

/**
 * Developer: Payam Mostafaei
 * Creation Time: 2015/Sep/19 - 5:39 PM
 */

@Singleton
public class SecurityService extends AbstractUserService {

    private final UserDao userDao;

    @Inject
    public SecurityService(final PlayAuthenticate auth, final UserDao userDao) {
        super(auth);
        this.userDao = userDao;
    }

    @Override
    public Object save(final AuthUser authUser) {
        final boolean isLinked = userDao.existsByAuthUserIdentity(authUser);
        if (!isLinked) {
            return userDao.create(authUser).id;
        } else {
            // we have this user already, so return null
            return null;
        }
    }

    @Override
    @Transactional
    public Object getLocalIdentity(final AuthUserIdentity identity) {
        // For production: Caching might be a good idea here...
        // ...and dont forget to sync the cache when users get deactivated/deleted
        final UserEntity u = userDao.findByAuthUserIdentity(identity);
        if(u != null) {
            return u.id;
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public AuthUser merge(final AuthUser newUser, final AuthUser oldUser) {
        if (!oldUser.equals(newUser)) {
            userDao.merge(oldUser, newUser);
        }
        return oldUser;
    }

    @Override
    @Transactional
    public AuthUser link(final AuthUser oldUser, final AuthUser newUser) {
        userDao.addLinkedAccount(oldUser, newUser);
        return newUser;
    }

    @Override
    @Transactional
    public AuthUser update(final AuthUser knownUser) {
        // User logged in again, bump last login date
        //userDao.setLastLoginDate(knownUser);
        return knownUser;
    }
}

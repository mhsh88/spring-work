package daos.users;

import com.feth.play.module.pa.user.AuthUser;
import com.payAm.core.ebean.BaseDao;
import models.users.LinkedAccountEntity;
import models.users.UserEntity;

import javax.inject.Singleton;

/**
 * Created by Payam Mostafaei
 * Creation time: 2017/May/07 - 3:08 PM
 */

@Singleton
public class LinkedAccountDao extends BaseDao<Long, LinkedAccountEntity> {

    public LinkedAccountEntity findByProviderKey(final String username, String key) {
        return super.where()
                .eq("user.username", username)
                .eq("providerKey", key)
                .findUnique();
    }

    public LinkedAccountEntity create(final AuthUser authUser) {
        final LinkedAccountEntity ret = new LinkedAccountEntity();
        ret.providerKey = authUser.getProvider();
        ret.providerUserId = authUser.getId();
        return ret;
    }
}
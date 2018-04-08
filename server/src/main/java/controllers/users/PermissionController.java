package controllers.users;

import com.payAm.core.ebean.BaseDao;
import com.payAm.core.ebean.RestController;
import daos.users.PermissionDao;
import dtos.users.PermissionView;
import models.users.PermissionEntity;

import javax.inject.Inject;
/**
 * Developer: Payam Mostafaei
 * Creation Time: 2017/Jun/03 - 11:25
 */
public class PermissionController extends 
        RestController<PermissionEntity, Long, PermissionView> {

    @Inject
    private PermissionDao dao;

    @Override
    public BaseDao<Long, PermissionEntity> getDao() {
        return dao;
    }
}
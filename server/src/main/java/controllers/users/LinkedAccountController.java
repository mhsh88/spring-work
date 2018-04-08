package controllers.users;

import com.avaje.ebean.annotation.Transactional;
import com.payAm.core.ebean.BaseDao;
import com.payAm.core.ebean.RestController;
import daos.users.LinkedAccountDao;
import dtos.users.LinkedAccountView;
import models.users.LinkedAccountEntity;
import play.mvc.Result;

import javax.inject.Inject;

/**
 * Developer: Payam Mostafaei
 * Creation Time: 2017/Jun/03 - 11:25
 */
public class LinkedAccountController extends 
        RestController<LinkedAccountEntity, Long, LinkedAccountView> {

    @Inject
    private LinkedAccountDao dao;

    @Override
    public BaseDao<Long, LinkedAccountEntity> getDao() {
        return dao;
    }

    @Override
    @Transactional
    //@Pattern(Permission.LINKED_ACCOUNT_UPDATE)
    public Result insert() {
        return super.insert();
    }

    @Override
    @Transactional
    //@Pattern(Permission.LINKED_ACCOUNT_UPDATE)
    public Result update() {
        return super.update();
    }

    @Override
    @Transactional
    //@Pattern(Permission.LINKED_ACCOUNT_DELETE)
    public Result delete(Long id) {
        return super.delete(id);
    }
}
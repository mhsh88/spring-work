package controllers.assessments;

import com.avaje.ebean.annotation.Transactional;
import com.payAm.core.ebean.BaseDao;
import com.payAm.core.ebean.RestController;
import daos.assessments.SalDao;
import dtos.assessments.SalView;
import models.assessments.SalEntity;
import play.mvc.Result;

import javax.inject.Inject;

/**
 * Developer: Payam Mostafaei
 * Creation Time: 2017/Dec/08 - 14:03
 */
public class SalController extends 
        RestController<SalEntity, Long, SalView> {

    @Inject
    private SalDao dao;

    @Override
    public BaseDao<Long, SalEntity> getDao() {
        return dao;
    }

    @Override
    @Transactional
    //@Pattern(Permission.SAL_UPDATE)
    public Result insert() {
        return super.insert();
    }

    @Override
    @Transactional
    //@Pattern(Permission.SAL_UPDATE)
    public Result update() {
        return super.update();
    }

    @Override
    @Transactional
    //@Pattern(Permission.SAL_DELETE)
    public Result delete(Long id) {
        return super.delete(id);
    }
}
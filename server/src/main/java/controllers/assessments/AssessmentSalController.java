package controllers.assessments;

import com.avaje.ebean.annotation.Transactional;
import com.payAm.core.ebean.BaseDao;
import com.payAm.core.ebean.RestController;
import daos.assessments.AssessmentSalDao;
import dtos.assessments.AssessmentSalView;
import models.assessments.AssessmentSalEntity;
import play.mvc.Result;

import javax.inject.Inject;

/**
 * Developer: Payam Mostafaei
 * Creation Time: 2017/Dec/08 - 14:03
 */
public class AssessmentSalController extends 
        RestController<AssessmentSalEntity, Long, AssessmentSalView> {

    @Inject
    private AssessmentSalDao dao;

    @Override
    public BaseDao<Long, AssessmentSalEntity> getDao() {
        return dao;
    }

    @Override
    @Transactional
    //@Pattern(Permission.ASSESSMENT_SAL_UPDATE)
    public Result insert() {
        return super.insert();
    }

    @Override
    @Transactional
    //@Pattern(Permission.ASSESSMENT_SAL_UPDATE)
    public Result update() {
        return super.update();
    }

    @Override
    @Transactional
    //@Pattern(Permission.ASSESSMENT_SAL_DELETE)
    public Result delete(Long id) {
        return super.delete(id);
    }
}
package controllers.assessments;

import com.avaje.ebean.annotation.Transactional;
import com.payAm.core.ebean.BaseDao;
import com.payAm.core.ebean.RestController;
import daos.assessments.OrganizationAssessmentDao;
import dtos.assessments.OrganizationAssessmentView;
import models.assessments.OrganizationAssessmentEntity;
import play.mvc.Result;

import javax.inject.Inject;
/**
 * Developer: Payam Mostafaei
 * Creation Time: 2017/Dec/08 - 14:03
 */
public class OrganizationAssessmentController extends 
        RestController<OrganizationAssessmentEntity, Long, OrganizationAssessmentView> {

    @Inject
    private OrganizationAssessmentDao dao;

    @Override
    public BaseDao<Long, OrganizationAssessmentEntity> getDao() {
        return dao;
    }

    @Override
    @Transactional
    //@Pattern(Permission.ORGANIZATION_ASSESSMENT_UPDATE)
    public Result insert() {
        return super.insert();
    }

    @Override
    @Transactional
    //@Pattern(Permission.ORGANIZATION_ASSESSMENT_UPDATE)
    public Result update() {
        return super.update();
    }

    @Override
    @Transactional
    //@Pattern(Permission.ORGANIZATION_ASSESSMENT_DELETE)
    public Result delete(Long id) {
        return super.delete(id);
    }
}
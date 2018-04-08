package controllers.assessments;

import com.avaje.ebean.annotation.Transactional;
import com.payAm.core.ebean.BaseDao;
import com.payAm.core.ebean.RestController;
import daos.assessments.OrganizationAssessmentHasQuestionDao;
import dtos.assessments.OrganizationAssessmentHasQuestionView;
import models.assessments.OrganizationAssessmentHasQuestionEntity;
import play.mvc.Result;

import javax.inject.Inject;
/**
 * Developer: Payam Mostafaei
 * Creation Time: 2017/Dec/08 - 14:03
 */
public class OrganizationAssessmentHasQuestionController extends 
        RestController<OrganizationAssessmentHasQuestionEntity, Long, OrganizationAssessmentHasQuestionView> {

    @Inject
    private OrganizationAssessmentHasQuestionDao dao;

    @Override
    public BaseDao<Long, OrganizationAssessmentHasQuestionEntity> getDao() {
        return dao;
    }

    @Override
    @Transactional
    //@Pattern(Permission.ORGANIZATION_ASSESSMENT_HAS_QUESTION_UPDATE)
    public Result insert() {
        return super.insert();
    }

    @Override
    @Transactional
    //@Pattern(Permission.ORGANIZATION_ASSESSMENT_HAS_QUESTION_UPDATE)
    public Result update() {
        return super.update();
    }

    @Override
    @Transactional
    //@Pattern(Permission.ORGANIZATION_ASSESSMENT_HAS_QUESTION_DELETE)
    public Result delete(Long id) {
        return super.delete(id);
    }
}
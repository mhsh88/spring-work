package controllers.assessments;

import com.avaje.ebean.annotation.Transactional;
import com.payAm.core.ebean.BaseDao;
import com.payAm.core.ebean.RestController;
import daos.assessments.PreQuestionAnswerDao;
import dtos.assessments.PreQuestionAnswerView;
import models.assessments.PreQuestionAnswerEntity;
import play.mvc.Result;

import javax.inject.Inject;
/**
 * Developer: Payam Mostafaei
 * Creation Time: 2017/Dec/08 - 14:03
 */
public class PreQuestionAnswerController extends 
        RestController<PreQuestionAnswerEntity, Long, PreQuestionAnswerView> {

    @Inject
    private PreQuestionAnswerDao dao;

    @Override
    public BaseDao<Long, PreQuestionAnswerEntity> getDao() {
        return dao;
    }

    @Override
    @Transactional
    //@Pattern(Permission.PRE_QUESTION_ANSWER_UPDATE)
    public Result insert() {
        return super.insert();
    }

    @Override
    @Transactional
    //@Pattern(Permission.PRE_QUESTION_ANSWER_UPDATE)
    public Result update() {
        return super.update();
    }

    @Override
    @Transactional
    //@Pattern(Permission.PRE_QUESTION_ANSWER_DELETE)
    public Result delete(Long id) {
        return super.delete(id);
    }
}
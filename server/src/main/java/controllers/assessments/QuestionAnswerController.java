//package controllers.assessments;
//
//import com.avaje.ebean.annotation.Transactional;
//import com.payAm.core.ebean.BaseDao;
//import com.payAm.core.ebean.RestController;
//import daos.assessments.QuestionAnswerDao;
//import dtos.assessments.QuestionAnswerView;
//import models.assessments.QuestionAnswerEntity;
//import play.mvc.Result;
//
//import javax.inject.Inject;
///**
// * Developer: Payam Mostafaei
// * Creation Time: 2017/Dec/08 - 14:03
// */
//public class QuestionAnswerController extends
//        RestController<QuestionAnswerEntity, Long, QuestionAnswerView> {
//
//    @Inject
//    private QuestionAnswerDao dao;
//
//    @Override
//    public BaseDao<Long, QuestionAnswerEntity> getDao() {
//        return dao;
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.QUESTION_ANSWER_UPDATE)
//    public Result insert() {
//        return super.insert();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.QUESTION_ANSWER_UPDATE)
//    public Result update() {
//        return super.update();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.QUESTION_ANSWER_DELETE)
//    public Result delete(Long id) {
//        return super.delete(id);
//    }
//}
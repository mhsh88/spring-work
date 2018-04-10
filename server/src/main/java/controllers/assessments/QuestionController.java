//package controllers.assessments;
//
//import com.avaje.ebean.annotation.Transactional;
//import com.payAm.core.ebean.BaseDao;
//import com.payAm.core.ebean.RestController;
//import daos.assessments.QuestionDao;
//import dtos.assessments.QuestionView;
//import models.assessments.QuestionEntity;
//import play.mvc.Result;
//
//import javax.inject.Inject;
///**
// * Developer: Payam Mostafaei
// * Creation Time: 2018/Jan/10 - 00:03
// */
//public class QuestionController extends
//        RestController<QuestionEntity, Long, QuestionView> {
//
//    @Inject
//    private QuestionDao dao;
//
//    @Override
//    public BaseDao<Long, QuestionEntity> getDao() {
//        return dao;
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.QUESTION_UPDATE)
//    public Result insert() {
//        return super.insert();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.QUESTION_UPDATE)
//    public Result update() {
//        return super.update();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.QUESTION_DELETE)
//    public Result delete(Long id) {
//        return super.delete(id);
//    }
//}
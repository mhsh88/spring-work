//package controllers.assessments;
//
//import com.avaje.ebean.annotation.Transactional;
//import com.payAm.core.ebean.BaseDao;
//import com.payAm.core.ebean.RestController;
//import daos.assessments.QuestionScopeDao;
//import dtos.assessments.QuestionScopeView;
//import models.assessments.QuestionScopeEntity;
//import play.mvc.Result;
//
//import javax.inject.Inject;
///**
// * Developer: Payam Mostafaei
// * Creation Time: 2018/Jan/10 - 00:03
// */
//public class QuestionScopeController extends
//        RestController<QuestionScopeEntity, Long, QuestionScopeView> {
//
//    @Inject
//    private QuestionScopeDao dao;
//
//    @Override
//    public BaseDao<Long, QuestionScopeEntity> getDao() {
//        return dao;
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.QUESTION_SCOPE_UPDATE)
//    public Result insert() {
//        return super.insert();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.QUESTION_SCOPE_UPDATE)
//    public Result update() {
//        return super.update();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.QUESTION_SCOPE_DELETE)
//    public Result delete(Long id) {
//        return super.delete(id);
//    }
//}
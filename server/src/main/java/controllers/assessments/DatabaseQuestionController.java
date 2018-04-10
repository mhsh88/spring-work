//package controllers.assessments;
//
//import com.avaje.ebean.annotation.Transactional;
//import com.payAm.core.ebean.BaseController;
//import com.payAm.core.ebean.BaseDao;
//import com.payAm.core.ebean.RestController;
//import daos.assessments.DatabaseQuestionDao;
//import dtos.assessments.DatabaseQuestionView;
//import models.assessments.DatabaseQuestionEntity;
//import play.mvc.Result;
//
//import javax.inject.Inject;
///**
// * Developer: Payam Mostafaei
// * Creation Time: 2017/Dec/08 - 14:03
// */
//public class DatabaseQuestionController extends
//        BaseController
//        /*RestController<DatabaseQuestionEntity, Long, DatabaseQuestionView>*/ {
////
////    @Inject
////    private DatabaseQuestionDao dao;
////
////    @Override
////    public BaseDao<Long, DatabaseQuestionEntity> getDao() {
////        return dao;
////    }
////
////    @Override
////    @Transactional
////    //@Pattern(Permission.DATABASE_QUESTION_UPDATE)
////    public Result insert() {
////        return super.insert();
////    }
////
////    @Override
////    @Transactional
////    //@Pattern(Permission.DATABASE_QUESTION_UPDATE)
////    public Result update() {
////        return super.update();
////    }
////
////    @Override
////    @Transactional
////    //@Pattern(Permission.DATABASE_QUESTION_DELETE)
////    public Result delete(Long id) {
////        return super.delete(id);
////    }
//}
//package controllers.assessments;
//
//import com.avaje.ebean.annotation.Transactional;
//import com.payAm.core.ebean.BaseDao;
//import com.payAm.core.ebean.RestController;
//import daos.assessments.PreQuestionDao;
//import dtos.assessments.PreQuestionView;
//import models.assessments.PreQuestionEntity;
//import play.mvc.Result;
//
//import javax.inject.Inject;
///**
// * Developer: Payam Mostafaei
// * Creation Time: 2017/Dec/08 - 14:03
// */
//public class PreQuestionController extends
//        RestController<PreQuestionEntity, Long, PreQuestionView> {
//
//    @Inject
//    private PreQuestionDao dao;
//
//    @Override
//    public BaseDao<Long, PreQuestionEntity> getDao() {
//        return dao;
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.PRE_QUESTION_UPDATE)
//    public Result insert() {
//        return super.insert();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.PRE_QUESTION_UPDATE)
//    public Result update() {
//        return super.update();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.PRE_QUESTION_DELETE)
//    public Result delete(Long id) {
//        return super.delete(id);
//    }
//}
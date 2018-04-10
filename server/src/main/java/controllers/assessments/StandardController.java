//package controllers.assessments;
//
//import com.avaje.ebean.annotation.Transactional;
//import com.payAm.core.ebean.BaseDao;
//import com.payAm.core.ebean.RestController;
//import daos.assessments.StandardDao;
//import dtos.assessments.StandardView;
//import models.assessments.StandardEntity;
//import play.mvc.Result;
//
//import javax.inject.Inject;
///**
// * Developer: Payam Mostafaei
// * Creation Time: 2018/Jan/10 - 00:03
// */
//public class StandardController extends
//        RestController<StandardEntity, Long, StandardView> {
//
//    @Inject
//    private StandardDao dao;
//
//    @Override
//    public BaseDao<Long, StandardEntity> getDao() {
//        return dao;
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.STANDARD_UPDATE)
//    public Result insert() {
//        return super.insert();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.STANDARD_UPDATE)
//    public Result update() {
//        return super.update();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.STANDARD_DELETE)
//    public Result delete(Long id) {
//        return super.delete(id);
//    }
//}
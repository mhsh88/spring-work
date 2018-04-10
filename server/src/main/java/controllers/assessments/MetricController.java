//package controllers.assessments;
//
//import com.avaje.ebean.annotation.Transactional;
//import com.payAm.core.ebean.BaseDao;
//import com.payAm.core.ebean.RestController;
//import daos.assessments.MetricDao;
//import dtos.assessments.MetricView;
//import models.assessments.MetricEntity;
//import play.mvc.Result;
//
//import javax.inject.Inject;
///**
// * Developer: Payam Mostafaei
// * Creation Time: 2017/Dec/08 - 14:03
// */
//public class MetricController extends
//        RestController<MetricEntity, Long, MetricView> {
//
//    @Inject
//    private MetricDao dao;
//
//    @Override
//    public BaseDao<Long, MetricEntity> getDao() {
//        return dao;
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.METRIC_UPDATE)
//    public Result insert() {
//        return super.insert();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.METRIC_UPDATE)
//    public Result update() {
//        return super.update();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.METRIC_DELETE)
//    public Result delete(Long id) {
//        return super.delete(id);
//    }
//}
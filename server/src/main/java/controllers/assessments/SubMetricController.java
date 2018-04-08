package controllers.assessments;

import com.avaje.ebean.annotation.Transactional;
import com.payAm.core.ebean.BaseDao;
import com.payAm.core.ebean.RestController;
import daos.assessments.SubMetricDao;
import dtos.assessments.SubMetricView;
import models.assessments.SubMetricEntity;
import play.mvc.Result;

import javax.inject.Inject;

/**
 * Developer: Payam Mostafaei
 * Creation Time: 2018/Jan/10 - 00:03
 */
public class SubMetricController extends 
        RestController<SubMetricEntity, Long, SubMetricView> {

    @Inject
    private SubMetricDao dao;

    @Override
    public BaseDao<Long, SubMetricEntity> getDao() {
        return dao;
    }

    @Override
    @Transactional
    //@Pattern(Permission.SUB_METRIC_UPDATE)
    public Result insert() {
        return super.insert();
    }

    @Override
    @Transactional
    //@Pattern(Permission.SUB_METRIC_UPDATE)
    public Result update() {
        return super.update();
    }

    @Override
    @Transactional
    //@Pattern(Permission.SUB_METRIC_DELETE)
    public Result delete(Long id) {
        return super.delete(id);
    }
}
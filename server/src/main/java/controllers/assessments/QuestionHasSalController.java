package controllers.assessments;

import com.avaje.ebean.annotation.Transactional;
import com.payAm.core.ebean.BaseDao;
import com.payAm.core.ebean.RestController;
import daos.assessments.QuestionHasSalDao;
import dtos.assessments.QuestionHasSalView;
import models.assessments.*;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

import static com.payAm.core.util.StringUtil.DOT;

/**
 * Developer: Payam Mostafaei
 * Creation Time: 2018/Jan/10 - 00:03
 */
public class QuestionHasSalController extends 
        RestController<QuestionHasSalEntity, Long, QuestionHasSalView> {

    @Inject
    private QuestionHasSalDao dao;

    @Override
    public BaseDao<Long, QuestionHasSalEntity> getDao() {
        return dao;
    }

    @Override
    @Transactional
    //@Pattern(Permission.QUESTION_HAS_SAL_UPDATE)
    public Result insert() {
        return super.insert();
    }

    @Override
    @Transactional
    //@Pattern(Permission.QUESTION_HAS_SAL_UPDATE)
    public Result update() {
        return super.update();
    }

    @Override
    @Transactional
    //@Pattern(Permission.QUESTION_HAS_SAL_DELETE)
    public Result delete(Long id) {
        return super.delete(id);
    }

    @Override
    protected List<String> getFetchedFields() {
        List<String> fields = super.getFetchedFields();
        fields.add(SalEntity.ENTITY + DOT + SalEntity.VALUE);
        fields.add(StandardEntity.ENTITY + DOT + StandardEntity.TEXT);
        fields.add(MetricEntity.ENTITY + DOT + MetricEntity.TEXT);
        fields.add(SubMetricEntity.ENTITY + DOT + SubMetricEntity.TEXT);
        fields.add(QuestionEntity.ENTITY + DOT + QuestionEntity.TEXT);
        fields.add(PreQuestionEntity.ENTITY + DOT + PreQuestionEntity.TEXT);
        return fields;
    }
}
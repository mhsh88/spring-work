package models.assessments;

import com.fasterxml.jackson.annotation.JsonView;
import com.payAm.core.model.BaseEntity;
import constants.assessments.QuestionHasSalConstants;
import dtos.assessments.QuestionHasSalView;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="question_has_sal")
public class QuestionHasSalEntity extends BaseEntity implements QuestionHasSalConstants {
	private static final long serialVersionUID = 1L;

	@JsonView(QuestionHasSalView.class)
	@ManyToOne
	@JoinColumn(name = "sal_id")
	public SalEntity sal;

	@JsonView(QuestionHasSalView.class)
	@ManyToOne
	@JoinColumn(name = "metric_id")
	public MetricEntity metric;

	@JsonView(QuestionHasSalView.class)
	@ManyToOne
	@JoinColumn(name = "sub_metric_id")
	public SubMetricEntity subMetric;

	@JsonView(QuestionHasSalView.class)
	@ManyToOne
	@JoinColumn(name = "question_id")
	public QuestionEntity question;

	@JsonView(QuestionHasSalView.class)
	@ManyToOne
	@JoinColumn(name = "pre_question_id")
	public PreQuestionEntity preQuestion;

	@JsonView(QuestionHasSalView.class)
	@ManyToOne
	@JoinColumn(name = "standard_id")
	public StandardEntity standard;

	@JsonView(QuestionHasSalView.class)
	public Integer priority;

	@JsonView(QuestionHasSalView.class)
	public Float weight;
}
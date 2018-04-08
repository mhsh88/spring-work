package models.assessments;

import com.fasterxml.jackson.annotation.JsonView;
import com.payAm.core.model.BaseEntity;
import constants.assessments.PreQuestionConstants;
import dtos.assessments.PreQuestionView;
import dtos.assessments.QuestionHasSalView;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="pre_question")
public class PreQuestionEntity extends BaseEntity implements PreQuestionConstants {
	private static final long serialVersionUID = 1L;

	@JsonView({PreQuestionView.class, QuestionHasSalView.class})
	@Lob
	public String text;

	@JsonView
	@OneToMany(mappedBy = "preQuestion")
	public List<QuestionHasSalEntity> questionHasSals;

	@JsonView
	@OneToMany(mappedBy = "preQuestion")
	public List<PreQuestionAnswerEntity> preQuestionAnswers;
}
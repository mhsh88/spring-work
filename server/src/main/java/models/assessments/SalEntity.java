package models.assessments;

import com.fasterxml.jackson.annotation.JsonView;
import com.payAm.core.model.BaseEntity;
import constants.assessments.SalConstants;
import dtos.assessments.AssessmentSalView;
import dtos.assessments.QuestionHasSalView;
import dtos.assessments.SalView;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "sal")
public class SalEntity extends BaseEntity implements SalConstants {
	private static final long serialVersionUID = 1L;

	@JsonView({SalView.class, AssessmentSalView.class, QuestionHasSalView.class})
	@Size(max = 45)
	public String value;

	@JsonView
	@OneToMany(mappedBy = "sal")
	public List<AssessmentSalEntity> assessmentSals;

	@JsonView
	@OneToMany(mappedBy = "sal")
	public List<QuestionHasSalEntity> questionHasSals;
}
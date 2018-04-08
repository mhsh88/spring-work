package models.assessments;

import com.fasterxml.jackson.annotation.JsonView;
import com.payAm.core.model.BaseEntity;
import constants.assessments.AssessmentSalConstants;
import dtos.assessments.AssessmentSalView;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="assessment_sal")
public class AssessmentSalEntity extends BaseEntity implements AssessmentSalConstants {
	private static final long serialVersionUID = 1L;

	@JsonView(AssessmentSalView.class)
	@ManyToOne
	@JoinColumn(name = "sal_id")
	public SalEntity sal;

	@JsonView
	@OneToMany(mappedBy = "assessmentSal")
	public List<OrganizationAssessmentEntity> organizationAssessments;

	@JsonView(AssessmentSalView.class)
	@Size(max = 45)
	public String accessibility;

	@JsonView(AssessmentSalView.class)
	@Column(name="capital_asset")
	public Float capitalAsset;

	@JsonView(AssessmentSalView.class)
	@Size(max = 45)
	public String confidentiality;

	@JsonView(AssessmentSalView.class)
	public Integer death;

	@JsonView(AssessmentSalView.class)
	@Column(name="economy_impact")
	public Float economyImpact;

	@JsonView(AssessmentSalView.class)
	@Column(name="environmental_clean_up")
	public Float environmentalCleanUp;

	@JsonView(AssessmentSalView.class)
	public Integer hospital;

	@JsonView(AssessmentSalView.class)
	public Integer injury;

	@JsonView(AssessmentSalView.class)
	@Size(max = 45)
	public String integrity;
}
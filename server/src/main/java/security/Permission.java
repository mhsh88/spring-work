package security;

/**
 * Developer: Payam Mostafaei
 * Creation Time: 2018/Jan/10 - 00:03
 */
public interface Permission {

    String ASSESSMENT_SAL_READ = "assessmentSal.read";
    String ASSESSMENT_SAL_UPDATE = "assessmentSal.update";
    String ASSESSMENT_SAL_DELETE = "assessmentSal.delete";

    String DATABASE_QUESTION_READ = "databaseQuestion.read";
    String DATABASE_QUESTION_UPDATE = "databaseQuestion.update";
    String DATABASE_QUESTION_DELETE = "databaseQuestion.delete";

    String METRIC_READ = "metric.read";
    String METRIC_UPDATE = "metric.update";
    String METRIC_DELETE = "metric.delete";

    String ORGANIZATION_ASSESSMENT_READ = "organizationAssessment.read";
    String ORGANIZATION_ASSESSMENT_UPDATE = "organizationAssessment.update";
    String ORGANIZATION_ASSESSMENT_DELETE = "organizationAssessment.delete";

    String ORGANIZATION_ASSESSMENT_HAS_QUESTION_READ = "organizationAssessmentHasQuestion.read";
    String ORGANIZATION_ASSESSMENT_HAS_QUESTION_UPDATE = "organizationAssessmentHasQuestion.update";
    String ORGANIZATION_ASSESSMENT_HAS_QUESTION_DELETE = "organizationAssessmentHasQuestion.delete";

    String PRE_QUESTION_ANSWER_READ = "preQuestionAnswer.read";
    String PRE_QUESTION_ANSWER_UPDATE = "preQuestionAnswer.update";
    String PRE_QUESTION_ANSWER_DELETE = "preQuestionAnswer.delete";

    String PRE_QUESTION_READ = "preQuestion.read";
    String PRE_QUESTION_UPDATE = "preQuestion.update";
    String PRE_QUESTION_DELETE = "preQuestion.delete";

    String QUESTION_ANSWER_READ = "questionAnswer.read";
    String QUESTION_ANSWER_UPDATE = "questionAnswer.update";
    String QUESTION_ANSWER_DELETE = "questionAnswer.delete";

    String QUESTION_READ = "question.read";
    String QUESTION_UPDATE = "question.update";
    String QUESTION_DELETE = "question.delete";

    String QUESTION_HAS_SAL_READ = "questionHasSal.read";
    String QUESTION_HAS_SAL_UPDATE = "questionHasSal.update";
    String QUESTION_HAS_SAL_DELETE = "questionHasSal.delete";

    String QUESTION_SCOPE_READ = "questionScope.read";
    String QUESTION_SCOPE_UPDATE = "questionScope.update";
    String QUESTION_SCOPE_DELETE = "questionScope.delete";

    String RESULT_DASHBOARD_READ = "resultDashboard.read";
    String RESULT_DASHBOARD_UPDATE = "resultDashboard.update";
    String RESULT_DASHBOARD_DELETE = "resultDashboard.delete";

    String RESULT_READ = "result.read";
    String RESULT_UPDATE = "result.update";
    String RESULT_DELETE = "result.delete";

    String SAL_READ = "sal.read";
    String SAL_UPDATE = "sal.update";
    String SAL_DELETE = "sal.delete";

    String STANDARD_READ = "standard.read";
    String STANDARD_UPDATE = "standard.update";
    String STANDARD_DELETE = "standard.delete";

    String SUB_METRIC_READ = "subMetric.read";
    String SUB_METRIC_UPDATE = "subMetric.update";
    String SUB_METRIC_DELETE = "subMetric.delete";

    String LINKED_ACCOUNT_READ = "linkedAccount.read";
    String LINKED_ACCOUNT_UPDATE = "linkedAccount.update";
    String LINKED_ACCOUNT_DELETE = "linkedAccount.delete";

    String ORGANIZATION_READ = "organization.read";
    String ORGANIZATION_UPDATE = "organization.update";
    String ORGANIZATION_DELETE = "organization.delete";

    String PERMISSION_READ = "permission.read";
    String PERMISSION_UPDATE = "permission.update";
    String PERMISSION_DELETE = "permission.delete";

    String ROLE_READ = "role.read";
    String ROLE_UPDATE = "role.update";
    String ROLE_DELETE = "role.delete";

    String TOKEN_ACTION_READ = "tokenAction.read";
    String TOKEN_ACTION_UPDATE = "tokenAction.update";
    String TOKEN_ACTION_DELETE = "tokenAction.delete";

    String USER_READ = "user.read";
    String USER_UPDATE = "user.update";
    String USER_DELETE = "user.delete";

}
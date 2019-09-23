package com.company.imtahan.projections;

import com.company.imtahan.entities.ExamQuestion;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author sarkhanrasullu
 */
@Projection(types = { ExamQuestion.class }) 
public interface ExamQuestionProjection extends AuditProjection, Switchable {
        Integer getId();
        String getTitle();
        String getQuestion();
        String getRightAnswer();
        ExamProjection getExamId();
        IdNameProjection getExamQuestionTypeId();
        Boolean getEnabled();
}

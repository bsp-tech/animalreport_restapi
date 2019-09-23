package com.company.imtahan.projections;

import com.company.imtahan.entities.Exam;
import java.math.BigDecimal;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author sarkhanrasullu
 */
@Projection(types = { Exam.class }) 
public interface ExamProjection extends AuditProjection, Switchable {
     Integer getId();
     String getName();
     byte[] getThumbnail();
     String getDescription();
     Boolean getEnabled();
     String getDuration();
     BigDecimal getPrice();
     IdNameProjection getSectorId();
     IdNameProjection getExamTypeId();
     String getClasses();
}

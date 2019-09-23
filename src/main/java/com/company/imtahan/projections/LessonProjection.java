    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.imtahan.projections;

import com.company.imtahan.entities.Lesson;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author sarkhanrasullu
 */
@Projection(types = { Lesson.class }) 
public interface LessonProjection extends AuditProjection {
     Integer getId();
     String getName();
}

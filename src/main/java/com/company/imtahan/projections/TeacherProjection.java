package com.company.imtahan.projections;

import com.company.imtahan.entities.Teacher;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author sarkhanrasullu
 */
@Projection(types = { Teacher.class }) 
public interface TeacherProjection  extends AuditProjection, Switchable {
     Integer getId();
     String getName();
     String getSurname();
     String getEmail();
     String getPhone();
     String getFacebook();
     String getInstagram();
     String getYoutube();
     byte[] getThumbnail();
     String getAddress();
     String getWebsite();
     String getDescription();
     IdNameProjection getCityId();
     IdNameProjection getUserId();
     
}

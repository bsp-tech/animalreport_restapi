/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.imtahan.projections;

import com.company.imtahan.entities.Announcement;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author sarkhanrasullu
 */
@Projection(types = { Announcement.class }) 
public interface AnnouncementProjection extends AuditProjection, Switchable {
    Integer getId();
    String getTitle();
    Integer getClassNo();
    BigDecimal getPrice();
    byte[] getThumbnail();
    String getDescription();
    Date getEndDate();
    IdNameProjection getLessonId();
    IdNameProjection getSectorId();
    IdNameProjection getUserId();
    IdNameProjection getTeacherId();
    IdNameProjection getCourseId();
    IdNameProjection getCityId();
}

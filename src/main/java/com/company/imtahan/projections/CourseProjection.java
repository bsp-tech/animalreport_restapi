/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.imtahan.projections;

import com.company.imtahan.entities.Course;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author sarkhanrasullu
 */
@Projection(types = {Course.class})
public interface CourseProjection  extends AuditProjection, Switchable {

    Integer getId();
    String getName();
    String getEmail();
    String getPhone();
    String getFacebook();
    String getInstagram();
    String getYoutube();
    byte[] getThumbnail();
    String getAddress();
    String getWebsite();
    String getDescription();
    CityProjection getCityId();
    IdNameProjection getUserId();
}

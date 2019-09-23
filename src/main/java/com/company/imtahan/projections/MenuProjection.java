/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.imtahan.projections;

import com.company.imtahan.entities.Menu;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author sarkhanrasullu
 */
@Projection(types = { Menu.class }) 
public interface MenuProjection extends AuditProjection, Switchable {
     Integer getId();
     String getName();
     String getUrl();
     Integer getOrderNo();
     IdNameProjection getLayoutTypeId();
     Boolean getIframe();
}

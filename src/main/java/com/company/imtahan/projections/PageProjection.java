package com.company.imtahan.projections;

import com.company.imtahan.entities.Page;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author sarkhanrasullu
 */
@Projection(types = { Page.class }) 
public interface PageProjection   extends AuditProjection, Switchable {
     Integer getId();
     String getName();
     String getPageBody();
}

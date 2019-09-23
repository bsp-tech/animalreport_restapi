package com.company.imtahan.projections;

import com.company.imtahan.entities.AdPage;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author sarkhanrasullu
 */
@Projection(types = { AdPage.class }) 
public interface AdPageProjection extends AuditProjection {
     Integer getId();
     PageProjection getPageId();
}

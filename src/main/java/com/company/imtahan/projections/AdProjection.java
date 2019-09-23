package com.company.imtahan.projections;

import com.company.imtahan.entities.Ad;
import java.util.Date;
import java.util.List;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author sarkhanrasullu
 */
@Projection(types = { Ad.class }) 
public interface AdProjection extends AuditProjection, Switchable {
    Integer getId();
    String getName();
    byte[] getLeftSide();
    String getLeftSideLink();
    byte[] getRightSide();
    String getRightSideLink();
    byte[] getUpSide();
    String getUpSideLink();
    byte[] getDownSide();
    String getDownSideLink();
    Date getEndDate();
    IdNameProjection getUserId();
    List<AdPageProjection> getAdPageList();
}

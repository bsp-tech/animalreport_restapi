package com.company.imtahan.projections;

import com.company.imtahan.entities.User;
import java.math.BigDecimal;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author sarkhanrasullu
 */
@Projection(types = { User.class }) 
public interface UserProjection extends AuditProjection, Switchable{
     Integer getId();
     String getName();
     String getSurname();
     Integer getAge();
     String getEmail();
     String getPhone();
     byte[] getThumbnail();
     String getAddress();
     BigDecimal getBalance();
     IdNameProjection getRoleId();
     IdNameProjection getCityId();
     
     Boolean getApproved();
}

package com.company.imtahan.projections;

import com.company.imtahan.entities.User;
import com.company.imtahan.entities.UserReport;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(types = {User.class})
public interface UserProjection extends CommonProjection {
    String getName();

    String getSurname();

    String getUsename();

    short getEnabled();

    String getEmail();
    
}

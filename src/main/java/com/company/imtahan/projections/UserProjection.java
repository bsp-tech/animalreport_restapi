package com.company.imtahan.projections;

import com.company.imtahan.entities.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {User.class})
public interface UserProjection extends CommonProjection {
    String getName();

    String getSurname();

    String getUsername();

    short getEnabled();

    String getEmail();

}

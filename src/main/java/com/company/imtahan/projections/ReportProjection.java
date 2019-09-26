package com.company.imtahan.projections;

import com.company.imtahan.entities.Report;
import com.company.imtahan.entities.Situation;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {Report.class})
public interface ReportProjection extends CommonProjection {
    String getLocation();

    byte[][] getVideo();

    byte[][] getImage();

    byte[][] getVideoAfterSolved();

    byte[][] getImageAfterSolved();

    String getDescription();

    String getDescriptionAfterSolved();

    Situation getSituationId();

    Situation getSituationIdAfterSolved();

}

package com.company.animalreport.projections;

import com.company.animalreport.entities.Report;
import com.company.animalreport.entities.Situation;
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

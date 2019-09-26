package com.company.imtahan.eventhandlers;

import com.company.imtahan.entities.Report;
import com.company.imtahan.repository.SituationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherEventHandler extends AbstractCommonRepositoryEventListener<Report> {
    @Autowired
    SituationRepository situationRepository;

    @Override
    public void onBeforeCreate(Report report) {
        try {
            setSituationId(report);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void setSituationId(Report report) {
        report.setSituationId(situationRepository.findById(new Integer(1)).get());
    }


}

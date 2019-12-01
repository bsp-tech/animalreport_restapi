package com.company.animalreport.projections;

import com.company.animalreport.entities.UserReport;

import java.util.Date;
import java.util.List;

public interface CommonProjection {
    Integer getId();

    String getContactNumber();

    Date getInsertDateTime();

    short getApproved();

    List<UserReport> getUserReportList();
}

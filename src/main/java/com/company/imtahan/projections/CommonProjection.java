package com.company.imtahan.projections;

import com.company.imtahan.entities.UserReport;

import java.util.Date;
import java.util.List;

public interface CommonProjection {
    Integer getId();

    String getContactNumber();

    Date getInsertDateTime();

    short getApproved();

    List<UserReport> getUserReportList();
}

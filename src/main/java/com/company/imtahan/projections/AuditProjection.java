/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.imtahan.projections;

import java.util.Date;

/**
 *
 * @author sarkhanrasullu
 */
public interface AuditProjection {

    IdNameProjection getInsertUserId();
    Date getInsertDate();
    Date getLastChangeDate();
}

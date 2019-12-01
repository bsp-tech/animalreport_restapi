/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.animalreport.repository;

/**
 * @author sarkhanrasullu
 */

import com.company.animalreport.entities.Report;
import com.company.animalreport.projections.ReportProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(excerptProjection = ReportProjection.class)
@Transactional
public interface ReportRepository extends JpaRepository<Report, Integer> {

}
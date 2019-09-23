/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.imtahan.repository;

/**
 *
 * @author sarkhanrasullu
 */

import com.company.imtahan.entities.Ad;
import com.company.imtahan.projections.AdProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(excerptProjection = AdProjection.class)
@Transactional
public interface AdRepository extends JpaRepository<Ad, Integer>{
    
}
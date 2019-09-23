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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.company.imtahan.entities.UserRole;
import com.company.imtahan.projections.IdNameProjection;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(excerptProjection = IdNameProjection.class)
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{
    
}
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

import com.company.imtahan.entities.Course;
import com.company.imtahan.projections.CourseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(excerptProjection = CourseProjection.class)
@Transactional
public interface CourseRepository extends JpaRepository<Course, Integer>{
    
}
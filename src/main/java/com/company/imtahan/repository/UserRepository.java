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
import com.company.imtahan.entities.User;
import com.company.imtahan.projections.UserProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(excerptProjection = UserProjection.class)
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{
    
    User findByEmail(String email);
    UserProjection getByEmail(String email);
    
    User findByForgotKey(String forgotKey);
    
    @Query("select u from User u where u.id=:id")
    User findByIdCustom(@Param("id") Integer id);
    
}
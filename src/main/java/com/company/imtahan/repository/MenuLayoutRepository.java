package com.company.imtahan.repository;

/**
 *
 * @author sarkhanrasullu
 */

import com.company.imtahan.entities.MenuLayoutType;
import com.company.imtahan.projections.IdNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(excerptProjection = IdNameProjection.class)
@Transactional
public interface MenuLayoutRepository extends JpaRepository<MenuLayoutType, Integer>{
    
}
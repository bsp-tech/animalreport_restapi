package com.company.animalreport.repository;

import com.company.animalreport.entities.User;
import com.company.animalreport.projections.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(excerptProjection = UserProjection.class)
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAndEnabled(String email, boolean enabled);
}

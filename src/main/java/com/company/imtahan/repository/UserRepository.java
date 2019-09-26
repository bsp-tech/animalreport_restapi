package com.company.imtahan.repository;

import com.company.imtahan.entities.User;
import com.company.imtahan.projections.ReportProjection;
import com.company.imtahan.projections.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(excerptProjection = UserProjection.class)
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
}

package com.company.animalreport.repository;

import com.company.animalreport.entities.AuthGroup;
import com.company.animalreport.entities.AuthGroupRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthGroupRoleDaoInter extends JpaRepository<AuthGroupRole, Integer> {
    List<AuthGroupRole> findByGroupId(AuthGroup group);
}

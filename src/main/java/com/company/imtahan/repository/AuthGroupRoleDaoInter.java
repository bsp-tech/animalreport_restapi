package com.company.imtahan.repository;

import com.company.imtahan.entities.AuthGroup;
import com.company.imtahan.entities.AuthGroupRole;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface AuthGroupRoleDaoInter extends JpaRepository<AuthGroupRole, Integer> {
    List<AuthGroupRole> findByGroupId(AuthGroup group);
}

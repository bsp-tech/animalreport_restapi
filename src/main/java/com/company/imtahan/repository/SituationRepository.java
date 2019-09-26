package com.company.imtahan.repository;

import com.company.imtahan.entities.Situation;
import com.company.imtahan.projections.ReportProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Projection(types = {Situation.class})
@Transactional
@Service
public interface SituationRepository extends JpaRepository<Situation, Integer> {
}

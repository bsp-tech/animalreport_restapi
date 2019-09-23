package com.company.imtahan.repository;

/**
 *
 * @author sarkhanrasullu
 */

import com.company.imtahan.entities.ExamQuestion;
import com.company.imtahan.projections.ExamQuestionProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource(excerptProjection = ExamQuestionProjection.class)
@Transactional
public interface ExamQuestionRepository extends JpaRepository<ExamQuestion, Integer>{

    @Query("select e from ExamQuestion e where e.examId.id=:examId")
    Page<ExamQuestion> getAllByExamId(@Param("examId") Integer examId, Pageable page);
}

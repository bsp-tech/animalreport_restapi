/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.imtahan.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author sarkhanrasullu
 */
@Entity
@Table(name = "exam_question")
public class ExamQuestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "question")
    private String question;
    
    @Column(name = "enabled")
    private Boolean enabled;
    
    @Size(max = 255)
    @Column(name = "right_answer")
    private String rightAnswer;
    
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    
    @Column(name = "insert_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    
    @Column(name = "last_change_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChangeDate;
    
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private Exam examId;
    
    @JoinColumn(name = "exam_question_type_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private ExamType examQuestionTypeId;
     
    @JoinColumn(name = "insert_user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User insertUserId;
    
    public ExamQuestion() {
    }

    public ExamQuestion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public Exam getExamId() {
        return examId;
    }

    public void setExamId(Exam examId) {
        this.examId = examId;
    }

    public ExamType getExamQuestionTypeId() {
        return examQuestionTypeId;
    }

    public void setExamQuestionTypeId(ExamType examQuestionTypeId) {
        this.examQuestionTypeId = examQuestionTypeId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public User getInsertUserId() {
        return insertUserId;
    }

    public void setInsertUserId(User insertUserId) {
        this.insertUserId = insertUserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamQuestion)) {
            return false;
        }
        ExamQuestion other = (ExamQuestion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.imtahan.entities.ExamQuestion[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.imtahan.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author sarkhanrasullu
 */
@Entity
@Table(name = "announcement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Announcement.findAll", query = "SELECT a FROM Announcement a")
    , @NamedQuery(name = "Announcement.findById", query = "SELECT a FROM Announcement a WHERE a.id = :id")
    , @NamedQuery(name = "Announcement.findByTitle", query = "SELECT a FROM Announcement a WHERE a.title = :title")
    , @NamedQuery(name = "Announcement.findByClassNo", query = "SELECT a FROM Announcement a WHERE a.classNo = :classNo")
    , @NamedQuery(name = "Announcement.findByPrice", query = "SELECT a FROM Announcement a WHERE a.price = :price")
    , @NamedQuery(name = "Announcement.findByThumbnail", query = "SELECT a FROM Announcement a WHERE a.thumbnail = :thumbnail")
    , @NamedQuery(name = "Announcement.findByEndDate", query = "SELECT a FROM Announcement a WHERE a.endDate = :endDate")
    , @NamedQuery(name = "Announcement.findByEnabled", query = "SELECT a FROM Announcement a WHERE a.enabled = :enabled")
    , @NamedQuery(name = "Announcement.findByInsertDate", query = "SELECT a FROM Announcement a WHERE a.insertDate = :insertDate")
    , @NamedQuery(name = "Announcement.findByLastChangeDate", query = "SELECT a FROM Announcement a WHERE a.lastChangeDate = :lastChangeDate")})
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @Column(name = "class_no")
    private Integer classNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Lob
    @Column(name = "thumbnail",length=100000)
    private byte[] thumbnail;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "insert_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    @Column(name = "last_change_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChangeDate;
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private Lesson lessonId;
    @JoinColumn(name = "sector_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private Sector sectorId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private User userId;
    @RestResource(exported = false)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacherId;
    @RestResource(exported = false)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Course courseId;
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private City cityId;
    @JoinColumn(name = "insert_user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private User insertUserId;

    public Announcement() {
    }

    public Announcement(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Lesson getLessonId() {
        return lessonId;
    }

    public void setLessonId(Lesson lessonId) {
        this.lessonId = lessonId;
    }

    public Sector getSectorId() {
        return sectorId;
    }

    public void setSectorId(Sector sectorId) {
        this.sectorId = sectorId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public User getInsertUserId() {
        return insertUserId;
    }

    public void setInsertUserId(User insertUserId) {
        this.insertUserId = insertUserId;
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
        if (!(object instanceof Announcement)) {
            return false;
        }
        Announcement other = (Announcement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.imtahan.entities.Announcement[ id=" + id + " ]";
    }
    
}

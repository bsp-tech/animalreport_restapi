/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.imtahan.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author sarkhanrasullu
 */
@Entity
@Table(name = "sector")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sector.findAll", query = "SELECT s FROM Sector s")
    , @NamedQuery(name = "Sector.findById", query = "SELECT s FROM Sector s WHERE s.id = :id")
    , @NamedQuery(name = "Sector.findByName", query = "SELECT s FROM Sector s WHERE s.name = :name")
    , @NamedQuery(name = "Sector.findByInsertUserId", query = "SELECT s FROM Sector s WHERE s.insertUserId = :insertUserId")
    , @NamedQuery(name = "Sector.findByInsertDate", query = "SELECT s FROM Sector s WHERE s.insertDate = :insertDate")
    , @NamedQuery(name = "Sector.findByLastChangeDate", query = "SELECT s FROM Sector s WHERE s.lastChangeDate = :lastChangeDate")})
public class Sector implements Serializable {

    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "sectorId", fetch = FetchType.LAZY)
    private List<Exam> examList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "insert_user_id")
    private Integer insertUserId;
    @Column(name = "insert_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    @Column(name = "last_change_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChangeDate;
    @OneToMany(mappedBy = "sectorId", fetch = FetchType.LAZY)
    private List<Announcement> announcementList;

    public Sector() {
    }

    public Sector(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getInsertUserId() {
        return insertUserId;
    }

    public void setInsertUserId(Integer insertUserId) {
        this.insertUserId = insertUserId;
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

    @XmlTransient
    @JsonIgnore
    public List<Announcement> getAnnouncementList() {
        return announcementList;
    }

    public void setAnnouncementList(List<Announcement> announcementList) {
        this.announcementList = announcementList;
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
        if (!(object instanceof Sector)) {
            return false;
        }
        Sector other = (Sector) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.imtahan.entities.Sector[ id=" + id + " ]";
    }


    @XmlTransient
    @JsonIgnore
    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

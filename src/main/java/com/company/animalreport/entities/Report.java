/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.animalreport.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Goshgar
 */
@Entity
@Table(name = "report")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r")
    , @NamedQuery(name = "Report.findById", query = "SELECT r FROM Report r WHERE r.id = :id")
    , @NamedQuery(name = "Report.findByLocation", query = "SELECT r FROM Report r WHERE r.location = :location")
    , @NamedQuery(name = "Report.findByContactNumber", query = "SELECT r FROM Report r WHERE r.contactNumber = :contactNumber")
    , @NamedQuery(name = "Report.findByDescription", query = "SELECT r FROM Report r WHERE r.description = :description")
    , @NamedQuery(name = "Report.findByInsertDateTime", query = "SELECT r FROM Report r WHERE r.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "Report.findBySolvedDateTime", query = "SELECT r FROM Report r WHERE r.solvedDateTime = :solvedDateTime")
    , @NamedQuery(name = "Report.findByApproved", query = "SELECT r FROM Report r WHERE r.approved = :approved")
    , @NamedQuery(name = "Report.findByDescriptionAfterSolved", query = "SELECT r FROM Report r WHERE r.descriptionAfterSolved = :descriptionAfterSolved")})
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "video")
    private byte[] video;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "contact_number")
    private String contactNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "solved_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date solvedDateTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "approved")
    private short approved;
    @Size(max = 500)
    @Column(name = "description_after_solved")
    private String descriptionAfterSolved;
    @Lob
    @Column(name = "video_after_solved")
    private byte[] videoAfterSolved;
    @Lob
    @Column(name = "image_after_solved")
    private byte[] imageAfterSolved;
    @JoinColumn(name = "situation_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Situation situationId;
    @JoinColumn(name = "situation_id_after_solved", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Situation situationIdAfterSolved;
    @OneToMany(mappedBy = "reportId", fetch = FetchType.LAZY)
    private List<UserReport> userReportList;

    public Report() {
    }

    public Report(Integer id) {
        this.id = id;
    }

    public Report(Integer id, byte[] video, String location, String contactNumber, String description, Date insertDateTime, short approved) {
        this.id = id;
        this.video = video;
        this.location = location;
        this.contactNumber = contactNumber;
        this.description = description;
        this.insertDateTime = insertDateTime;
        this.approved = approved;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public Date getSolvedDateTime() {
        return solvedDateTime;
    }

    public void setSolvedDateTime(Date solvedDateTime) {
        this.solvedDateTime = solvedDateTime;
    }

    public short getApproved() {
        return approved;
    }

    public void setApproved(short approved) {
        this.approved = approved;
    }

    public String getDescriptionAfterSolved() {
        return descriptionAfterSolved;
    }

    public void setDescriptionAfterSolved(String descriptionAfterSolved) {
        this.descriptionAfterSolved = descriptionAfterSolved;
    }

    public byte[] getVideoAfterSolved() {
        return videoAfterSolved;
    }

    public void setVideoAfterSolved(byte[] videoAfterSolved) {
        this.videoAfterSolved = videoAfterSolved;
    }

    public byte[] getImageAfterSolved() {
        return imageAfterSolved;
    }

    public void setImageAfterSolved(byte[] imageAfterSolved) {
        this.imageAfterSolved = imageAfterSolved;
    }

    public Situation getSituationId() {
        return situationId;
    }

    public void setSituationId(Situation situationId) {
        this.situationId = situationId;
    }

    public Situation getSituationIdAfterSolved() {
        return situationIdAfterSolved;
    }

    public void setSituationIdAfterSolved(Situation situationIdAfterSolved) {
        this.situationIdAfterSolved = situationIdAfterSolved;
    }

    @XmlTransient
    @JsonIgnore
    public List<UserReport> getUserReportList() {
        return userReportList;
    }

    public void setUserReportList(List<UserReport> userReportList) {
        this.userReportList = userReportList;
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
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.animalreport.entities.Report[ id=" + id + " ]";
    }
    
}

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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author sarkhanrasullu
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
    , @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id")
    , @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name")
    , @NamedQuery(name = "Course.findByEmail", query = "SELECT c FROM Course c WHERE c.email = :email")
    , @NamedQuery(name = "Course.findByPhone", query = "SELECT c FROM Course c WHERE c.phone = :phone")
    , @NamedQuery(name = "Course.findByFacebook", query = "SELECT c FROM Course c WHERE c.facebook = :facebook")
    , @NamedQuery(name = "Course.findByInstagram", query = "SELECT c FROM Course c WHERE c.instagram = :instagram")
    , @NamedQuery(name = "Course.findByYoutube", query = "SELECT c FROM Course c WHERE c.youtube = :youtube")
    , @NamedQuery(name = "Course.findByThumbnail", query = "SELECT c FROM Course c WHERE c.thumbnail = :thumbnail")
    , @NamedQuery(name = "Course.findByAddress", query = "SELECT c FROM Course c WHERE c.address = :address")
    , @NamedQuery(name = "Course.findByWebsite", query = "SELECT c FROM Course c WHERE c.website = :website")
    , @NamedQuery(name = "Course.findByEnabled", query = "SELECT c FROM Course c WHERE c.enabled = :enabled")
    , @NamedQuery(name = "Course.findByInsertDate", query = "SELECT c FROM Course c WHERE c.insertDate = :insertDate")
    , @NamedQuery(name = "Course.findByLastChangeDate", query = "SELECT c FROM Course c WHERE c.lastChangeDate = :lastChangeDate")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "phone")
    private String phone;
    @Size(max = 255)
    @Column(name = "facebook")
    private String facebook;
    @Size(max = 255)
    @Column(name = "instagram")
    private String instagram;
    @Size(max = 255)
    @Column(name = "youtube")
    private String youtube;
    @Lob
    @Column(name = "thumbnail", length = 100000)
    private byte[] thumbnail;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "website")
    private String website;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "insert_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    @Column(name = "last_change_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChangeDate;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private User userId;
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private City cityId;
    @JoinColumn(name = "insert_user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private User insertUserId;
    @OneToMany(mappedBy = "courseId", fetch = FetchType.LAZY)
    private List<Announcement> announcementList;

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.imtahan.entities.Course[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.imtahan.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author sarkhanrasullu
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "surname")
    private String surname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;
    @Lob
    @Column(name = "thumbnail")
    private byte[] thumbnail;
    @Size(max = 4)
    @Column(name = "forgot_key")
    private String forgotKey;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private List<ExamQuestion> examQuestionList;
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private List<Exam> examList;

    private static final long serialVersionUID = 1L;
    @RestResource(exported = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "age")
    private Integer age;
    @Column(name = "approved")
    private Boolean approved;
    @Column(name = "enabled")
    private Boolean enabled;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "insert_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    @Column(name = "last_change_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChangeDate;
    @RestResource(exported = false)
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Ad> adList;
    @RestResource(exported = false)
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private List<Ad> adList1;
    @RestResource(exported = false)
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private List<Lesson> lessonList;
    @RestResource(exported = false)
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Teacher> teacherList;
    @RestResource(exported = false)
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private List<Teacher> teacherList1;
    @RestResource(exported = false)
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Course> courseList;
    @RestResource(exported = false)
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private List<Course> courseList1;
    @RestResource(exported = false)
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private List<Page> pageList;
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private UserRole roleId;
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private City cityId;
    @RestResource(exported = false)
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private List<User> userList;
    
    @RestResource(exported = false)
    @JoinColumn(name = "insert_user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User insertUserId;
    @RestResource(exported = false)
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Transaction> transactionList;
    @RestResource(exported = false)
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private List<Transaction> transactionList1;
    @RestResource(exported = false)
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Announcement> announcementList;
    @RestResource(exported = false)
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private List<Announcement> announcementList1;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String name, String surname, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String getForgotKey() {
        return forgotKey;
    }

    public void setForgotKey(String forgotKey) {
        this.forgotKey = forgotKey;
    }


    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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
    public List<Ad> getAdList() {
        return adList;
    }

    public void setAdList(List<Ad> adList) {
        this.adList = adList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Ad> getAdList1() {
        return adList1;
    }

    public void setAdList1(List<Ad> adList1) {
        this.adList1 = adList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Teacher> getTeacherList1() {
        return teacherList1;
    }

    public void setTeacherList1(List<Teacher> teacherList1) {
        this.teacherList1 = teacherList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Course> getCourseList1() {
        return courseList1;
    }

    public void setCourseList1(List<Course> courseList1) {
        this.courseList1 = courseList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Page> getPageList() {
        return pageList;
    }

    public void setPageList(List<Page> pageList) {
        this.pageList = pageList;
    }

    public UserRole getRoleId() {
        return roleId;
    }

    public void setRoleId(UserRole roleId) {
        this.roleId = roleId;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    @XmlTransient
    @JsonIgnore
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getInsertUserId() {
        return insertUserId;
    }

    public void setInsertUserId(User insertUserId) {
        this.insertUserId = insertUserId;
    }

    @XmlTransient
    @JsonIgnore
    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Transaction> getTransactionList1() {
        return transactionList1;
    }

    public void setTransactionList1(List<Transaction> transactionList1) {
        this.transactionList1 = transactionList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Announcement> getAnnouncementList() {
        return announcementList;
    }

    public void setAnnouncementList(List<Announcement> announcementList) {
        this.announcementList = announcementList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Announcement> getAnnouncementList1() {
        return announcementList1;
    }

    public void setAnnouncementList1(List<Announcement> announcementList1) {
        this.announcementList1 = announcementList1;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.imtahan.entities.User[ id=" + id + " ]";
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @XmlTransient
    @JsonIgnore
    public List<ExamQuestion> getExamQuestionList() {
        return examQuestionList;
    }

    public void setExamQuestionList(List<ExamQuestion> examQuestionList) {
        this.examQuestionList = examQuestionList;
    }
    
}

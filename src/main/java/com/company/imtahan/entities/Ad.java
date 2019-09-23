package com.company.imtahan.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "ad")
public class Ad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    
    @Lob
    @Column(name = "left_side",length=100000)
    private byte[] leftSide;
    
    @Lob
    @Column(name = "left_side_link",length=100000)
    private String leftSideLink;
    
    @Lob
    @Column(name = "right_side",length=100000)
    private byte[] rightSide;
    
    @Size(max = 255)
    @Column(name = "right_side_link")
    private String rightSideLink;
    
    @Lob
    @Column(name = "up_side",length=100000)
    private byte[] upSide;
    
    @Size(max = 255)
    @Column(name = "up_side_link")
    private String upSideLink;

    @Lob
    @Column(name = "down_side",length=100000)
    private byte[] downSide;
    
    @Size(max = 255)
    @Column(name = "down_side_link")
    private String downSideLink;
    
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
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private User userId;
    @JoinColumn(name = "insert_user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private User insertUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adId", fetch = FetchType.LAZY)
    @RestResource(exported = false)
    private List<AdPage> adPageList;

    public Ad() {
    }

    public Ad(Integer id) {
        this.id = id;
    }

    public Ad(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public byte[] getLeftSide() {
        return leftSide;
    }

    public void setLeftSide(byte[] leftSide) {
        this.leftSide = leftSide;
    }

    public String getLeftSideLink() {
        return leftSideLink;
    }

    public void setLeftSideLink(String leftSideLink) {
        this.leftSideLink = leftSideLink;
    }

    public byte[] getRightSide() {
        return rightSide;
    }

    public void setRightSide(byte[] rightSide) {
        this.rightSide = rightSide;
    }

    public String getRightSideLink() {
        return rightSideLink;
    }

    public void setRightSideLink(String rightSideLink) {
        this.rightSideLink = rightSideLink;
    }

    public byte[] getUpSide() {
        return upSide;
    }

    public void setUpSide(byte[] upSide) {
        this.upSide = upSide;
    }

    public String getUpSideLink() {
        return upSideLink;
    }

    public void setUpSideLink(String upSideLink) {
        this.upSideLink = upSideLink;
    }

    public byte[] getDownSide() {
        return downSide;
    }

    public void setDownSide(byte[] downSide) {
        this.downSide = downSide;
    }

    public String getDownSideLink() {
        return downSideLink;
    }

    public void setDownSideLink(String downSideLink) {
        this.downSideLink = downSideLink;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public User getInsertUserId() {
        return insertUserId;
    }

    public void setInsertUserId(User insertUserId) {
        this.insertUserId = insertUserId;
    }

    @XmlTransient
    @JsonIgnore
    public List<AdPage> getAdPageList() {
        return adPageList;
    }

    public void setAdPageList(List<AdPage> adPageList) {
        this.adPageList = adPageList;
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
        if (!(object instanceof Ad)) {
            return false;
        }
        Ad other = (Ad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.imtahan.entities.Ad[ id=" + id + " ]";
    }
    
}

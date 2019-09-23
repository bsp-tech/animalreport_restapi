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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sarkhanrasullu
 */
@Entity
@Table(name = "ad_page")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdPage.findAll", query = "SELECT a FROM AdPage a")
    , @NamedQuery(name = "AdPage.findById", query = "SELECT a FROM AdPage a WHERE a.id = :id")
    , @NamedQuery(name = "AdPage.findByInsertUserId", query = "SELECT a FROM AdPage a WHERE a.insertUserId = :insertUserId")
    , @NamedQuery(name = "AdPage.findByInsertDate", query = "SELECT a FROM AdPage a WHERE a.insertDate = :insertDate")
    , @NamedQuery(name = "AdPage.findByLastChangeDate", query = "SELECT a FROM AdPage a WHERE a.lastChangeDate = :lastChangeDate")})
public class AdPage implements Serializable {

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
    @JoinColumn(name = "ad_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ad adId;
    @JoinColumn(name = "page_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Page pageId;

    public AdPage() {
    }

    public AdPage(Integer id) {
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

    public Ad getAdId() {
        return adId;
    }

    public void setAdId(Ad adId) {
        this.adId = adId;
    }

    public Page getPageId() {
        return pageId;
    }

    public void setPageId(Page pageId) {
        this.pageId = pageId;
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
        if (!(object instanceof AdPage)) {
            return false;
        }
        AdPage other = (AdPage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.imtahan.entities.AdPage[ id=" + id + " ]";
    }
    
}

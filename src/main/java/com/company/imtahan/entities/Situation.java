/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.imtahan.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Goshgar
 */
@Entity
@Table(name = "situation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Situation.findAll", query = "SELECT s FROM Situation s")
    , @NamedQuery(name = "Situation.findById", query = "SELECT s FROM Situation s WHERE s.id = :id")
    , @NamedQuery(name = "Situation.findByName", query = "SELECT s FROM Situation s WHERE s.name = :name")})
public class Situation implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "situationId", fetch = FetchType.LAZY)
    private List<Report> reportList;
    @OneToMany(mappedBy = "situationIdAfterSolved", fetch = FetchType.LAZY)
    private List<Report> reportList1;

    public Situation() {
    }

    public Situation(Integer id) {
        this.id = id;
    }

    public Situation(Integer id, String name) {
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

    @XmlTransient
    @JsonIgnore
    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Report> getReportList1() {
        return reportList1;
    }

    public void setReportList1(List<Report> reportList1) {
        this.reportList1 = reportList1;
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
        if (!(object instanceof Situation)) {
            return false;
        }
        Situation other = (Situation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.imtahan.entities.Situation[ id=" + id + " ]";
    }
    
}

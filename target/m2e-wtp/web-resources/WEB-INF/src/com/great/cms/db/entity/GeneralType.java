/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.great.cms.db.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.stereotype.Component;

/**
 *
 * @author sss
 */
@Component
@Entity
@Table(name = "general_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneralType.findAll", query = "SELECT g FROM GeneralType g"),
    @NamedQuery(name = "GeneralType.findByGeneralTypeId", query = "SELECT g FROM GeneralType g WHERE g.generalTypeId = :generalTypeId"),
    @NamedQuery(name = "GeneralType.findByType", query = "SELECT g FROM GeneralType g WHERE g.type = :type")})
public class GeneralType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "general_type_id")
    private Integer generalTypeId;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalTypeId")
    private List<Course> courseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalTypeId")
    private List<Room> roomList;

    public GeneralType() {
    }

    public GeneralType(Integer generalTypeId) {
        this.generalTypeId = generalTypeId;
    }

    public GeneralType(Integer generalTypeId, String type) {
        this.generalTypeId = generalTypeId;
        this.type = type;
    }

    public Integer getGeneralTypeId() {
        return generalTypeId;
    }

    public void setGeneralTypeId(Integer generalTypeId) {
        this.generalTypeId = generalTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @XmlTransient
    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (generalTypeId != null ? generalTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneralType)) {
            return false;
        }
        GeneralType other = (GeneralType) object;
        if ((this.generalTypeId == null && other.generalTypeId != null) || (this.generalTypeId != null && !this.generalTypeId.equals(other.generalTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.great.cms.db.entity.GeneralType[ generalTypeId=" + generalTypeId + " ]";
    }
    
}

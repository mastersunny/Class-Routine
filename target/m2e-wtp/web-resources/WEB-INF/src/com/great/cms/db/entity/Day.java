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
@Table(name = "day")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Day.findAll", query = "SELECT d FROM Day d"),
    @NamedQuery(name = "Day.findByDayId", query = "SELECT d FROM Day d WHERE d.dayId = :dayId"),
    @NamedQuery(name = "Day.findByDayName", query = "SELECT d FROM Day d WHERE d.dayName = :dayName")})
public class Day implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "day_id")
    private Integer dayId;
    @Basic(optional = false)
    @Column(name = "day_name")
    private String dayName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dayId")
    private List<MainRoutine> mainRoutineList;

    public Day() {
    }

    public Day(Integer dayId) {
        this.dayId = dayId;
    }

    public Day(Integer dayId, String dayName) {
        this.dayId = dayId;
        this.dayName = dayName;
    }

    public Integer getDayId() {
        return dayId;
    }

    public void setDayId(Integer dayId) {
        this.dayId = dayId;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    @XmlTransient
    public List<MainRoutine> getMainRoutineList() {
        return mainRoutineList;
    }

    public void setMainRoutineList(List<MainRoutine> mainRoutineList) {
        this.mainRoutineList = mainRoutineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dayId != null ? dayId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Day)) {
            return false;
        }
        Day other = (Day) object;
        if ((this.dayId == null && other.dayId != null) || (this.dayId != null && !this.dayId.equals(other.dayId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.great.cms.db.entity.Day[ dayId=" + dayId + " ]";
    }
    
}

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
    @NamedQuery(name = "Room.findByRoomId", query = "SELECT r FROM Room r WHERE r.roomId = :roomId"),
    @NamedQuery(name = "Room.findByRoomNum", query = "SELECT r FROM Room r WHERE r.roomNum = :roomNum"),
    @NamedQuery(name = "Room.findByLabRoom", query = "SELECT r FROM Room r WHERE r.labRoom = :labRoom")})
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "room_id")
    private Integer roomId;
    @Basic(optional = false)
    @Column(name = "room_num")
    private int roomNum;
    @Basic(optional = false)
    @Column(name = "hour")
    private int hour;
    @Basic(optional = false)
    @Column(name = "lab_room")
    private boolean labRoom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private List<MainRoutine> mainRoutineList;
    @JoinColumn(name = "general_type_id", referencedColumnName = "general_type_id")
    @ManyToOne(optional = false)
    private GeneralType generalTypeId;
    @JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
    @ManyToOne(optional = false)
    private Department deptId;
    @JoinColumn(name = "building_id", referencedColumnName = "building_id")
    @ManyToOne(optional = false)
    private Building buildingId;

    public Room() {
    }

    public Room(Integer roomId) {
        this.roomId = roomId;
    }

    public Room(Integer roomId, int roomNum, boolean labRoom) {
        this.roomId = roomId;
        this.roomNum = roomNum;
        this.labRoom = labRoom;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
    
    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public boolean getLabRoom() {
        return labRoom;
    }

    public void setLabRoom(boolean labRoom) {
        this.labRoom = labRoom;
    }

    @XmlTransient
    public List<MainRoutine> getMainRoutineList() {
        return mainRoutineList;
    }

    public void setMainRoutineList(List<MainRoutine> mainRoutineList) {
        this.mainRoutineList = mainRoutineList;
    }

    public GeneralType getGeneralTypeId() {
        return generalTypeId;
    }

    public void setGeneralTypeId(GeneralType generalTypeId) {
        this.generalTypeId = generalTypeId;
    }

    public Department getDeptId() {
        return deptId;
    }

    public void setDeptId(Department deptId) {
        this.deptId = deptId;
    }

    public Building getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Building buildingId) {
        this.buildingId = buildingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomId != null ? roomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.roomId == null && other.roomId != null) || (this.roomId != null && !this.roomId.equals(other.roomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.great.cms.db.entity.Room[ roomId=" + roomId + " ]";
    }
    
}

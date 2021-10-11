/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.great.cms.db.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "main_routine")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "MainRoutine.findAll", query = "SELECT m FROM MainRoutine m"),
		@NamedQuery(name = "MainRoutine.findByMainRoutineId", query = "SELECT m FROM MainRoutine m WHERE m.mainRoutineId = :mainRoutineId"),
		@NamedQuery(name = "MainRoutine.findByStartTime", query = "SELECT m FROM MainRoutine m WHERE m.startTime = :startTime"),
		@NamedQuery(name = "MainRoutine.findByEndTime", query = "SELECT m FROM MainRoutine m WHERE m.endTime = :endTime") })
public class MainRoutine implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "main_routine_id")
	private Integer mainRoutineId;
	@Basic(optional = false)
	@Column(name = "start_time")
	private int startTime;
	@Basic(optional = false)
	@Column(name = "end_time")
	private int endTime;
	@JoinColumn(name = "teaches_id", referencedColumnName = "teaches_id")
	@ManyToOne(optional = false)
	private Teaches teachesId;
	@JoinColumn(name = "room_id", referencedColumnName = "room_id")
	@ManyToOne(optional = false)
	private Room roomId;
	@JoinColumn(name = "exam_committee_id", referencedColumnName = "exam_committee_id")
	@ManyToOne(optional = false)
	private ExamCommittee examCommitteeId;
	@JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
	@ManyToOne(optional = false)
	private Department deptId;
	@JoinColumn(name = "day_id", referencedColumnName = "day_id")
	@ManyToOne(optional = false)
	private Day dayId;

	public MainRoutine() {
	}

	public MainRoutine(Integer mainRoutineId) {
		this.mainRoutineId = mainRoutineId;
	}

	public MainRoutine(Integer mainRoutineId, int startTime, int endTime) {
		this.mainRoutineId = mainRoutineId;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Integer getMainRoutineId() {
		return mainRoutineId;
	}

	public void setMainRoutineId(Integer mainRoutineId) {
		this.mainRoutineId = mainRoutineId;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public Teaches getTeachesId() {
		return teachesId;
	}

	public void setTeachesId(Teaches teachesId) {
		this.teachesId = teachesId;
	}

	public Room getRoomId() {
		return roomId;
	}

	public void setRoomId(Room roomId) {
		this.roomId = roomId;
	}

	public ExamCommittee getExamCommitteeId() {
		return examCommitteeId;
	}

	public void setExamCommitteeId(ExamCommittee examCommitteeId) {
		this.examCommitteeId = examCommitteeId;
	}

	public Department getDeptId() {
		return deptId;
	}

	public void setDeptId(Department deptId) {
		this.deptId = deptId;
	}

	public Day getDayId() {
		return dayId;
	}

	public void setDayId(Day dayId) {
		this.dayId = dayId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (mainRoutineId != null ? mainRoutineId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof MainRoutine)) {
			return false;
		}
		MainRoutine other = (MainRoutine) object;
		if ((this.mainRoutineId == null && other.mainRoutineId != null)
				|| (this.mainRoutineId != null && !this.mainRoutineId.equals(other.mainRoutineId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "MainRoutine [mainRoutineId=" + mainRoutineId + ", startTime=" + startTime + ", endTime=" + endTime
				+ "]";
	}

}

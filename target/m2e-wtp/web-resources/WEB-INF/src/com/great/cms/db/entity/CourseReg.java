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

/**
 *
 * @author sss
 */
@Component
@Entity
@Table(name = "course_reg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseReg.findAll", query = "SELECT c FROM CourseReg c"),
    @NamedQuery(name = "CourseReg.findByCourseRegId", query = "SELECT c FROM CourseReg c WHERE c.courseRegId = :courseRegId"),
    @NamedQuery(name = "CourseReg.findByIsApproved", query = "SELECT c FROM CourseReg c WHERE c.isApproved = :isApproved"),
    @NamedQuery(name = "CourseReg.findByMarks", query = "SELECT c FROM CourseReg c WHERE c.marks = :marks"),
    @NamedQuery(name = "CourseReg.findByGpa", query = "SELECT c FROM CourseReg c WHERE c.gpa = :gpa")})
public class CourseReg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "course_reg_id")
    private Long courseRegId;
    @Basic(optional = false)
    @Column(name = "is_approved")
    private boolean isApproved;
    @Basic(optional = false)
    @Column(name = "marks")
    private double marks;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GPA")
    private Double gpa;
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    @ManyToOne(optional = false)
    private Student studentId;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ManyToOne(optional = false)
    private Course courseId;

    public CourseReg() {
    }

    public CourseReg(Long courseRegId) {
        this.courseRegId = courseRegId;
    }

    public CourseReg(Long courseRegId, boolean isApproved, double marks) {
        this.courseRegId = courseRegId;
        this.isApproved = isApproved;
        this.marks = marks;
    }

    public Long getCourseRegId() {
        return courseRegId;
    }

    public void setCourseRegId(Long courseRegId) {
        this.courseRegId = courseRegId;
    }

    public boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseRegId != null ? courseRegId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseReg)) {
            return false;
        }
        CourseReg other = (CourseReg) object;
        if ((this.courseRegId == null && other.courseRegId != null) || (this.courseRegId != null && !this.courseRegId.equals(other.courseRegId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.great.cms.db.entity.CourseReg[ courseRegId=" + courseRegId + " ]";
    }
    
}

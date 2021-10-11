/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.great.cms.generator;

/**
 *
 * @author Saif_sust
 */
public class CourseInfo {
    
    private final String Name;
    private final int CourseId;
    private final int classHour;
    private final int NumOfClassInWeek;
    private final  int batch;
    private  int Islab;
   
    public CourseInfo(int CourseId,String Name,int classHour,int NumOfClassInWeek,int batch,int IsLab)
    {
        this.CourseId = CourseId;
        this.Name = Name;
        this.classHour = classHour;
        this.NumOfClassInWeek = NumOfClassInWeek;
        this.batch = batch;
        this.Islab = IsLab;
    }
    public int getIslab()
    {
        return this.Islab;
    }
    public int getBatch()
    {
        return this.batch;
    }
    public int getClassHour()
    {
        return this.classHour;
    }
    public int getNumOfClassInWeek()
    {
        return this.NumOfClassInWeek;
    }
    public String getCourseName()
    {
        return this.Name;
    }
    public int getCourseId()
    {
        return this.CourseId;
    }
}

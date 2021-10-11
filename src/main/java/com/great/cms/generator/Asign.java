/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.great.cms.generator;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Saif_sust
 */
public class Asign {
    private Mapper map = new Mapper();
    private FileWriter  fileWriter;
    private File file;
    private BufferedWriter buffer;
    public  static String dir="DataBase\\asing.txt";
    private int size,teacherNum;
    private Scanner inp;
    private String Name ;
    public Asign()
    {
        map.MapCourse();
        map.MapTeacher();
        //UserInputForCourseAsignTeacher();
    }
    
    public void UserInputForCourseAsignTeacher()
    {
        boolean test = false;
            
        try{
        inp = new Scanner(System.in);
        buffer = getBuffer();
        System.out.println(">>>How Many Courses In This Semester<<<<");
       size =inp.nextInt();
       
       buffer.write(Integer.toString(size));
       buffer.newLine();
       
       
       int count=0,teacherNum;
       
       while(true)
       {
           System.out.println("Input course Name");
          Name = inp.next();
          
          
           if(map.getCourseId(Name)==-1) 
           {
               System.out.println("course is not found in database");
               continue;
           }
           /*
           if(map.getCourseId(Name)/10==0)
           buffer.write("0"+Integer.toString(map.getCourseId(Name)));
           else buffer.write(Integer.toString(map.getCourseId(Name)));*/
           
           
           
           buffer.write(Name);
           buffer.write(" ");
           
           //System.out.println(">>>>>>How many teacher for this Course<<<<<");
          // teacherNum = inp.nextInt();
           teacherNum =1;
           
           //if(teacherNum/10==0)
             // buffer.write("0"+Integer.toString(teacherNum));
               buffer.write("0"+Integer.toString(teacherNum));
           //else
          // buffer.write(Integer.toString(teacherNum));
           buffer.write(" ");
           
           int teacherCount=0;
           
            System.out.println("Input teacher Name");
            
            
           while(true)
           {
              
               Name = inp.next();
               
               if(map.getTeacherId(Name)==-1)
               {
                   System.out.println("Teacher is not found in DataBase");
                   continue;
               }
               /*
               if(map.getTeacherId(Name)/10==0)
                   buffer.write("0"+Integer.toString(map.getTeacherId(Name)));
               else buffer.write(Integer.toString(map.getTeacherId(Name)));
 */            buffer.write(Name);
               buffer.write(" ");
               
               
               teacherCount++;
               if(teacherCount==teacherNum) break;
           }
           
           buffer.newLine();
           count++;
           if(count==size) break;
           
       }
       
     /// open();
        
        System.out.println("Please wait .Running Routine making process............");
         buffer.close();
        }catch(Exception e)
        {
            System.out.println("Wrong Input !. Please Input a Integer for Total Course Information");
            e.printStackTrace();
        }
        
    }
    public void open() throws IOException
    {
        Desktop desk = Desktop.getDesktop();
        if(file.exists())
        {
            desk.open(file);
        }
    }
    public BufferedWriter getBuffer()
    {
        try{
            file = new File(dir);
            file.createNewFile();
        fileWriter = new FileWriter(file);
        buffer = new BufferedWriter(fileWriter);
        return buffer;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
       
    }
        
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.great.cms.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Saif_sust
 */
public class Input {
    
    private Scanner inp;
    private  File file;
    private FileReader reader;
    private BufferedReader buffer;
    public static String dir;
    
    public  Scanner inp() 
    {
        try{
            
            file = new File(dir);
            reader = new FileReader(file);
            buffer = new BufferedReader(reader);
            inp=new Scanner(buffer);
            return inp;
            
        }catch(Exception e)
        {
            e.printStackTrace();;
            return null;
        }
         
    }
    
}

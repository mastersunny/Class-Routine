/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.great.cms.generator;

import java.text.DateFormatSymbols;
import java.util.HashMap;

/**
 *
 * @author Saif_sust
 */
public class Day {
    private static int index;
    private final static String[] day= new DateFormatSymbols().getWeekdays();
    public static String getDay(int dayId)
    {
        switch(dayId)
        {
            case 0: return day[6];
            case 1: return day[7];
            default : return day[dayId-1];
        }
    }
    
    
}

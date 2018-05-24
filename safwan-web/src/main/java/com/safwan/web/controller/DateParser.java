package com.safwan.web.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

	public static void main(String[] args) { 

        String dateStr = "2011-11-19"; 


        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 

            Date date; 

            try { 
           date = dateFormat.parse(dateStr); 
          System.out.println(date); 

            } catch (ParseException e) { 

 
            } 


}}

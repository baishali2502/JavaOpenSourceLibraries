package com.firstmavenproject.openCsvUser1;
import java.util.*;
import java.nio.*;
import java.nio.file.*;
import java.io.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class Main {

	public static void main(String[] args) 
	{
		 String csvFilePath = "C:\\Users\\KIIT\\OneDrive\\Desktop\\users.csv";

	        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
	            // Build CsvToBean object
	            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder<CSVUser>(reader)
	                    .withType(CSVUser.class)
	                    .build();

	            // Parse CSV into a list of User objects
	            List<CSVUser> users = csvToBean.parse();

	            // Display the parsed User objects
	            for (CSVUser user : users) {
	                System.out.println(user.toString());
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	}

}

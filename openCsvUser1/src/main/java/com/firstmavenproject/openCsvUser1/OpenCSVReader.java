package com.firstmavenproject.openCsvUser1;
import com.opencsv.*;
import com.opencsv.exceptions.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;



public class OpenCSVReader 
{
	String csvFilePath = "C:\\Users\\KIIT\\OneDrive\\Desktop\\users.csv";
	
    //---------------------------------- UC-1 ----------------------------------------
	
	/*
	 * @desc:Reading records one by one in a String array
	 * 
	 * @params:none
	 * 
	 * @returns:void
	 */
	void read()
	{
			try {
				Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
				CSVReader csvReader = new CSVReader(reader);
				
				String[] records;
				while((records=csvReader.readNext())!=null)
				{
					System.out.println("Name : "+records[0]);
					System.out.println("Email : "+records[1]);
					System.out.println("Phone : "+records[2]);
					System.out.println("Country : "+records[3]);
					System.out.println("-------------------------------------------------");
				}
			} catch (IOException | CsvValidationException e) {
				e.printStackTrace();
			}	
	}
	/*
	 * @desc:Reading all records at once into a List<String[]>
	 * 
	 * @params:none
	 * 
	 * @returns:void
	 */
	void readAllAtOnce()
	{
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			CSVReader csvReader = new CSVReader(reader);
			
			List<String[]> records = csvReader.readAll();
			
			for(String[] record:records)
			{
				System.out.println("Name : "+record[0]);
				System.out.println("Email : "+record[1]);
				System.out.println("Phone : "+record[2]);
				System.out.println("Country : "+record[3]);
				System.out.println("-------------------------------------------------");
			}
			
		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}
		
	}
	

}

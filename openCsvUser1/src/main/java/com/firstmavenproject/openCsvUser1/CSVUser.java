package com.firstmavenproject.openCsvUser1;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.util.List;

public class CSVUser 
{
	@CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "Email")
    private String email;

    @CsvBindByName(column = "Phone")
    private String phone;

    @CsvBindByName(column = "Country")
    private String country;

    // Default constructor
    public CSVUser() {
    }

    // Parameterized constructor
    public CSVUser(String name, String email, String phone, String country) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.country = country;
    }

    // Override toString for easier debugging
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
    
	/*
	 * @desc:This method writes into the csv file
	 * 
	 * @params:csv file path and the list of users to be added
	 * 
	 * @returns:void
	 */
    static void writeDataToCSV(String csvFilePath, List<CSVUser> users) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFilePath))) {
            // Writing the header
            String[] header = {"Name", "Email", "Phone", "Country"};
            csvWriter.writeNext(header);

            // Writing data
            for (CSVUser user : users) {
                String[] data = {user.name, user.email, user.phone, user.country};
                csvWriter.writeNext(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.firstmavenproject.openCsvUser1;

import com.opencsv.bean.CsvBindByName;

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

}

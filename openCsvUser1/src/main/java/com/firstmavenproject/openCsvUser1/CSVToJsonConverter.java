package com.firstmavenproject.openCsvUser1;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

//---------------------------------------------- UC-5 --------------------------------------------------
/*
 * @desc:The CSVToJsonConverter class contains two methods: 
	  readFromCSV for reading data from a CSV file, 
      and writeToJSON for writing data to a JSON file.
 */     
public class CSVToJsonConverter 
{
	/**
     * @desc:Reads data from a CSV file and converts it into a list of User objects.
     *
     * @param:csvFilePath The path to the CSV file.
     * @return:A list of CSVUser objects representing the data from the CSV file.
     */
    private static List<CSVUser> readFromCSV(String csvFilePath) {
        List<CSVUser> users = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            String[] record;
            // Skip the header row
            csvReader.readNext();

            while ((record = csvReader.readNext()) != null) {
                CSVUser user = new CSVUser(record[0], record[1], record[2], record[3]);
                users.add(user);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return users;
    }
    
    /**
     * @desc:Writes a list of User objects to a JSON file.
     *
     * @param:jsonFilePath The path to the JSON file.
     * @param:The list of User objects to be written to the JSON file.
     */
    private static void writeToJSON(String jsonFilePath, List<CSVUser> users) {
        ObjectMapper objectMapper = new ObjectMapper();

        try (FileWriter fileWriter = new FileWriter(jsonFilePath)) {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(fileWriter, users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

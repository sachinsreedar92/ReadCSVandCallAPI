package com.cleartrip.extranet;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class sa {
    private static final String SAMPLE_CSV_FILE_PATH = "/home/sachin/Desktop/ta_cta.csv";
    private static final String FILE_NAME = "/home/sachin/Desktop/new_tac.txt";
    

    public static void main(String[] args) throws IOException {
    	File file = new File(FILE_NAME);
        try (
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_NAME));
        		CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("Hotel_ID", "TA_ID"));

        ) {
        	
        	
        	FileWriter writers = new FileWriter(file);
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String name = csvRecord.get(0);
                String email = csvRecord.get(1);
                String Query = "UPDATE PLACES.HOTEL_RATING_MAP SET TA_HOTEL_ID="+csvRecord.get(0) +"where hotel_id="+csvRecord.get(1);
                
                writers.write(Query);
                	 
                
            }
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    
    
    }
}

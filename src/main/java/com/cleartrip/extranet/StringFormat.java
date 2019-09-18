package com.cleartrip.extranet;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringFormat {

	private static String query = "UPDATE PLACES.HOTEL_RATING_MAP SET TA_HOTEL_ID=? where hotel_id=?;";
	public static void main(String[] args) {
		
		Path pathToFile = Paths.get("/home/sachin/Desktop/ta_cta.csv");
		 String updateQuery = "";
		 int count = 0;
		// TODO Auto-generated method stub
		try (BufferedReader br = Files.newBufferedReader(pathToFile,
               StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			
			 while (line != null) {
				 String[] attributes = line.split(",");
				 if (attributes.length == 6) {
					 
					 updateQuery = query;
					 updateQuery = updateQuery.replaceFirst("\\?", attributes[0]);
					 updateQuery = updateQuery.replaceFirst("\\?", attributes[1]);
		    			System.out.println(count + "):" + updateQuery);
					 System.out.println(updateQuery);
					 count ++;
					 
				 }
				
				 line = br.readLine();
			 }
			// System.out.println(query);
		}catch (IOException ioe) {
           ioe.printStackTrace();
       }
       

	}

}

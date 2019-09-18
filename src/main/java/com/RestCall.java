package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import com.opencsv.CSVReader;

public class RestCall {

	public static void main(String[] args) {

		HttpURLConnection connection = null;
		String url = null;
		CSVReader trips = null;
		String[] tripIds;
		String name = "sachin";
		String password = "Sachin";

		String authString = name + ":" + password;
		System.out.println("auth string: " + authString);
		byte[] encodedBytes = Base64.getEncoder().encode(authString.getBytes());
		String authStringEnc = new String(encodedBytes);
		System.out.println("Base64 encoded auth string: " + authStringEnc);
		String originalString = new String(Base64.getDecoder().decode(encodedBytes));
		System.out.println(originalString);
		try {

			url = new String("http://localhost:9048/cityId=");

			trips = new CSVReader(new FileReader("/home/sachinsridhar/Desktop/query_result4.csv"));

			while ((tripIds = trips.readNext()) != null) {

				for (int i = 0; i < tripIds.length; i++) {
					String a = url + tripIds[i];
					URL b = new URL(a);
				    connection = (HttpURLConnection) b.openConnection();
				    connection.setRequestProperty("Content-Type", 
				            "application/x-www-form-urlencoded");
				    connection.setRequestMethod("POST");
				    connection.getResponseMessage();
				    System.out.println(connection.getResponseCode());
					System.out.println("Connected URL: " + connection.getURL());
				    }

			}

			trips.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
		    if (connection != null) {
		      connection.disconnect();
		    }
		  }

	}

}

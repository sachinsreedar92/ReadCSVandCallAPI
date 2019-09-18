package com.cleartrip.extranet;

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
		String name = "sachin.sridhar@cleartrip.com";
		String password = "Sachin@123!";

		String authString = name + ":" + password;
		System.out.println("auth string: " + authString);
		byte[] encodedBytes = Base64.getEncoder().encode(authString.getBytes());
		String authStringEnc = new String(encodedBytes);
		System.out.println("Base64 encoded auth string: " + authStringEnc);
		String originalString = new String(Base64.getDecoder().decode(encodedBytes));
		System.out.println(originalString);
		try {

			url = new String("http://172.21.48.21:9048/hotels/ctb-admin/cache?action=loadChmmByCity&cityId=");

			trips = new CSVReader(new FileReader("/home/sachinsridhar/Desktop/query_result4.csv"));

			while ((tripIds = trips.readNext()) != null) {

				for (int i = 0; i < tripIds.length; i++) {
					String a = url + tripIds[i];
					URL b = new URL(a);
				    connection = (HttpURLConnection) b.openConnection();
				    connection.setRequestProperty("Content-Type", 
				            "application/x-www-form-urlencoded");
				    connection.setRequestMethod("POST");
				    //connection.setRequestProperty("X-CT-SOURCETYPE", "API");
				    //connection.setRequestProperty("X-CT-API-KEY","7049c5cab71ee3803d5878fec81b3fc4");
					//connection.setRequestProperty("Authorization", "Basic " + authStringEnc);
					//connection.setRequestProperty("Cookie", "ct-auth=MzSh2oQX6MqFxmJ4u8axdRe6NxTk89MxKUYR2oFpe%2BR%2B%2F%2F9nsow30DAROMtR1vAQjxf2BMCCNhUwZlF%2BZAau5uqO9nQM6VdCNqUZgt83kjOgKOJTzoUyyJJothF8PferPZMN4%2BWh8USk9GgV5i4mEh%2BVFvedDvxj1dRTzx4KYthgaM%2BhMh5TtYjiZ7cdoqaF20GmfKbZY91Y%2FcmpIQVdWXzlzGBQO%2BQ4uNISCuhaHU5hE9kRtuEEYYDFsuMwZ7Oejp9A%2Bq5I9TLLUuE3ftU5xEUkDqOz7qQQklUaSlAqSaa4R%2BerstP1B%2BaY6BaJT%2BGTjK852tpntJaF%2F%2BahVnwdGl0jHCWqIsuKaHiGZTDCgHJq%2Fm2IEg9bP3wozyNuin61N2%2BymAoaAb%2F8WZJakLb%2FqJEpPaSHjPvkcGFSJgqthn9T80BQQuj5cyLmrwd5iE4j23CuDSzOSQ%2BFtZo%2Bn9OGJGN0Ubxy2U1wewslquxBmsx3VbIQBtWluiY3ZH2tZJ2m5usANHptPl%2BCP5C9QiGYYcV1z%2B9f0IcyF4YUXz5gE%2BxZYxXRvJyjj0xS5I5Nkh%2FrIsaemCNqPabLI2jj4UGvRRwHBQtURd7WGlVm65zXE5rz1yDJY%2B%2BGicEkCQIVfgSkrNRPQdq3R4xBdpzL%2F4jDbi%2BBHtTp1PBeazU57F7oICsYmhNcfwGZHxnKfOevACRftmdpO0fB%2F4Oa2Ek8qntNSXKVVq7Dejk51BSxu2qDrMxt8%2BCBpB9MF9r2TVYDpKKscTBIzEtDUE9o%2Fac49ZxAX3sQ9eaorRL87OCiZMHZsYSJRalh%2BXLaD42Q3%2FtNWgLh");
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

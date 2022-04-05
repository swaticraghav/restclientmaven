package com.http.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.core.utils.Constant;

public class DeleteById {

	static int id = 4218;

	public static void main(String[] args) {

		try {

			URL url = new URL("https://gorest.co.in/public/v2/users/" + id
					+ "?access-token=6da23e3a63892ad9a5ab59d8edb7175482ad4e5c531e4835e90ef3f29f5e4f0b");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(Constant.DELETE);
			conn.setRequestProperty(Constant.ACCEPT, Constant.APPLICATION_JSON);

			if (conn.getResponseCode() != HttpURLConnection.HTTP_NO_CONTENT) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			System.out.println("Deleted \n");

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}

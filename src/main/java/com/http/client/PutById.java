package com.http.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.core.pojo.Model;
import com.core.utils.Constant;
import com.google.gson.Gson;

public class PutById {

	static int id = 4165;

	public static void main(String[] args) {

		try {

			URL url = new URL("https://gorest.co.in/public/v2/users/" + id
					+ "?access-token=6da23e3a63892ad9a5ab59d8edb7175482ad4e5c531e4835e90ef3f29f5e4f0b");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(Constant.PUT);
			conn.setRequestProperty(Constant.CONTENT_TYPE, Constant.APPLICATION_JSON);

			Model model = new Model();
			model.setName("Don Pavk");
			model.setGender("Male");
			model.setEmail("main@com");
			model.setStatus("Active");

			OutputStream os = conn.getOutputStream();
			os.write(new Gson().toJson(model).toString().getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

}

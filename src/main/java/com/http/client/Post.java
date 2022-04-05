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

public class Post {

	public static void main(String[] args) {

		try {

			URL url = new URL(Constant.POST_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(Constant.POST);
			conn.setRequestProperty(Constant.CONTENT_TYPE, Constant.APPLICATION_JSON);

			Model model = new Model();
			model.setName("mPO Bane");
			model.setGender("Male");
			model.setEmail("LJ@com");
			model.setStatus("Active");

			OutputStream os = conn.getOutputStream();
			os.write(new Gson().toJson(model).toString().getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
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

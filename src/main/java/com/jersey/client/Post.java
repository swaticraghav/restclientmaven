package com.jersey.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.core.pojo.Model;
import com.core.utils.Constant;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class Post {

	public static void main(String[] args) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource webResource = client.resource(UriBuilder.fromUri(Constant.POST_URL).build());

		Model model = new Model();
		model.setName("Mira Bane");
		model.setGender("Female");
		model.setEmail("kem.cho@com");
		model.setStatus("Active");

		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, new Gson().toJson(model));
		System.out.println("Response - " + response.getEntity(String.class));
	}
}

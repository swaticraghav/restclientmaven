package com.jersey.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.core.utils.Constant;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class GetAll {

	public static void main(String[] args) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(UriBuilder.fromUri(Constant.GET_ALL_URL).build());

		System.out.println(service.accept(MediaType.APPLICATION_JSON).get(String.class));

	}

}

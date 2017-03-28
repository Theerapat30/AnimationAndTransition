package com.vogella.jersey.first.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class Test {

	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();
		
		Client client = ClientBuilder.newClient((Configuration) config);
		WebTarget target = client.target(getBaseURI());
	}
	
	private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/com.vogella.jersey.first").build();
}
}

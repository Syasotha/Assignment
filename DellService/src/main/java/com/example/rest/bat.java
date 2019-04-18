package com.example.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/cool")
public class bat {

	@GET

	public String sayhe() {
		return "Hi";
	}

}

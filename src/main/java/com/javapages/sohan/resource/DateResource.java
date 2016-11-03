package com.javapages.sohan.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.javapages.sohan.model.MyDate;

@Path("/date")
public class DateResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{dateParam}")
	public String test(@PathParam("dateParam") MyDate date) {
		return date.toString();
	}

	@POST
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public MyDate test2(MyDate date) {
		return date;
	}

}
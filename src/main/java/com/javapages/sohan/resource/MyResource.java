package com.javapages.sohan.resource;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class MyResource {

	public static final String MEDIA_TYPE_SHORT_DATE = "text/shortdate";
	private int count;

	@PathParam("pathParam")
	private String pathParam;

	@QueryParam("queryParam")
	private String queryParam;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{pathParam}")
	public String testCount() {
		return "Got it!!! " + ++count + ", Path param: " + pathParam + ", Query Param: " + queryParam;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Date testDate() {
		return Calendar.getInstance().getTime();
	}

	@GET
	@Produces(MEDIA_TYPE_SHORT_DATE)
	public Date testDate2() {
		return Calendar.getInstance().getTime();
	}

}

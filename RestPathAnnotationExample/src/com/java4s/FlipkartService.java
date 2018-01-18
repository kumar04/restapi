package com.java4s;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/flipkart")
public class FlipkartService {

	@GET
	@Path("store/{clothing}/{size}")
	public String searchProduct(@PathParam("clothing") String clothing, @MatrixParam("gender") String gender,
			@MatrixParam("color") String color, @PathParam("size") String size) {
		return "You habe slected the " + clothing + "Size = " + size + " Gender=" + gender + " color:" + color;
	}
}

package org.apache.hadoop.hbase.rest;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.apache.hadoop.hbase.rest.model.ShuntingModel;

import java.io.IOException;

public class ShuntingResource extends ResourceBase {
	public ShuntingResource() throws IOException {
		super();
	}

	@GET
	@Produces({MIMETYPE_TEXT, MIMETYPE_JSON})
	public Response get(final @Context ServletContext context,
			final @Context UriInfo uriInfo) {
		ResponseBuilder response = Response.ok(new ShuntingModel());
		return response.build();
	}
}

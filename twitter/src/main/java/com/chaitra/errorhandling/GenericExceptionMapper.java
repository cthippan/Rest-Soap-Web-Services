package com.chaitra.errorhandling;



import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

//@Provider

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {// generic type exception,throwable
	//catches all exceptions

	@Override
	public Response toResponse(Throwable ex) {
		// TODO Auto-generated method stub
		ErrorMessageClass error = new ErrorMessageClass(500, ex.getMessage(),
				"http://www.oracle.com/technetwork/articles/java/jax-rs-159890.html");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(error).build();

	}

}

package com.chaitra.subresource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {

	@GET
	public String getAllcomments() {
		return "comments";
	}

	@GET
	public String getcomment(@PathParam("tweetID") Long id, @PathParam("commentId") int commentId) {
		return "commentID:" + commentId + "tweetID:" + id;
	}
}


package com.chaitra.twitter;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.chaitra.subresource.CommentResource;
@Path("/twitter")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class twitterResource {
	twitterService t = new twitterService();

	@GET
	public List<tweet> getallmessages() {
		return t.getTweetslist();
	}

	@GET
	public List<tweet> getallmessagesForYear(@BeanParam BeanFilterParam filterparam) {
		if (filterparam.getYear() >= 0) {
			return t.getTweetforYear(filterparam.getYear());
		}
		if (filterparam.getStart() >= 0 && filterparam.getSize() >= 0) {
			return t.getPaginatedTweets(filterparam.getStart(), filterparam.getSize());
		}
		return null;

	}

	@POST
	// Response is used to set the status and location in header
	public Response addMessage(@Context UriInfo uriInfo, tweet msg) {
		tweet newtweet = t.addTweet(msg);
		String newid = String.valueOf(newtweet.getId());
		// to the complete uri with root .. localhost..message..messageid
		URI uri = uriInfo.getAbsolutePathBuilder().path(newid).build();
		return Response.created(uri).entity(newtweet).build();
	}

	@PUT
	@Path("/{tweetid}")

	public tweet updateMessage(@PathParam("tweetid") Long id, tweet msg) {
		msg.setId(id);
		return t.updateTweet(msg);
	}

	@DELETE
	@Path("/{tweetid}")

	public void deletetweet(@PathParam("tweetid") Long id) {
		t.deleteTweet(id);
	}

	@GET
	@Path("/{tweetid}/comment")
	public CommentResource getcomments() {
		return new CommentResource();
	}

	// HATEOS ---adding resource links and reference

	@GET
	@Path("/{tweetID}")

	public tweet test(@PathParam("tweetID") Long tweetID, @Context UriInfo uriInfo) {
		tweet tweet = t.getTweet(tweetID);
		tweet.addlink(getUriforSelf(uriInfo, tweet), "self");
		tweet.addlink(getUriforComment(uriInfo, tweet), "comment");
		return tweet;
	}

	private String getUriforComment(UriInfo uriInfo, tweet tweet) {
		URI uri = uriInfo.getBaseUriBuilder().path(twitterResource.class)
				// for subResources you need to use .path(class name,method
				// from which you need to pull the annotation for sub resource)
				.path(twitterResource.class, "getcomments").path(CommentResource.class).path(tweet.getAuthor())
				// to replace the id inside the uri whenever you run the diff
				// uri
				.resolveTemplate("tweetid", tweet.getId()).build();
		return uri.toString();
	}

	public String getUriforSelf(UriInfo uriInfo, tweet tweet) {
		URI uri = uriInfo.getBaseUriBuilder().path(twitterResource.class).path(tweet.getAuthor()).build();
		return uri.toString();
	}

}

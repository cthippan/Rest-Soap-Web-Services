package org.chaitra.twitter;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "TweetIndex", targetNamespace = "http://twitter.chaitra.org/", endpointInterface = "org.chaitra.twitter.twitterInterface")
public interface twitterInterface {

	@WebMethod(action = "Fetchall", operationName = "fetch_All")
	public List<String> getMessageType();

	@WebMethod(action = "Fetchall", operationName = "fetch_All")
	public List<String> getTweets(String type);

	@WebMethod(action = "Fetchall", operationName = "fetch_All")
	public boolean addTweet(String type, String message);

	@WebMethod(action = "Fetchall", operationName = "fetch_All")
	@WebResult(name = "tweet")
	public List<tweet> getTweetDetails();
}

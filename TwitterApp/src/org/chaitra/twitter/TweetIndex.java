package org.chaitra.twitter;

import java.util.List;

import javax.jws.WebService;

@WebService(serviceName = "TwitterService", portName = "TweetIndexPort")
public class TweetIndex implements twitterInterface {
	TweetServiceImpl twitterService = new TweetServiceImpl();

	@Override
	public List<String> getMessageType() {
		return twitterService.getMessageType();
	}

	@Override
	public List<String> getTweets(String type) {
		return twitterService.getTweets(type);
	}

	@Override
	public boolean addTweet(String type, String message) {
		return twitterService.addTweet(type, message);
	}

	@Override
	public List<tweet> getTweetDetails() {
		return twitterService.getTweetDetails();
	}
}

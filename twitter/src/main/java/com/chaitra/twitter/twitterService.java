package com.chaitra.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.chaitra.errorhandling.ErrorMessageClass;
import com.chaitra.twitterDatabase.DatabaseClass;

public class twitterService {
	public static Map<Long, tweet> tweet = DatabaseClass.getTweets();

	public twitterService() {
		tweet message1 = new tweet(1, "hi", "chaitra");
		tweet message2 = new tweet(2, "hello", "prashanth");
		// TODO Auto-generated constructor stub
		tweet.put(1L, message1);
		tweet.put(2L, message2);
	}

	public List<tweet> getTweetslist() {
		return new ArrayList(tweet.values());

	}

	public tweet getTweet(Long id) {
		ErrorMessageClass error = new ErrorMessageClass(500, "not found", "https://javabrains.io/courses/javaee_jaxrs");
		Response response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(error).build();

		if (tweet.get(id) == null) {
			throw new WebApplicationException(response);
		}
		return tweet.get(id);
	}

	public tweet addTweet(tweet msg) {
		msg.setId(tweet.size() + 1L);
		tweet.put(msg.getId(), msg);

		return msg;
	}

	public tweet updateTweet(tweet msg) {

		tweet.put(msg.getId(), msg);
		return msg;
	}

	public String deleteTweet(Long id) {

		tweet.remove(id);
		return "msg deleted!";
	}

	public List<tweet> getPaginatedTweets(int start, int size) {

		List<tweet> list = new ArrayList<>(tweet.values());
		if (size + start > list.size()) {
			return new ArrayList<tweet>();
		}
		return list.subList(start, start + size);
	}

	@SuppressWarnings("deprecation")
	public List<tweet> getTweetforYear(int year) {
		List<tweet> tweets = new ArrayList<>(tweet.values());
		List<tweet> tweetforYear = new ArrayList<>();
		for (tweet msg : tweets) {
			if (msg.getDate().getYear() == year) {
				tweetforYear.add(msg);
			}
		}
		return tweetforYear;
	}
}

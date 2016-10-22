package org.chaitra.twitter;

import java.util.ArrayList;
import java.util.List;

public class TweetServiceImpl {

	List<String> status = new ArrayList<>();
	List<String> privatemessage = new ArrayList<>();
	List<String> other = new ArrayList<>();

	public TweetServiceImpl() {
		
		status.add("example status");
		privatemessage.add("private message example");
		other.add("other message");
	}

	public List<String> getMessageType() {
		List<String> type = new ArrayList<>();
		type.add("CurrentStatus");
		type.add("PrivateMessage");
		type.add("other");
		return type;
	}
	public List<String> getStatus() {

		status.add("web service");
		status.add("soap");
		status.add("hello");
		return status;
	}

	public List<String> getMessage() {

		privatemessage.add("private message1");
		privatemessage.add("private message2");
		privatemessage.add("private message3");
		return privatemessage;
	}

	public List<String> getOther() {

		other.add("advertisement");
		other.add("spam");
		other.add("links");
		return other;
	}

	public boolean addTweet(String type,String message){
		if (type.toLowerCase() == "status")
			status.add(message);
		else if (type.toLowerCase() == "message")
			 privatemessage.add(message);
		else if (type.toLowerCase() == "other")
			 other.add(message);
		else
			return false;

		return true;
	}
	
	public List<String> getTweets(String type) {
		
		switch (type.toLowerCase()) {
		case "currentstatus":
			return getStatus();

		case "privatemessage":
			return  getMessage();

		case "other":
			return getOther();

		default:
			
			break;
			
		}
		return null;
	
		
		

	}

	public List<tweet> getTweetDetails() {
		List<tweet> TweetList=new ArrayList<>();
		TweetList.add(new tweet(1, "chaitra","hi"));
		TweetList.add(new tweet(2,"thippana","hello"));
		return TweetList;
	}
}

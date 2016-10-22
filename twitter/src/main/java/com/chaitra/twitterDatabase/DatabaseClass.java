package com.chaitra.twitterDatabase;

import java.util.HashMap;
import java.util.Map;

import com.chaitra.twitter.tweet;

public class DatabaseClass {
public static Map<Long,tweet> tweets=new HashMap<>();

public static  Map<Long, tweet> getTweets(){
	return tweets;
}
}

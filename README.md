# Twitter Map

I. File list:
TopTweets.java                Java object for top hashtags
TwitterLocations.java         Java object for twitter location information
GetLocationsDao.java          Get the geological locations of a specific twitter hashtag from database
GetTopsDao.java               Get the top twitter hashtags of a specific state name from database
DbConnection.java             Connect to Cassandra database 
GetHashtags.java              Pass search result of top twitter hashtags to webpage through http servlet requests
GetLocations.java             Pass search result of twitter locations to webpage through http servlet requests
heat.jsp                      Create heat map using Google Map API
ht.jsp                        Get user input and return top hashtags
index.jsp                     Webpage layout
web.xml                       Map servlet and web objects

II. Design:


##License Information

Copyright (c) 2016, Liuqing Yang

All rights reserved.

All files are licensed under GPL.

https://github.com/lyang1024/twittermap/LICENSE

##Limitations and Bugs


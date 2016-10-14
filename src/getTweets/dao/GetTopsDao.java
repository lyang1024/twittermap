package getTweets.dao;
//import java.util.*;
import com.datastax.driver.core.*;

import getTweets.dbc.*;
import bean.*;

public class GetTopsDao {
//	private Cluster cluster;
	private ResultSet rs;
	private DbConnection connect;
	public GetTopsDao(){
		connect = new DbConnection();
	}
	public TopTweets getTopTweets(TopTweets tts){
		String statename = tts.getStatename();
		//System.out.println("state name: ");
		//System.out.println(statename);
		//System.out.println("state name length:");
		//System.out.println(Integer.toString(statename.length()));
		String query = "SELECT * FROM twitter.hashtags WHERE statename = '"+statename+"';";
		try {
//			DbConnection connect = new DbConnection();
			connect.connect();
			System.out.println("connected to db");
			rs = connect.executeAndGetResult1(query);
			String re = null;
			for (Row rows: rs){
				re=rows.getString("hashtag");
		    }
			System.out.println("result:");
			System.out.println(re);
//		    String result1 = re.substring(1);
//		    List<String> result1 = new ArrayList<String>(Arrays.asList(htstring.split("_")));
		    tts.setHashtags(re);
		}catch (Exception e){
			System.out.println("Failed to retrieve data from Cassandra!");
		}finally{
			if(connect!=null){
				try{
					connect.close();
				}catch(Exception e){
					
				}
				connect = null;
			}
		}
		return tts;
	}

}

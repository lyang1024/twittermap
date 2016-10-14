package getTweets.dao;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import java.util.*;

import bean.*;
import getTweets.dbc.DbConnection;

public class GetLocationsDao {
	private ResultSet rs;
	private DbConnection connect;
	public GetLocationsDao(){
		connect = new DbConnection();
	}
	public TweetLocations getLocations(TweetLocations tl){
		String hashtag = tl.getHashtag();
		String query = "SELECT * FROM twitter.locations WHERE hashtag = '"+hashtag+"';";
		try {
//			DbConnection connect = new DbConnection();
			connect.connect();
			rs = connect.executeAndGetResult1(query);
			String re = null;
			List<String> locas = new ArrayList<String>();
			for (Row rows: rs){
				re=rows.getString("location");
				locas.add(re);
		    }
//		    String result1 = re.substring(0, re.length());
//		    List<String> result1 = new ArrayList<String>(Arrays.asList(htstring.split("_")));
		    tl.setLocations(locas);
		}catch (Exception e){
			//System.out.println("Failed to retrieve data from Cassandra!");
			e.printStackTrace();
		}finally{
			if(connect!=null){
				try{
					connect.close();
				}catch(Exception e){
					
				}
				connect = null;
			}
		}
		return tl;
	}
}

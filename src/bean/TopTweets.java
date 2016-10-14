package bean;
//import java.util.*;

public class TopTweets {
	private String statename ;
	private String hashtags;
	public TopTweets(){
		//setHashtags(new ArrayList<String>());
		this.statename = null;
		this.hashtags = null;
	};
	public void setStatename(String sn){
		this.statename = sn;
	} 

	public String getStatename(){
		return this.statename ;
	}
	public void setHashtags(String ht){
		hashtags = ht;
	}
	public String getHashtags(){
//		DbConnection db = new DbConnection();
//		db.connect(this.node, this.port);
//		String query = "SELECT * FROM twitter.hashtags WHERE statename = '"+this.statename+"';";
//		this.hashtags = new ArrayList<String>(db.executeAndGetResult1(query));
//		db.close();
		return this.hashtags;
	}
	
}
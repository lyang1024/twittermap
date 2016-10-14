package bean;
import java.util.*;
public class TweetLocations {
	private String hashtag;
	private List<String> locations;

	public TweetLocations(){
		this.hashtag = null;
//		this.locations = new ArrayList<String>();
	};
	public void setHashtag(String ht){
		this.hashtag = ht;
	} 

	public String getHashtag(){
		return this.hashtag ;
	}
	public void setLocations(List<String> l){
		this.locations = new ArrayList<String>(l);
	}
	public List<String> getLocations(){
		return this.locations;
	}
}

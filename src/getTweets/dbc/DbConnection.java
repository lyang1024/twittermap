package getTweets.dbc;

//import com.datastax.driver.core.Cluster;  
//import com.datastax.driver.core.Host;  
//import com.datastax.driver.core.Metadata;  
//import com.datastax.driver.core.Session; 
import com.datastax.driver.core.*;
  
import static java.lang.System.out;

//import java.util.*; 

public class DbConnection {
	/** Cassandra Cluster. */  
	private Cluster cluster;  
	  
	/** Cassandra Session. */  
	private Session session;
	public void connect()  
	   {  
		  String node = "localhost";
		  int port = 9160;
//	      this.cluster = Cluster.builder().addContactPoint(node).withPort(port).build();
		  this.cluster = Cluster.builder().addContactPoint(node).build();
	      final Metadata metadata = cluster.getMetadata();  
	      out.printf("Connected to cluster: %s\n", metadata.getClusterName());  
	      for (final Host host : metadata.getAllHosts())  
	      {  
	         out.printf("Datacenter: %s; Host: %s; Rack: %s\n",  
	            host.getDatacenter(), host.getAddress(), host.getRack());  
	      }  
	      session = cluster.connect();  
	   }  
	  
	   /** 
	    * Provide my Session. 
	    * 
	    * @return My session. 
	    */  
	   public Session getSession()  
	   {  
	      return this.session;  
	   }  
	   public void executeQuery(String query){
		   this.session.execute(query);
	   }
	   public ResultSet executeAndGetResult1(String query){
		   ResultSet result = this.session.execute(query);
//		   String re = null;
//		   for (Row rows: result){
//			   re=rows.getString("hashtag");
//		   }
//		   String htstring = re.substring(1, re.length());
//		   List<String> result1 = new ArrayList<String>(Arrays.asList(htstring.split("_")));
		   return result;
	   }
	   /** Close cluster. */  
	   public void close()  
	   {  
	      cluster.close();  
	   }  

}
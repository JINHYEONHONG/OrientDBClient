import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;


public class DBConnection {
	public static void main(String[] args)
	{
		 OrientDB orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
		 ODatabaseSession db =  orient.open("Movies","root","root12345");
		 String query = "select from Studio";
		 OResultSet rs = db.query(query);
		 
		 while(rs.hasNext())
		 {
			 OResult item = rs.next();
			 System.out.println("Studio Name: " + item.getProperty("Name"));
		 }

		   db.close();
		   orient.close();
	}

}

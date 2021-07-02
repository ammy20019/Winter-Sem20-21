package vit.student.util;
import com.mongodb.client.MongoDatabase; 
import com.mongodb.MongoClient; 
public class DBConnect 
{
	public static MongoDatabase  getConnect( String dbname ) 
	{  
		@SuppressWarnings("resource")
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
	    MongoDatabase database = mongo.getDatabase(dbname);
	    return database;
	}
}

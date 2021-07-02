package vit.student.dao;
import org.bson.Document;
import java.util.Iterator;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import vit.student.util.DBConnect;

public class StudentDAO 
{
	MongoDatabase database=null;
	MongoCollection<Document> collection =null;
	
	public StudentDAO(String dbname) // to call and set database connection
	{
		new DBConnect();
		database=DBConnect.getConnect(dbname);
	}
	public boolean createCollection(String cName)
	{
		boolean res = true;
		try 
		{
			database.createCollection(cName);
			System.out.println("collection created sucessfully");
		}
		catch(Exception e) 
		{
			res = false;
		}
		return res;	
	}
	public void listCollection() 
	{
		for(String name:database.listCollectionNames())
			System.out.println(name);
	}
	public boolean connectCollection(String cName)
	{
		boolean res = true;
		try 
		{
			collection=database.getCollection(cName);
			System.out.println("collection selected sucessfully");
		}
		catch(Exception e) 
		{
			res = false;
		}
		return res;			
	}
	public boolean insertDocument(Document document)
	{
		boolean res = true;
		try 
		{
			collection.insertOne(document);
			System.out.println("Document inserted sucessfully");
		}
		catch(Exception e) 
		{
			res = false;
		}
		return res;		
	}
	public void retriveDocument() 
	{
		FindIterable<Document> iterDoc = collection.find();
	    Iterator<Document> it = iterDoc.iterator();
	    while (it.hasNext()) 
	    {
	        System.out.println(it.next());
	    }
	}
	public boolean updateDocumentById(int sid, Document document)
	{
		boolean res = true;
		try 
		{
			Document update = new Document();
			update.append("$set", document);
			Document query = new Document();
	        query.append("Student_id",sid);
			collection.updateOne(query,update);
			System.out.println("Document updateded sucessfully");
		}
		catch(Exception e) 
		{
			res = false;
		}
		return res;		
	}
	public boolean deleteDocumentById(int sid)
	{
		boolean res = true;
		try 
		{
			Document query = new Document();
	        query.append("Student_id",sid);
			collection.deleteOne(query);
			System.out.println("Document deleteded sucessfully");
		}
		catch(Exception e) 
		{
			res = false;
		}
		return res;	
	}
	public boolean dropCollection()
	{
		boolean res = true;
		try 
		{
			collection.drop();
			System.out.println("collection droped sucessfully");
		}
		catch(Exception e) 
		{
			res = false;
		}
		return res;		
	}
}

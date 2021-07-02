package vit.student.services;

import com.mongodb.client.MongoDatabase;
import vit.student.dao.StudentDAO;
import org.bson.Document;
import java.util.Scanner;
public class MainClass 
{
	static MongoDatabase database;
	public static void  main( String args[] ) 
	{  
		Scanner in=new Scanner(System.in);
		Scanner in1=new Scanner(System.in);
		int id;
		int age;
		String sname;
		String address;
		String cname;
		boolean res;
		System.out.println("Enter DB name to use");
		String dbname = in.next();
		StudentDAO obj;
		Document document;
		int ch=1;
		do 
		{
			System.out.println("Enter choice");
			System.out.println("1.create collection");
			System.out.println("2.list collection");
			System.out.println("3.connect collection");
			System.out.println("4.insert document");
			System.out.println("5.retrive document");
			System.out.println("6.update document");
			System.out.println("7.delete document");
			System.out.println("8.delete collection");
			System.out.println("9.exit");
			ch=in.nextInt();
			switch(ch) 
			{
				case 1:
					System.out.println("enter collection name");
					cname=in.next();
					obj=new StudentDAO(dbname);
					res=obj.createCollection(cname);
					if(res)
						System.out.println("collection created");
					else
						System.out.println("error at collection creation");
					
					break;
					
				case 2:
					obj=new StudentDAO(dbname);
					obj.listCollection();
					break;
				case 3:
					System.out.println("enter collection name");
					cname=in.next();
					obj=new StudentDAO(dbname);
					res=obj.connectCollection(cname);
					if(res)
						System.out.println("collection connected");
					else
						System.out.println("error at collection connection");
					
					break;
				case 4:
					System.out.println("enter collection name");
					cname=in.next();
					System.out.println("enter student id");
					id=in.nextInt();
					System.out.println("enter student name");
					sname=in1.nextLine();
					System.out.println("enter student address");
					address=in1.nextLine();
					System.out.println("enter student age");
					age=in.nextInt();
					
					document=new Document("Student_id",id).append("Student_name",sname).append("Student_Addr",address).append("Student_Age",age);
					
					obj=new StudentDAO(dbname);
					
					if(obj.connectCollection(cname))
					{
						res=obj.insertDocument(document);
						if(res)
							System.out.println("document inserted");
						else
							System.out.println("error at document insertion");
					}						
				
					break;
				case 5:
					System.out.println("enter collection name");
					cname=in.next();
					obj=new StudentDAO(dbname);
					
					if(obj.connectCollection(cname))
					{
						obj.retriveDocument();
					}
					else
						System.out.println("error at collection connection");
					break;
				case 6:
					System.out.println("enter collection name");
					cname=in.next();
					System.out.println("enter student id");
					id=in.nextInt();
					System.out.println("enter student name");
					sname=in1.nextLine();
					System.out.println("enter student address");
					address=in1.nextLine();
					System.out.println("enter student age");
					age=in.nextInt();
					
					document=new Document("Student_id",id).append("Student_name",sname).append("Student_Addr",address).append("Student_Age",age);
					
					obj=new StudentDAO(dbname);
					
					if(obj.connectCollection(cname))
					{
						res=obj.updateDocumentById(id,document);
						if(res)
							System.out.println("document updated");
						else
							System.out.println("error at document updation");
					}
					break;
				case 7:
					System.out.println("enter collection name");
					cname=in.next();
					System.out.println("enter student id");
					id=in.nextInt();
					obj=new StudentDAO(dbname);
					if(obj.connectCollection(cname))
					{
						res=obj.deleteDocumentById(id);
						if(res)
							System.out.println("document deleted");
						else
							System.out.println("error at document deletions");
					}
					
					break;
				case 8:
					System.out.println("enter collection name");
					cname=in.next();
					obj=new StudentDAO(dbname);
					res=obj.dropCollection();
					if(obj.connectCollection(cname))
					{
						res=obj.dropCollection();
						if(res)
							System.out.println("collection deleted");
						else
							System.out.println("error at collection deletion");
					}
					
					break;
				case 9:
					System.out.println("exiting.....");
					break;
				default : System.out.println("wrong choice");
				break;
			}
		}while(ch!=9);
		in.close();
		in1.close();
	}
}

package digital.curioso.balada.util;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Connection {

	private MongoDatabase database;
	private MongoClient mongoClient;
	private MongoCollection<Document> collection;
	
	public Connection() {
		this.mongoClient = new MongoClient(new MongoClientURI("mongodb://baladaAdmin:xx11xx11@127.0.0.1:27017/balada"));
		this.database = this.mongoClient.getDatabase("balada");
	}

	public Connection(String collectionName) {
		this.mongoClient = new MongoClient(new MongoClientURI("mongodb://baladaAdmin:xx11xx11@127.0.0.1:27017/balada"));
		this.database = this.mongoClient.getDatabase("balada");
		this.collection = this.database.getCollection(collectionName);
	}	
	
	
	public void Close() {
		this.mongoClient.close();
	}


	public MongoDatabase getDatabase() {
		return database;
	}
	
	public MongoCollection<Document> getCollection() {
		return collection;
	}	

	
}

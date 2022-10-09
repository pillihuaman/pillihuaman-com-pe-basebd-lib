package pillihuaman.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
@Component
public  class ConfigMain {

	@Autowired
	private  AppProperties appProperties ;


	public MongoClient getConexion() {
		MongoClient mongoClient = new MongoClient(appProperties.getHost(), Integer.parseInt(appProperties.getPort()));

		return mongoClient;

	}

	public MongoDatabase getDataBases(String databaseName, MongoClient mongoClient) {
		MongoDatabase database = mongoClient.getDatabase(databaseName);
		return database;

	}

	@SuppressWarnings("rawtypes")
	public MongoCollection getcollection(String collectionName, MongoDatabase dataBase) {
		MongoCollection collection = dataBase.getCollection(collectionName);

		return collection;

	}
	
	ConfigMain(){}
	

}

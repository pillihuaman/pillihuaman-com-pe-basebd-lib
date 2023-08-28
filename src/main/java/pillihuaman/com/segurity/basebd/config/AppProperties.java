package pillihuaman.com.segurity.basebd.config;

import org.springframework.stereotype.Component;

@Component
public class AppProperties {
 
 private String port;
 private String host;
 private String database;
public String getPort() {
	return port;
}
public void setPort(String port) {
	this.port = port;
}
public String getHost() {
	return host;
}
public void setHost(String host) {
	this.host = host;
}
public String getDatabase() {
	return database;
}
public void setDatabase(String database) {
	this.database = database;
}

 
}
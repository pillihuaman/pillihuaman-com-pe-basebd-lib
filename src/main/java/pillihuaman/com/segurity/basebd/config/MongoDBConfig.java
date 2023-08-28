package pillihuaman.com.segurity.basebd.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "mongodb")
@Configuration
@EnableConfigurationProperties
public class MongoDBConfig  {
	private static MongoDBConfig config;
	//private List<Object> profiles;
	private List<MongoDBConexion> conexiones;

	public static MongoDBConfig getConfig() {
		return config;
	}

	public void loadConfig() {
		MongoDBConfig.config = this;
	}

	public List<MongoDBConexion> getConexiones() {
		return conexiones;
	}

	public void setConexiones(List<MongoDBConexion> conexiones) {
		this.conexiones = conexiones;
	}



}
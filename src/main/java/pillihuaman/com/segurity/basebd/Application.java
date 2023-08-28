package pillihuaman.com.segurity.basebd;

import org.springframework.boot.SpringApplication;

import java.util.Collections;
//@SpringBootApplication
// Package of your basebd module
//@ComponentScan("pillihuaman.com.basebd.config") // Package where MongoDBClient is located
public class Application {


	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8090"));
		app.run(args);
	}
	


	

}


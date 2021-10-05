package rs.luka.BetterReadsDataLoader;

import java.nio.file.Path;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import connection.DataStaxAstraProperties;
import rs.luka.BetterReadsDataLoader.author.Author;
import rs.luka.BetterReadsDataLoader.author.AuthorRepo;

@SpringBootApplication
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class BetterReadsDataLoaderApplication {

	@Autowired
	AuthorRepo authorRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BetterReadsDataLoaderApplication.class, args);
	}
	

	
	@PostConstruct
	public void start() {
		
			Author author = new Author();
			author.setId("id");
			author.setName("Name");
			author.setPersonalName("Pera Peric");
			authorRepo.save(author);
	}
	
	
	
	
	
	
	
	
	
	
	 @Bean public CqlSessionBuilderCustomizer sessionBuilderCustomizer
	 (DataStaxAstraProperties astraProperties) { Path bundle =	 astraProperties.getSecureConnectBundle().toPath();
	 return builder -> builder.withCloudSecureConnectBundle(bundle); }
	 
}

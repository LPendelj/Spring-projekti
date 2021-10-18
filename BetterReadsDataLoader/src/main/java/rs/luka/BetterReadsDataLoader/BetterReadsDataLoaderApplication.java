package rs.luka.BetterReadsDataLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import connection.DataStaxAstraProperties;
import rs.luka.BetterReadsDataLoader.author.Author;
import rs.luka.BetterReadsDataLoader.author.AuthorRepo;
import rs.luka.BetterReadsDataLoader.book.Book;
import rs.luka.BetterReadsDataLoader.book.BookRepo;

@SpringBootApplication
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class BetterReadsDataLoaderApplication {

	@Autowired
	AuthorRepo authorRepo;
	
	@Autowired
	BookRepo bookRepo;
	
	@Value(value = "${datadump.location.author}")
	private String authorsDumpLocation;
	
	@Value(value = "${datadump.location.works}")
	private String worksDumpLocation;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(BetterReadsDataLoaderApplication.class, args);
	}
	
	private void initAuthors() {
		Path path = Paths.get(authorsDumpLocation);
		try (Stream<String> lines = Files.lines(path);)
			{
			lines.forEach(line -> {
				// cita i parsira red
				String jsonString = line.substring(line.indexOf('{'));
				
				JSONObject jsonObject = null;
				try {
					jsonObject = new JSONObject(jsonString);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//pravi objekat Autor
				Author author = new Author();
				author.setName(jsonObject.optString("name"));
				author.setPersonalName(jsonObject.optString("personal_name"));
				author.setId(jsonObject.optString("key").replace("/authors", ""));
				//Cuva u bazu
				authorRepo.save(author);
				System.out.println("Unet autor " + author.getName());
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void initWorks() {
		Path path = Paths.get(worksDumpLocation);
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
		
		try (Stream<String> lines = Files.lines(path)){
			lines.limit(50).forEach(line -> {
				// cita i parsira red
				String jsonString = line.substring(line.indexOf('{'));
				
				try {
				JSONObject jsonObject = null;
				
					jsonObject = new JSONObject(jsonString);
					// pravimo novu instancu Book klase
					Book book = new Book();
					
					book.setId(jsonObject.getString("key").replace("/works/", ""));
					book.setName(jsonObject.optString("title"));
					JSONObject descriptionObj = jsonObject.optJSONObject("description");
					if(descriptionObj != null) {
						book.setDescription(descriptionObj.optString("value"));
					}
					
					JSONObject publishedObj = jsonObject.optJSONObject("created");
					if (publishedObj != null) {
						String dateString = publishedObj.getString("value");
						book.setPublishDate(LocalDate.parse(dateString, dateFormat));
					}
					
					JSONArray coversJSONArr = jsonObject.optJSONArray("covers");
					
					if(coversJSONArr != null) {
						List<String> coverIds = new ArrayList<>();
						for(int i = 0; i< coversJSONArr.length(); i++ ) {
							coverIds.add(coversJSONArr.getString(i));
						}
						book.setCoverIds(coverIds);
					}
					
					
					JSONArray authorsJSONArr = jsonObject.optJSONArray("authors");
						if(authorsJSONArr != null) {
							List<String> authorIds = new ArrayList<String>();
									for(int i = 0; i< authorsJSONArr.length(); i++ ) {
										String authorId = authorsJSONArr.getJSONObject(i).getJSONObject("author").getString("key").replace("/authors/", "");
										authorIds.add(authorId);
									}
									book.setAuthorId(authorIds);
									
									List <String> authorNames = authorIds.stream().map(id -> authorRepo.findById(id))
										.map(optionalAuthor -> {
												if (!optionalAuthor.isPresent()) return "Unknown author";										
												return optionalAuthor.get().getName();
									}).collect(Collectors.toList());
									
						
								book.setAuthorNames(authorNames);
								
								//Cuva se u repozitoriju
								bookRepo.save(book);
						}
				}catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			});
				
		} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		
	
				
			
	}
	
	
	
	@PostConstruct
	public void start() {
		
		//initAuthors();	
		initWorks();
	}
	
	
	
	
	
	
	
	
	
	
	 @Bean public CqlSessionBuilderCustomizer sessionBuilderCustomizer
	 (DataStaxAstraProperties astraProperties) { Path bundle =	 astraProperties.getSecureConnectBundle().toPath();
	 return builder -> builder.withCloudSecureConnectBundle(bundle); }
	 
}

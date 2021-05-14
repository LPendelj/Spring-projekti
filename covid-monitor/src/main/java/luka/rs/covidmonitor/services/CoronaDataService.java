package luka.rs.covidmonitor.services;


import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import luka.rs.covidmonitor.model.LocationStats;

@Service
public class CoronaDataService {
	
	private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	
	
	
	
	private List<LocationStats> allStats = new ArrayList<LocationStats>();
	
	
	
	
	
	public List<LocationStats> getAllStats() {
		return allStats;
	}



	@PostConstruct
	@Scheduled(cron = "0 0 8 * * *")
	public void fetchVirusData() throws IOException, InterruptedException {
		
		//pravi se nova lista sa podacima da bi novi korisnik mogao da pristupi i vidi dok prethodni gleda
		
		List<LocationStats> newStats = new ArrayList<LocationStats>();
		
		//klijent koji trazi podatke
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest req =  HttpRequest.newBuilder().uri(URI.create(VIRUS_DATA_URL)).build();
		HttpResponse<String> httpResponse =	client.send(req,  HttpResponse.BodyHandlers.ofString());
		
		//System.out.println(httpResponse.body());
		
		StringReader csvReader = new StringReader(httpResponse.body());
		
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
		for (CSVRecord record : records) {
			LocationStats locationStat = new LocationStats();
			locationStat.setState(record.get("Province/State"));
			locationStat.setCountry(record.get("Country/Region"));
			int latest = Integer.parseInt(record.get(record.size()-1));
			int previous = Integer.parseInt(record.get(record.size()-2));
			
			
			
			locationStat.setLatestTotal(latest);
			locationStat.setDelta(latest-previous);
			
			
		//	System.out.println(locationStat);
			
			newStats.add(locationStat);
			
			//System.out.print(state + " - ");
		    
		    
		    
		    
		    //String country = record.get("Country/Region");
		    //System.out.println(country);
		    
		   // String customerNo = record.get("CustomerNo");
		   // String name = record.get("Name");
		}
		this.allStats = newStats;
	}
}

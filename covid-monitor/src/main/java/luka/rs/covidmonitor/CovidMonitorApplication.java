package luka.rs.covidmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CovidMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidMonitorApplication.class, args);
	}

}

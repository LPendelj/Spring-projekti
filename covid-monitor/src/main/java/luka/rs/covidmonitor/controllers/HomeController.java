package luka.rs.covidmonitor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import luka.rs.covidmonitor.model.LocationStats;
import luka.rs.covidmonitor.services.CoronaDataService;

@Controller
public class HomeController {
	
	@Autowired
	CoronaDataService coronaDataService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allStats = coronaDataService.getAllStats();
		
		int totalCases = allStats.stream().mapToInt(stat -> stat.getLatestTotal()).sum();
		
		model.addAttribute("locationStats", allStats);
		model.addAttribute("totalCases", totalCases);
		
		
		
		return "home";
	}
}

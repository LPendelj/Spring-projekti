package rs.luka.BookingDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
	private List<HotelBooking> listOfBookings;
	
	
	public BookingController() {
		this.listOfBookings = new ArrayList<>();
		
		listOfBookings.add(new HotelBooking("Hilton", 65, 3));
		listOfBookings.add(new HotelBooking("Marriot", 45, 6));
		listOfBookings.add(new HotelBooking("Hyat", 22, 10));
		listOfBookings.add(new HotelBooking("Balkan", 38.5, 4));
		
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<HotelBooking> getAll(){
		return this.listOfBookings;
		
	}
	
	@RequestMapping(value = "/affordable/{price}",  method = RequestMethod.GET)
	public List<HotelBooking> getAffordable(@PathVariable double price){
		return listOfBookings.stream().filter(x-> x.getPricePerNight() <= price).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/create",  method = RequestMethod.POST)
	public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
		listOfBookings.add(hotelBooking);
		return listOfBookings;
	}
	
	
}

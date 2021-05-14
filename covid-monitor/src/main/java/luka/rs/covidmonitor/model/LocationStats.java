package luka.rs.covidmonitor.model;

public class LocationStats {
	
	private String state;
	private String country;
	private int latestTotal;
	private int delta;
	
	public LocationStats() {
		
	}
	
	public LocationStats(String state, String country, int latestTotal) {
		this.state = state;
		this.country = country;
		this.latestTotal = latestTotal;
	}
	
	
	
	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getLatestTotal() {
		return latestTotal;
	}
	public void setLatestTotal(int latestTotal) {
		this.latestTotal = latestTotal;
	}

	@Override
	public String toString() {
		return "LocationStats [state=" + state + ", country=" + country + ", latestTotal=" + latestTotal + "]";
	}
	
	
	
}

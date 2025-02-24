package hello;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Plane {
	
	public List<String> passengers;
    public int maxPassengers;
    public Date lastTimeTookOf;
    public Date lastTimeLanded;
    
	public Plane(int maxPassenger, List<String> passengers){
		this.maxPassengers=maxPassenger;
		this.passengers = new LinkedList<>();
	}
	
	public void onboard(String passengers) {
		this.passengers.add(passengers);
	}
	
	public Date takeOff() {
		this.lastTimeTookOf=new Date();
		return lastTimeTookOf;
	}

	public void land() {
		this.lastTimeLanded=new Date();
		this.passengers.clear();
	}
	
	public Date getLastTimeLanded() {
		return lastTimeLanded;
	}
	
	public List<String> getPassengers() {
		return passengers;
	}
}

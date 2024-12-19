package activities;

public class Activity1 {

	    public static void main(String[] args) {
	        car kia = new car();
	        kia.make = 2014;
	        kia.color = "Black";
	        kia.transmission = "Manual";
	    
	        //Using Car class method
	        kia.displayCharacterstics();
	        kia.accelerate();
	        kia.brake();
	    }

	}



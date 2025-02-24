package hello;

public class MountainBike extends Bicycle{

	int seatHeight;
	public MountainBike(int gears, int speed, int seatHeight) {
		super(gears, speed);
		this.seatHeight=seatHeight;
		// TODO Auto-generated constructor stub
	}
	
	public void setHeight(int newValue) {
	    seatHeight = newValue;
	}
	
	@Override
	public void bicycleDesc() {
		System.out.println("Number of gears: "+gears+ "\nCurrent speed is: "+speed+ "\nHeight of seat is: "
				+seatHeight);
	}

}

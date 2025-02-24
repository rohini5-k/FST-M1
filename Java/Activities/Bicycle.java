package hello;

public class Bicycle implements BicycleParts, BicycleOperations{
	
	int speed;
	int gears;

	public Bicycle(int gears, int speed) {
		this.gears=gears;
		this.speed=speed;
	}

	@Override
	public void applyBrake(int number) {
		speed=speed-number;
		
	}

	@Override
	public void speedUp(int number) {
		speed=speed+number;
		
	}
	
	public void bicycleDesc() {
		System.out.println("Number of gears: "+gears+ "\n Current speed is: "+speed);
	}


}

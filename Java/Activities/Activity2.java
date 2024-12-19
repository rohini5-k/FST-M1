package activities;

public class Activity2 {
	public static void main(String[]args) {
		
		int Sum=0;
		int a[]= {10,77,10,54,-11,10};
		for(int i=0;i<a.length;i++) {
			if(a[i]==10) {
				Sum=Sum+a[i];
			}
			}
            if(Sum==30)
            	System.out.println("true");
            else
            	System.out.println("false");
		
	
	}

}

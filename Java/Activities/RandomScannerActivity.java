package session3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomScannerActivity {

	public static void main(String[] args) {

		System.out.println("Enter 5 numbers: ");
		Scanner scan= new Scanner(System.in);
		ArrayList<Integer> list= new ArrayList<Integer>();
		for(int i=0;i<5;i++) {
			int num=scan.nextInt();
			list.add(num);
		}
		
		Random indexGen=new Random();
		int inp=indexGen.nextInt(0, 4);
		System.out.println("Random generated index: "+inp);
		System.out.println("Value in array at generated index: "+list.get(inp));
		
		
		

	}

}

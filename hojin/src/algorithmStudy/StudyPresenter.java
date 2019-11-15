package algorithmStudy;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class StudyPresenter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		Scanner scn = new Scanner(System.in);
		String[] nameList = scn.nextLine().split(" ");
		
		random.setSeed(System.currentTimeMillis());
		
		int num = random.nextInt(nameList.length);
		System.out.println(nameList[num]);
	}

}

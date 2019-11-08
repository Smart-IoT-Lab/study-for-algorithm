package algorithm.study;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SwimmingPool {
	public void solution()
	{
		
//		File path = new File(".");
//		System.out.println(path.getAbsolutePath());
		
		try {
			//create file obj
			File file = new File(".\\sample_input.txt");
			
			FileReader fileReader = new FileReader(file);
			
			BufferedReader bufReader = new BufferedReader(fileReader);
			
			String line = "";
			
			String testCase = bufReader.readLine();
			int numOfTestCase = Integer.parseInt(testCase);
			for(int roop = 0; roop < numOfTestCase; roop++)
			{
				int poolSize = Integer.parseInt(bufReader.readLine());
				int moveCount = 0;
				while(true)
				{
					// TODO exit
					moveCount += 1;
					if(moveCount == 100)
						break;
				}
				System.out.println("#"+roop+1+" "+moveCount);
			}
			bufReader.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
}

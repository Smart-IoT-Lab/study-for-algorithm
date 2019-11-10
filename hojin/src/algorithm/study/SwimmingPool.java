package algorithm.study;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class SwimmingPool {
	static int vertex, edge, S;
	public void solution()
	{
		
//		File path = new File(".");
//		System.out.println(path.getAbsolutePath());
		
		try {
			//create file obj
			File file = new File(".\\sample_input.txt");
			
			FileReader fileReader = new FileReader(file);
			
			BufferedReader bufReader = new BufferedReader(fileReader);
			
			String testCase = bufReader.readLine();
			int numOfTestCase = Integer.parseInt(testCase);
			for(int roop = 0; roop < numOfTestCase; roop++)
			{
				int poolSize = Integer.parseInt(bufReader.readLine());
				System.out.println(poolSize);
				
				ArrayList<String> adj = new ArrayList<>(); 
				
				for(int i = 0; i < poolSize; i++)
				{
					adj.add(bufReader.readLine());
					
				}
				String startPosition = bufReader.readLine();
				String escapePosiont = bufReader.readLine();
				System.out.println(startPosition);
				System.out.println(escapePosiont);
				
				int moveCount = 0;
				System.out.println(adj);
				while(true)
				{
					// TODO exit
					moveCount += 1;
					if(moveCount == 2)
						break;
				}
				System.out.println("#"+(roop+1)+" "+moveCount);
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

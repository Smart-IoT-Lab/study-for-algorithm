package example;

public class BruteForceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		BruteForceExample BruteForceTester = new BruteForceExample();
		
		System.out.println(BruteForceTester.sum(n));
		System.out.println(BruteForceTester.recursiveSum(n));
	}
	
	public int sum(int n)
	{
		int ret = 0;
		for(int i = 1; i <= n; i++)
		{
			ret += i;
		}
		return ret;
	}
	
	public int recursiveSum(int n)
	{
		if(n == 1)
			return 1;
		return n + recursiveSum(n - 1);
	}

}

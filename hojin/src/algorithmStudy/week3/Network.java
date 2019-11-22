package algorithmStudy.week3;

public class Network {
	public int solution(int n, int[][] computers) {
        int answer = 0;
        
        System.out.println(answer);
        return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
		Network networkAgent = new Network();
		
		System.out.println("expected answer 2");
		networkAgent.solution(n,  computers);
	}

}

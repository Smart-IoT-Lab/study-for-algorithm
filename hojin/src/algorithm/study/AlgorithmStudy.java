package algorithm.study;

public class AlgorithmStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseBallAgent agent = new BaseBallAgent();
		int[][] question = {{123, 1, 1},
							{356, 1, 0},
							{327, 2, 0},
							{489, 0, 1}};
		
		// System.out.println(question.length);
		// System.out.println(question[0].length);
		
		agent.solution(question);

		
		SwimmingPool swimmingAgent = new SwimmingPool();
		
		swimmingAgent.solution();		
	}
}

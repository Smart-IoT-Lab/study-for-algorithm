package algorithm.study;

public class AlgorithmStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseBallAgent baseBallAgent = new BaseBallAgent();
		int[][] question = {{123, 1, 1},
							{356, 1, 0},
							{327, 2, 0},
							{489, 0, 1}};
		
		// System.out.println(question.length);
		// System.out.println(question[0].length);
		
		baseBallAgent.solution(question);

		SwimmingPool swimmingAgent = new SwimmingPool();
		swimmingAgent.solution();
		
		PhoneBook phoneBookAgent = new PhoneBook();
		String [] phoneBook1 = {"119", "97674223", "1195524421"};
		String [] phoneBook2 = {"123", "456", "789"};
		String [] phoneBook3 = {"12", "123", "1235", "567", "88"};
		
		phoneBookAgent.solution(phoneBook1);
		phoneBookAgent.solution(phoneBook2);
		phoneBookAgent.solution(phoneBook3);
		
		
	}
}

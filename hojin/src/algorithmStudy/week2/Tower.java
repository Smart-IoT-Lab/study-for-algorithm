package algorithmStudy.week2;

import java.util.Arrays;

public class Tower {
	
	public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        for (int i = 0; i < heights.length; i++){
            for(int j = i+1; j < heights.length; j++){
            	// j에 가까운 i를 비교하기 때문에 answer가 알아서 갱신됨
                if(heights[i] > heights[j])
                    answer[j] = i + 1;
            }
        }
        
        System.out.print(Arrays.toString(answer));
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tower towerAgent = new Tower();
		int[] towrInfo = {6,9,5,7,4};
		System.out.println("0,0,2,2,4");
		towerAgent.solution(towrInfo);
	}

}

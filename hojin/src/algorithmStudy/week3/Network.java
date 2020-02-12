package algorithmStudy.week3;

import java.util.Stack;

public class Network {
	public int solution(int n, int[][] computers) {
        int answer = 0;
        
        int numberOfNode = computers.length;
        
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numberOfNode];
        boolean allVisitedFlag = false;
        stack.add(0);
        visited[0] = true;
        
        while(!allVisitedFlag) {
        	// 시작할때 네트워크 1개로 시작
        	answer += 1;
        	while(!stack.isEmpty()) {
            	int startNode = stack.pop();
            	
            	for(int endNode = 0; endNode < numberOfNode; endNode++) {
            		if (startNode == endNode)
            			continue;
            		if(computers[startNode][endNode] == 1) {
                		// 방문했으면 다음 노드 체크
                		if (visited[endNode])
                			continue;
                		else {
                			stack.add(endNode);
                    		visited[endNode] = true;
                		}
            		}           			
            	}
            }
        	
        	allVisitedFlag = true;
        	
        	for (int node = 0; node < numberOfNode; node++) {
        		// 미방문 지역 있으면 flag 변경
        		if (!visited[node]) {
        			stack.add(node);
        			visited[node] = true;
        			allVisitedFlag = false;
        			break;
        		}		
        	}
        	
        	if (allVisitedFlag)
        		break;
        }
        
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

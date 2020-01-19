package week_10;
import java.util.*;

public class Solution {
    int[] cycle;
    int find(int node){
        if(node==cycle[node]){
            return node;
        }
        else{
            return cycle[node] = find(cycle[node]);
        }
    }
    public int solution(int n,int[][] costs) {
        int answer = 0;
        cycle = new int[n]; //간선의 개수 <= 정점의 개수-1
        for(int i=0;i<n;i++) {
            cycle[i] = i;
        }

        Arrays.sort(costs, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if( ((Comparable)arr1[2]).compareTo(arr2[2]) < 0 )
                    return -1;
                else
                    return 1;
            }
        });
        for(int i=0;i<costs.length;i++){
            int a = find(costs[i][0]);
            int b = find(costs[i][1]);
            // a b 둘중 하나가 cycle 값이 0일때만 간선 추가
            if(a!=b){
                cycle[a] = b;
                answer += costs[i][2];
                //System.out.println(people[i][0]+","+people[i][1]+" 간선 추가");
            }
        }

        return answer;

    }
    public static void main(String[] args){
        int[][] people = {{0,3,5},{0,1,8},{1,2,16},{2,4,10},{2,3,2},{1,4,1}};
        System.out.println(new Solution().solution(5,people));
    }
}
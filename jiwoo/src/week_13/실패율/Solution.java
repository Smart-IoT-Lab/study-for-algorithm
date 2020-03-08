package week_13.실패율;

import java.util.*;
/*
테스트 1 〉	통과 (1.94ms, 52.3MB)
테스트 2 〉	통과 (8.68ms, 50.8MB)
테스트 3 〉	실패 (60.16ms, 54.5MB)
테스트 4 〉	통과 (2399.96ms, 61MB)
테스트 5 〉	실패 (시간 초과)
테스트 6 〉	통과 (10.32ms, 54.4MB)
테스트 7 〉	통과 (56.63ms, 52.6MB)
테스트 8 〉	통과 (1720.09ms, 58.9MB)
테스트 9 〉	실패 (시간 초과)
테스트 10 〉	실패 (2357.71ms, 57.6MB)
테스트 11 〉	실패 (1710.20ms, 58.7MB)
테스트 12 〉	통과 (4829.45ms, 61.6MB)
테스트 13 〉	통과 (8001.73ms, 69.5MB)
테스트 14 〉	통과 (2.35ms, 52.1MB)
테스트 15 〉	통과 (826.69ms, 54MB)
테스트 16 〉	통과 (208.09ms, 54.8MB)
테스트 17 〉	통과 (799.22ms, 55.3MB)
테스트 18 〉	통과 (212.75ms, 52.9MB)
테스트 19 〉	통과 (27.81ms, 52.9MB)
테스트 20 〉	통과 (413.66ms, 53.5MB)
테스트 21 〉	통과 (1487.73ms, 59.4MB)
테스트 22 〉	통과 (1724.09ms, 75.2MB)
테스트 23 〉	통과 (5773.50ms, 64.3MB)
테스트 24 〉	통과 (7378.99ms, 63.6MB)
테스트 25 〉	통과 (1.89ms, 52.5MB)
테스트 26 〉	통과 (1.89ms, 52.9MB)
테스트 27 〉	통과 (1.91ms, 52.6MB)
 */
public class Solution {
    // 윗단계를 클리어하지못한 사람은 = 지금 단계를 클리어 한 사람이다
    public int[] solution(int N, int[] stages) {
        ArrayList<Integer> stagesList = new ArrayList<>();
        for(int temp : stages){
            stagesList.add(temp);
        }
        HashMap<Integer,Float> failRate = new HashMap<>();
        int clearSum = 0;
        int failSum = 0;
        int idx = 0;
        //N+1 검사
        while((idx=stagesList.indexOf(N+1))!=-1){
            clearSum++;
            stagesList.remove(idx);
        }
        for(int i=N;i>=1;i--){
            // i 는 현재 탐색할 스테이지 단계
            while((idx=stagesList.indexOf(i))!=-1){
                failSum++;
                stagesList.remove(idx);
            }
            //System.out.println(failSum+","+clearSum);
            if(clearSum+failSum==0){
                failRate.put(i,(float)0);
                clearSum = 0;
                failSum = 0;
                continue;
            }
            failRate.put(i,(float)failSum/(clearSum+failSum)); //실패율 기록
            System.out.println(i+"에서 실패율은" +failRate.get(i));
            clearSum = failSum+clearSum;
            failSum = 0;
        }

        List<Integer> list = new ArrayList<>();
        list.addAll(failRate.keySet());

        //System.out.println();
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                if(failRate.get(o1) > failRate.get(o2))
                    return -1;
                else if(failRate.get(o1)==failRate.get(o2)){
                    return (int)o1>(int)o2?-1:1; //오름차순
                }
                else
                    return 1;
            }
        });

        Iterator<Integer> it = list.iterator();
        int i = 0;
        int[] answer = new int[N];
        while(it.hasNext()){
            answer[i] = (Integer)it.next();
            System.out.println(answer[i]);
            i++;
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,2,6,2,4,3,3,77,15,21,11,22,15,7,3,9,5,33,54};
        new Solution().solution(77,arr);
    }
}

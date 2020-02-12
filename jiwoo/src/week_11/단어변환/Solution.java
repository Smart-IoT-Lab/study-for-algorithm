package week_11.단어변환;
import java.util.LinkedList;
import java.util.Queue;
public class Solution {
    String[] words;
    Queue<Integer> queue;
    int[] depth;
    public boolean canChange(String from, String to){
        int cnt=0;
        for(int i=0;i<from.length();i++){
            if(from.charAt(i)!=to.charAt(i))
                cnt++;
        }
        if(cnt==1)
            return true;
        return false;
    }
    public int solution(String begin, String target, String[] words){
        this.words = words;
        queue = new LinkedList<Integer>();
        depth = new int[words.length];
        boolean targetExist = false;
        for(String i:words){
            if(i.equals(target))
                targetExist = true;
        }
        if (!targetExist)
            return 0;

        for(int i=0;i<words.length;i++){
            if(canChange(begin,words[i])) {
                queue.offer(i);
                depth[i] = 1; // hot 의 depth = 1
            }
        }
        while(!queue.isEmpty()){
            int r = queue.poll(); // hot
            for(int i=0;i<words.length;i++){
                if(depth[i]==0 && canChange(words[r],words[i])){
                    queue.offer(i);
                    depth[i] = depth[r] + 1; //hot 의 자식노드는 hot + 1 의 depth

                    if(words[i].equals(target))
                        return depth[i];
                }
            }
        }
        return 1;
    }
    public static void main(String[] args){
        String[] begin = {"aaa"};
        String[] target = {"abc"};
        String[][] words = {
                {"aaz","aab","abb","abc"}};
        // 4, 0, 1

        for (int i = 0; i < begin.length; i++) {
            System.out.println("answer : " + new Solution().solution(begin[i], target[i], words[i]) + "\n");
        }
    }
}

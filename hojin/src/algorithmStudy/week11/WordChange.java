package algorithmStudy.week11;

import java.util.LinkedList;
import java.util.Queue;

class wordInfo{
	String word;
	int step;
	wordInfo(String word, int step){
		this.word = word;
		this.step = step;
	}
}

public class WordChange {
	boolean isChangerable(String word, String target) {
		int wordLength = word.length();
		int difference = 0;
		
		if (word.equals(target)) {
			return false;
		}
//		
//		fail, check here
		
//		for(int idx = 0; idx < wordLength; idx ++) {
//    		if(difference > 1) {
//    			return false;
//    		}
//    		if(word.charAt(idx) != target.charAt(idx)) {
//    			difference += 1;
//    		}
//    	}
		
		for(int idx = 0; idx < wordLength; idx ++) {
			if(difference > 1) {
				return false;
			}
			if(word.charAt(idx) != target.charAt(idx)) {
				difference += 1;
			}
		}
		if (difference == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public int solution(String begin, String target, String[] words) {
        
        int answer = 0;
        int numberOfWords = words.length;
        
        Queue<wordInfo> q = new LinkedList<>();
	    q.add(new wordInfo(begin, 0));
	    boolean[] visited = new boolean[numberOfWords];
	    
	    // int step = 0;
	    
	    while(!q.isEmpty()) {
	    	wordInfo currentWordInfo = q.poll();
	    	if(currentWordInfo.word.equals(target)) {
	    		answer = currentWordInfo.step;
	    		break;
	    	}
	    	
	    	for (int i = 0; i < numberOfWords; i++) {
	    		if(!visited[i] && isChangerable(currentWordInfo.word, words[i])) {
	    			visited[i] = true;
	    			q.add(new wordInfo(words[i], currentWordInfo.step + 1));
	    		}
	    	} 	
	    }
        System.out.println(answer);
        return answer;
	}

	// public void inQueue(Queue<T> q, )
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		
		String [] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		WordChange agent = new WordChange();
		agent.solution(begin, target, words);
		
	}

}

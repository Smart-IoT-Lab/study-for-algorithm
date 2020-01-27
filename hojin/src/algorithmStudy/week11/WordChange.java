package algorithmStudy.week11;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordChange {
	public int solution(String begin, String target, String[] words) {
        List<String> wordList = Arrays.asList(words);
        int answer = 0;
        // 없으면 0
        if (!wordList.contains(target)) {
        	return answer;
        }
        int wordLength = begin.length();
        Queue<String> q = new LinkedList<String>();
	    q.add(begin);
        for(String item : q) {
        	for(String word : wordList) {
	        	int difference = 0;
	        	// char[] charList = new char[wordLength];
	        	for(int idx = 0; idx < wordLength; idx ++) {
	        		if(difference > 1)
	        			break;
	        		if(item.charAt(idx) != word.charAt(idx)) {
	        			difference += 1;
	        		}
	        		if(idx == wordLength-1) {
	        			if(difference == 0)
	        				return answer;
	        			if(difference == 1) {
	        				q.add(word);
	        				// exception 발생 가능
	        				wordList.remove(word);
	        			}		
	        		}
	        	}
	        }
		}
        return answer;
    }
	// public void inQueue(Queue<T> q, )
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

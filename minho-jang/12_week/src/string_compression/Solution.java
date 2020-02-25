package string_compression;

import java.util.*;

public class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        
        for (int len=1; len<s.length()/2+1; len++) {
        	ArrayList<CompressedString> compressed = new ArrayList<>();
        	
        	for (int start=0; start+len<=s.length(); start+=len) {
        		String current = s.substring(start, start+len);
        		
        		if (compressed.isEmpty())
        			compressed.add(new CompressedString(current));
        		else {
        			CompressedString lastEle = compressed.get(compressed.size()-1);
            		if (lastEle.s.contentEquals(current))
            			lastEle.repeat++;
            		else
            			compressed.add(new CompressedString(current));
        		}
        	}
        	
        	int remainder = s.length() % len;		// ³ª¸ÓÁö
        	if (remainder != 0)
        		compressed.add(new CompressedString(s.substring(s.length()-remainder, s.length())));
        	
        	int compLen = 0;
        	for (CompressedString cs : compressed) 
        		compLen += cs.getLength();
        	
        	System.out.println(compressed.toString() + "    len: " + compLen);
        	if (min > compLen)
        		min = compLen;
        }
        
        if (min == Integer.MAX_VALUE)
        	return 1;
        
        return min;
    }
    
    class CompressedString {
    	int repeat;
    	String s;
    	
    	CompressedString(String s) {
    		this.repeat = 1;
    		this.s = s;
    	}
    	
    	int getLength() {
    		StringBuilder compStr = new StringBuilder();
    		if (repeat == 1)
    			compStr.append(s);
    		else
    			compStr.append(String.valueOf(repeat)).append(s);
    		
    		return compStr.length();
    	}
    	
    	@Override
    	public String toString() {
    		StringBuilder compStr = new StringBuilder();
    		if (repeat == 1)
    			compStr.append(s);
    		else
    			compStr.append(String.valueOf(repeat)).append(s);
    		
    		return compStr.toString();
    	}
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
//    	String s = "aabbaccc";		// 7
//    	String s = "ababcdcdababcdcd";		// 9
//    	String s = "abcabcdede";		// 8
//    	String s = "abcabcabcabcdededededede";		// 14
//    	String s = "xababcdcdababcdcd";		// 17
    	String s = "a";
    	
    	System.out.println(sol.solution(s));
    	
    }
}

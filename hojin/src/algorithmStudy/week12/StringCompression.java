package algorithmStudy.week12;

public class StringCompression {
	public int solution(String s) {
		int answer = 1001;
		int length = s.length();
		
		if(length == 1)
			return 1;
		
		for(int i = 1; i < length; i++) {
			String pattern;
			String temp = s;
			String comp = "";
			int searchIndex = 0;
			// pattern = s.substring(0, i);
			// System.out.println(pattern);
			pattern = s.substring(0, i);
			int matchCount = 0;
			while(true) {
				if(temp.startsWith(pattern)) {
					matchCount += 1;
					temp = temp.substring(i);
					System.out.println("temp : "+temp);
					searchIndex += i;
					System.out.println("searchIndex : "+searchIndex);
				}else {
					if(matchCount > 1) {
						comp = comp.concat(Integer.toString(matchCount));
					} 
					comp = comp.concat(pattern);
					System.out.println("comp : "+comp);
					pattern = s.substring(searchIndex, searchIndex + i);
					matchCount = 0;
				}
				//다 자른 경우
				if(searchIndex == length) {
					if(matchCount > 1) {
						comp = comp.concat(Integer.toString(matchCount));
					} 
					comp = comp.concat(pattern);
					System.out.println("clear comp : "+comp);
					if(comp.length() < answer) {
						answer = comp.length();
						System.out.println(answer);
					}
					break;
				}
				//남은 문자열을 자를 수 없는 경우
				if(length - searchIndex < i) {
					if(matchCount > 1) {
						comp = comp.concat(Integer.toString(matchCount));
					} 
					comp = comp.concat(pattern);
					if(comp.length() + length - searchIndex < answer) {
						answer = comp.length() + length - searchIndex;
						System.out.println(answer);
					}
					break;
				}
			}
			if(i == length && answer > length) {
				answer = length;
				System.out.println(answer);
			}
		}
		System.out.println("answer : "+answer);
		return answer;
	}
	
//	public int[] getPartialMatchTable(String s) {
//		int length = s.length();
//		int[] pi = new int[length];
//		
//		char[] N = new char[length];
//		N = s.toCharArray();
//		// String pattern = "";
//		// int targetWordIndex = 0;
//		
//		int begin = 1;
//		int matched = 0;
//		
//		while(begin + matched < length) {
//			if(N[begin + matched] == N[matched]) {
//				++matched;
//				pi[begin+matched-1] = matched;
//			}
//			else {
//				if(matched == 0)
//					++begin;
//				else {
//					begin += matched - pi[matched-1];
//					matched = pi[matched-1];
//				}
//			}
//		}
//		return pi;
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringCompression agent = new StringCompression();
		String s = "ababcdcdababcdcd";
		agent.solution(s);
	}

}

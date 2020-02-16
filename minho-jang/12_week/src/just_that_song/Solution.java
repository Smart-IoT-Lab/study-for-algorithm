package just_that_song;

import java.util.*;

/**
 * 정확성  테스트
테스트 1 〉	통과 (1.49ms, 50.5MB)
테스트 2 〉	통과 (17.41ms, 52MB)
테스트 3 〉	통과 (16.30ms, 54.5MB)
테스트 4 〉	통과 (1.68ms, 52.5MB)
테스트 5 〉	통과 (17.18ms, 52MB)
테스트 6 〉	통과 (18.40ms, 54.2MB)
테스트 7 〉	실패 (19.85ms, 53.9MB)
테스트 8 〉	통과 (19.60ms, 56.4MB)
테스트 9 〉	실패 (20.62ms, 54MB)
테스트 10 〉	통과 (32.06ms, 54.9MB)
테스트 11 〉	실패 (19.39ms, 54.4MB)
테스트 12 〉	통과 (18.84ms, 54.4MB)
테스트 13 〉	통과 (18.39ms, 54.2MB)
테스트 14 〉	통과 (19.04ms, 54.1MB)
테스트 15 〉	통과 (18.26ms, 55.8MB)
테스트 16 〉	통과 (19.69ms, 53.5MB)
테스트 17 〉	통과 (19.25ms, 52MB)
테스트 18 〉	실패 (19.63ms, 52.6MB)
테스트 19 〉	통과 (42.64ms, 57.9MB)
테스트 20 〉	통과 (18.02ms, 54MB)
테스트 21 〉	실패 (21.59ms, 54.1MB)
테스트 22 〉	통과 (18.16ms, 54MB)
테스트 23 〉	통과 (19.78ms, 54.5MB)
테스트 24 〉	실패 (19.90ms, 52.3MB)
테스트 25 〉	통과 (16.61ms, 56.1MB)
테스트 26 〉	통과 (18.86ms, 54.5MB)
테스트 27 〉	통과 (18.71ms, 54.1MB)
테스트 28 〉	통과 (16.27ms, 54.4MB)
테스트 29 〉	실패 (50.75ms, 57.5MB)
테스트 30 〉	실패 (48.21ms, 57.3MB)

채점 결과
정확성: 73.3
합계: 73.3 / 100.0
 *
 */
public class Solution {
	HashMap<String, Integer> noteMap = new HashMap<>();
	
	public String solution(String m, String[] musicinfos) {
		String answer = "";
		
		createMap();
		
		// 1. musicinfos의 요소 각각을 긴 문자열(playingMusic)로 만들어
		// 2. 긴 문자열 중 m을 포함하고 있으면 정답 후보
		// 3. 정답 후보 중 제일 긴 문자열 출력
		
		ArrayList<MusicInfo> answers = new ArrayList<>();
		
		for (String s : musicinfos) {
			MusicInfo info = new MusicInfo(s);
			ArrayList<Integer> playingMusic = infoToString(info);
			
			if (playingMusic.containsAll(musicToInt(m)))
				answers.add(info);
		}
		
		if (answers.size() == 0)
			return "(None)";
		
		MusicInfo longest = answers.get(0);
		for (int i=1; i<answers.size(); i++) {
			if (answers.get(i).time > longest.time)
				longest = answers.get(i);
		}
		
		return longest.title;
	}
	
	ArrayList<Integer> infoToString(MusicInfo info) {
		ArrayList<Integer> playing = new ArrayList<>();
		
		int leaveTime = info.time;
		int soundLen = info.sound.size();
		
		while(leaveTime > soundLen) {
			playing.addAll(info.sound);
			leaveTime -= soundLen;
		}
		
		playing.addAll(info.sound.subList(0, leaveTime));
//		System.out.println("music: " + playing.toString());
		return playing;
	}
	
	void createMap() {
		noteMap.put("C", 0);
		noteMap.put("C#", 1);
		noteMap.put("D", 2);
		noteMap.put("D#", 3);
		noteMap.put("E", 4);
		noteMap.put("F", 5);
		noteMap.put("F#", 6);
		noteMap.put("G", 7);
		noteMap.put("G#", 8);
		noteMap.put("A", 9);
		noteMap.put("A#", 10);
		noteMap.put("B", 11);
		
//		System.out.println(noteMap.toString());
	}

	class MusicInfo {
		int time;
		String title;
		ArrayList<Integer> sound;	// 악보
		
		MusicInfo(String s) {
			String[] arr = s.split(",");
			// 시간 저장
			String[] start = arr[0].split(":");
			String[] end = arr[1].split(":");
			this.time = (Integer.valueOf(end[0])-Integer.valueOf(start[0]))*60 + 
					(Integer.valueOf(end[1]) - Integer.valueOf(start[1]));
			
			// 제목, 소리 저장
			this.title = arr[2];
			
			// 소리(악보) 저장
			sound = musicToInt(arr[3]);
		}
	}
	
	ArrayList<Integer> musicToInt(String music) {
		ArrayList<Integer> sound = new ArrayList<Integer>();
		char[] soundCharArr = music.toCharArray();
		for (int i=0; i<soundCharArr.length; i++) {
			if (soundCharArr[i] == '#') {
				sound.remove(sound.size()-1);
				sound.add(noteMap.get(String.valueOf(soundCharArr[i-1])+ "#"));
			} else {
				sound.add(noteMap.get(String.valueOf(soundCharArr[i])));
			}
		}
		return sound;
	}
	
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
//		String m = "ABCDEFG";
//		String[] musicinfos = {
//				"12:00,12:14,HELLO,CDEFGAB", 
//				"13:58,14:03,WORLD,ABCDEF"
//		};		// HELLO
		
		String m = "CC#BCC#BCC#BCC#B";
		String[] musicinfos = {
				"03:00,03:30,FOO,CC#B", 
				"04:00,04:08,BAR,CC#BCC#BCC#B"
		};		// FOO
		
//		String m = "ABC";
//		String[] musicinfos = {
//				"12:00,12:14,HELLO,C#DEFGAB", 
//				"13:00,13:05,WORLD,ABCDEF"
//		};		// WORLD
		
		System.out.println(s.solution(m, musicinfos));
	}
}

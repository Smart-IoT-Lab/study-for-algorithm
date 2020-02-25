package just_that_song;

import java.util.*;

/**
 * ��Ȯ��  �׽�Ʈ
�׽�Ʈ 1 ��	��� (1.49ms, 50.5MB)
�׽�Ʈ 2 ��	��� (17.41ms, 52MB)
�׽�Ʈ 3 ��	��� (16.30ms, 54.5MB)
�׽�Ʈ 4 ��	��� (1.68ms, 52.5MB)
�׽�Ʈ 5 ��	��� (17.18ms, 52MB)
�׽�Ʈ 6 ��	��� (18.40ms, 54.2MB)
�׽�Ʈ 7 ��	���� (19.85ms, 53.9MB)
�׽�Ʈ 8 ��	��� (19.60ms, 56.4MB)
�׽�Ʈ 9 ��	���� (20.62ms, 54MB)
�׽�Ʈ 10 ��	��� (32.06ms, 54.9MB)
�׽�Ʈ 11 ��	���� (19.39ms, 54.4MB)
�׽�Ʈ 12 ��	��� (18.84ms, 54.4MB)
�׽�Ʈ 13 ��	��� (18.39ms, 54.2MB)
�׽�Ʈ 14 ��	��� (19.04ms, 54.1MB)
�׽�Ʈ 15 ��	��� (18.26ms, 55.8MB)
�׽�Ʈ 16 ��	��� (19.69ms, 53.5MB)
�׽�Ʈ 17 ��	��� (19.25ms, 52MB)
�׽�Ʈ 18 ��	���� (19.63ms, 52.6MB)
�׽�Ʈ 19 ��	��� (42.64ms, 57.9MB)
�׽�Ʈ 20 ��	��� (18.02ms, 54MB)
�׽�Ʈ 21 ��	���� (21.59ms, 54.1MB)
�׽�Ʈ 22 ��	��� (18.16ms, 54MB)
�׽�Ʈ 23 ��	��� (19.78ms, 54.5MB)
�׽�Ʈ 24 ��	���� (19.90ms, 52.3MB)
�׽�Ʈ 25 ��	��� (16.61ms, 56.1MB)
�׽�Ʈ 26 ��	��� (18.86ms, 54.5MB)
�׽�Ʈ 27 ��	��� (18.71ms, 54.1MB)
�׽�Ʈ 28 ��	��� (16.27ms, 54.4MB)
�׽�Ʈ 29 ��	���� (50.75ms, 57.5MB)
�׽�Ʈ 30 ��	���� (48.21ms, 57.3MB)

ä�� ���
��Ȯ��: 73.3
�հ�: 73.3 / 100.0
 *
 */
public class Solution {
	HashMap<String, Integer> noteMap = new HashMap<>();
	
	public String solution(String m, String[] musicinfos) {
		String answer = "";
		
		createMap();
		
		// 1. musicinfos�� ��� ������ �� ���ڿ�(playingMusic)�� �����
		// 2. �� ���ڿ� �� m�� �����ϰ� ������ ���� �ĺ�
		// 3. ���� �ĺ� �� ���� �� ���ڿ� ���
		
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
		ArrayList<Integer> sound;	// �Ǻ�
		
		MusicInfo(String s) {
			String[] arr = s.split(",");
			// �ð� ����
			String[] start = arr[0].split(":");
			String[] end = arr[1].split(":");
			this.time = (Integer.valueOf(end[0])-Integer.valueOf(start[0]))*60 + 
					(Integer.valueOf(end[1]) - Integer.valueOf(start[1]));
			
			// ����, �Ҹ� ����
			this.title = arr[2];
			
			// �Ҹ�(�Ǻ�) ����
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

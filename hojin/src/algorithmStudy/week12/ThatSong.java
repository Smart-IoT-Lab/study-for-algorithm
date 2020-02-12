package algorithmStudy.week12;

import java.util.Arrays;

public class ThatSong {
	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		int numOfMusics = musicinfos.length;
		// 곡 패턴
		String[] patterns = new String[numOfMusics];
		// 곡 실행 시간
		int[] playtimes = new int[numOfMusics];
		// 곡 이름
		String[] musicName = new String[numOfMusics];

		// 문자열 분할
		for (int i = 0; i < numOfMusics; i++) {
			String[] musicInfo = musicinfos[i].split(",");
			System.out.println(Arrays.toString(musicInfo));
			// 곡 이름 추출
			musicName[i] = musicInfo[2];
			
			//곡 실행 시간 추출(시간)
			int hour = Integer.parseInt(musicInfo[1].split(":")[0]) - Integer.parseInt(musicInfo[0].split(":")[0]);
			// 곡 실행 시간 추출(분)
			int minute = Integer.parseInt(musicInfo[1].split(":")[1]) - Integer.parseInt(musicInfo[0].split(":")[1]);
			
			playtimes[i] = hour*60 + minute;

			// 패턴 처리
			// temp는 기본 패턴
			String temp = musicInfo[3];
			
			// # 처리
			temp = temp.replace("A#", "a");
			temp = temp.replace("C#", "c");
			temp = temp.replace("D#", "d");
			temp = temp.replace("F#", "f");
			temp = temp.replace("G#", "g");
			
			System.out.println("base pattern : "+temp);
			
			// 곡 실행 시간 기반 패턴 반복횟수 추출
			int repeat = playtimes[i] / temp.length();
			System.out.println("repeat"+repeat);
			int repeatRemainder = playtimes[i] % temp.length();
			System.out.println("repeatRemainder"+repeatRemainder);

			// 패턴을 1번 이상 반복하는 경우 반복 횟수 만큼 패턴 저장
			if (repeat >= 1) {
				patterns[i] = temp;
				for (int j = 1; j < repeat; j++) {
					patterns[i] = patterns[i].concat(temp);
				}	
			}else {
				patterns[i] = "";
			}

			// 잘린 패턴 붙이기
			if(repeatRemainder > 0) {
				patterns[i] = patterns[i].concat(temp.substring(0, repeatRemainder));
			}
			// System.out.println(temp.substring(0, repeatRemainder));
			System.out.println(Arrays.toString(patterns));
			// System.out.println("complete pattern : "+patterns[i]);
		}

		int matchedPlaytime = 0;
		for (int i = 0; i < numOfMusics; i++) {
			// # 처리
			m = m.replace("A#", "a");
			m = m.replace("C#", "c");
			m = m.replace("D#", "d");
			m = m.replace("F#", "f");
			m = m.replace("G#", "g");
			// 패턴을 포함하고 && 라디오 재생시간이 더 긴 경우 음악제목 업데이트
			// < 등호를 통해 먼저 입력된(재생된) 음악이 반환 값으로 업데이트 됨
			if (patterns[i].contains(m) && matchedPlaytime < playtimes[i]) {
				matchedPlaytime = playtimes[i];
				answer = musicName[i];
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThatSong agent = new ThatSong();
		String m = "ABC";
		String [] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		
		agent.solution(m, musicinfos);
	}

}

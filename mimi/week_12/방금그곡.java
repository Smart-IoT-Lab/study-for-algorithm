class Solution {
  public String solution(String m, String[] musicinfos) {
      String start_time, end_time, title,info;
	  String answer="(None)";
      int max=0;//�ִ� ����ð�
      
      		if(m.contains("C#")) {
				m=m.replace("C#", "1");
			}
			if(m.contains("D#")) {
				m=m.replace("D#", "2");
			}
			if(m.contains("F#")) {
				m=m.replace("F#", "3");
			}
			if(m.contains("G#")) {
				m=m.replace("G#", "4");
			}
			if(m.contains("A#")) {
				m=m.replace("A#", "5");
			}
      
      		for(int i=0;i<musicinfos.length;i++) {
			String []array=musicinfos[i].split(",");
			
			start_time=array[0];
			end_time=array[1];
			title=array[2];
			info=array[3];
			
			int hour=Integer.parseInt(end_time.substring(0,2))-Integer.parseInt(start_time.substring(0,2));
			int minute=Integer.parseInt(end_time.substring(3))-Integer.parseInt(start_time.substring(3));
			int replay_time=hour*60+minute;//���� ����ð�
			
			
			if(info.contains("C#")) {
				info=info.replace("C#", "1");
			}
			if(info.contains("D#")) {
				info=info.replace("D#", "2");
			}
			if(info.contains("F#")) {
				info=info.replace("F#", "3");
			}
			if(info.contains("G#")) {
				info=info.replace("G#", "4");
			}
			if(info.contains("A#")) {
				info=info.replace("A#", "5");
			}

			
			
			String music=String.valueOf(info.toString().charAt(0));//string ->char->string �ð��� ���� ����Ǵ� �뷡
	
			for(int j=0;j<replay_time;j++) {
				String ex=String.valueOf(info.toString().charAt(j%info.length()));
				music=music.concat(ex);//0���ͽ����ؼ� �� �����ϳ��� �� �߰���
			}
			music=music.substring(1);
			
			if(music.contains(m) && max < replay_time) {
                max=replay_time;
				answer=title;
				
			}
			
		}

      
      return answer;
  }
}
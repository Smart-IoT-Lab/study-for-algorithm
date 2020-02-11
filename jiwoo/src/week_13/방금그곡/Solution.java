package week_13.방금그곡;

/*
1. 악보정보와 끝시간-시작시간 비교하기
=> 악보가 더 길다 : temp 변수에 끝시간-시작시간
=> 끝시간-시작시간이 더 길다 : temp 변수에 악보길이

temp 변수만큼 m.length % temp 하면서 m 에 있는 알파벳 추출

주의할 것. 다음 문자를 확인해 #인지 아닌지 확인하고 같이 검사
 */
public class Solution {
    public String solution(String m, String[] musicinfos) {
        String matchingTitle = "";
        int maxExecuteTime = 0; // 재생된 시간이 제일 긴 음악 제목 추출을 위한 변수

        for(int i=0;i<musicinfos.length;i++){
            String[] array = musicinfos[i].split(","); // ['시작시간','끝시간','노래제목','악보정보'] 배열
            int executeTime = (Integer.parseInt(array[1].split(":")[0])-Integer.parseInt(array[0].split(":")[0]))*60
                    + Integer.parseInt(array[1].split(":")[1])-Integer.parseInt(array[0].split(":")[1]);
            //끝시간 - 시작시간

            int len = -1;

            if( executeTime >= m.length()){ //전달된음악실행시간이 m의 실행시간보다 더 길다면
                len = array[3].length();
            }
            else{ // m 의 실행시간이 더 길다면
                len = executeTime;
            }
            /*
            String sheet = "";
            for(int j=0;j<executeTime;j++){
                sheet += array[3].charAt(j%len);
            }
            if(sheet.contains(m)){
                if(m.charAt(m.length())=='#'){

                }
                if(executeTime>maxExecuteTime){
                    matchingTitle = array[2];
                }
            }

             */
            /*
            constain의 쿤제점은
            ABCDC
            EFABCDC# 과 같은 코드도 통과시킨다는 점임
            따라서 constain을 사용할 수 없고
            직접 for문으로 문자열을 탐색해야 함
             */
            boolean questing = false;

            int idx = 0; //m 에서의 idx 를 따로 둬야함

            for(int j=0;j<executeTime;j++){
                //System.out.println("인덱스는 "+j);
                if(idx==0) { //현재 문자열을 탐색하지않는다면
                    if(m.charAt(0) == array[3].charAt(j%len)){
                        //탐색시작
                        System.out.println(idx + ","+j%len +"에서 탐색시작");
                        idx++;
                        continue;
                    }
                }
                else if(idx==m.length()){
                    if(((j+1)%len)!=executeTime && array[3].charAt(j%len+1)=='#'){
                        //ABC 와 ABC#
                        idx=0; // 문자열을 포함하지않는다
                        continue;
                    }
                    else{ //맞는 문자열
                        if(maxExecuteTime < array[3].length()){
                            matchingTitle = array[2];
                        }
                        break;
                    }
                }
                else { //문자열 탐색중이라면
                    //System.out.println(array[3].charAt(j%len)+"에서 탐색중");
                    if(array[3].charAt(j%len)==m.charAt(idx)){
                        idx++;
                        continue;
                    }

                    System.out.println(idx + "에서 탐색이 끝남");
                    idx = 0;
                }
            }
            //한번의 for문이 끝났을때
            //문자열 탐색중에 끝났다면

            /*if(idx!=0){
                if(maxExecuteTime < array[3].length()){
                    matchingTitle = array[2];
                }
                break;
                //System.out.println("탐색이 끝남, count 는 "+cnt);

            }


             */
        }
        if(matchingTitle.equals(""))
            matchingTitle = "(None)";
        //System.out.println(matchingTitle);
        return matchingTitle;
    }
    public static void main(String[] args){
        String[] m = {"ABCDEFG","CC#BCC#BCC#BCC#B","ABC","A","CDCDF","ABC"};
        String[][] musicinfos = {{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"},
                {"03:00,03:30,FOO,CC#B, 04:00,04:08,BAR,CC#BCC#BCC#B"},
                {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"},
                {"03:00,03:30,FOO,CC#B, 04:00,04:08,BAR,CC#BCC#BCC#B"},
                {"13:00,13:8,FFO,CDCDCDF"},
                {"13:00,13:5,FFF,ABC#"}};
        for(int i=0;i<m.length;i++){
            System.out.println(new Solution().solution(m[i],musicinfos[i]));
        }
    }
}

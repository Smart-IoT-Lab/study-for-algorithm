package week_14.다트게임;

public class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int sequence = 0;
        int[] score = { 0, 0, 0 };

        String preDartResult = dartResult.replace("*", "").replace("#", "");
        // System.out.println(preDartResult);

        int tmpScore = dartResult.charAt(0) - 48;

        for (int i = 0; i < preDartResult.length(); i++) {
            char tmpChr = preDartResult.charAt(i);
            // System.out.print(tmpChr + " ");
            if (47 < tmpChr && tmpChr < 58) {
                if (tmpChr == 49 && preDartResult.charAt(i + 1) == 48) {
                    tmpScore = 10;
                    i++;
                    continue;
                }
                tmpScore = tmpChr - 48; // 이번꺼 저장
                continue;
            } else {
                // System.out.print(" 디버깅 ");
                if (tmpChr == 'D') {
                    tmpScore *= tmpScore;
                } else if (tmpChr == 'T') {
                    tmpScore = tmpScore * tmpScore * tmpScore;
                }
                score[sequence] = tmpScore; // 수 저장, seq = 0
                sequence = sequence + 1;
            }
        }
        sequence = -1;
        for (int i = 0; i < dartResult.length(); i++) {
            char tmpChr = dartResult.charAt(i);
            System.out.print(tmpChr + " ");
            if (sequence != 0 && tmpChr == '*') {
                score[sequence - 1] *= 2;
                score[sequence] *= 2;
            } else if (tmpChr == '*') {
                score[sequence] *= 2;
            } else if (tmpChr == '#') {
                score[sequence] *= -1;
                System.out.println(sequence + "번째에서 -1 연산");
            } else if (47 < tmpChr && tmpChr < 58) {
                if (tmpChr == 49 && dartResult.charAt(i + 1) == 48) {
                    i++;
                }
                sequence += 1;
            }
        }
        answer = score[0] + score[1] + score[2];
        System.out.print(" /" + score[0] + "," + score[1] + "," + score[2] + "/ ");
        return answer;
    }
    public static void main(String[] args) {
        String[] arr = {"1S2D*3T","1D2S#10S","1D2S0T","1S*2T*3"};
        for(int i=0;i<arr.length;i++)
            System.out.println("=>"+new Solution().solution(arr[i]));
    }
}

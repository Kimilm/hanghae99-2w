package young;

import java.util.*;

public class Solutions {
    public static String Dateyoung(int a, int b) {
        String answer = "";
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] date = {"FRI", "SAT", "SUN",
                "MON", "TUE", "WED", "THU"};
        int calc = 0;
        if (a > 0) {
            for (int i = 0; i < a - 1; i++) {
                calc += days[i];
            }
        }
        calc += (b - 1);
        answer = date[(calc % 7)];
        return answer;
    }

    public int[] in_five(int[] arr, int divisor) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) count++;
        }

        if (count == 0) {
            int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[count];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) answer[j++] = arr[i];
        }

        Arrays.sort(answer);
        return answer;
    }

    public String suback(int n) {
        String answer = "";

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                answer += "박";
            } else answer += "수";
        }

        return answer;
    }

    public String who_arrive(String[] participant, String[] completion) {
        String answer = "";
//         배열 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
//         i 선언 내부 선언시 마지막줄 작동 불가
        int i;
//         part의 i번째 와 compdml i번째가 같은지 조회 틀리면 답 선언
        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[i];
    }

    public String solution(String s) {
        String answer = "";
//         분해
        String[] ans = s.split("");

        int row = 0;
//
        for (int i = 0; i < ans.length; i++) {
//             i번째 글자가 공백 일때 변수값을 0
            if (ans[i].equals(" ")) {
                row = 0;
//             변수값이 2로 나눠질때 대문자로 하고 변수에 1을 더한다.
            } else if (row % 2 == 0) {
                ans[i] = ans[i].toUpperCase();
                row++;
//             변수값이 2로 나눴을때 나머지가 남으면 소문자로 하고 변수에 1을 더 한다.
            } else if (row % 2 != 0) {
                ans[i] = ans[i].toLowerCase();
                row++;
            }
            answer += ans[i];
        }

        return answer;
    }


    public int solution(int n) {
        int answer = 0;

        String num = Integer.toString(n); //int n을 String으로 변환

        for (int i = 0; i < num.length(); i++) {
            answer += Integer.parseInt(num.substring(i, i + 1));
        }
        return answer;
    }


    public int[] reverse(long n) {
        // long → String
        String s = String.valueOf(n);

        // reverse()메소드를 이용하기 위하여
        // StringBuilder 인스턴스 생성
        StringBuilder sb = new StringBuilder(s);

        // reverse()로 문자열 뒤집기
        sb = sb.reverse();

        // String.split("")로 한 글자씩 잘라 배열에 담기
        String[] stringArr = sb.toString().split("");

        // 문자열 길이 만큼 배열 길이 할당
        int[] answer = new int[sb.length()];

        // String → int → int[]
        for (int i = 0; i < sb.length(); i++) {
            answer[i] = Integer.parseInt(stringArr[i]);
        }
        return answer;

    }

    public long solution(long n) {
        String answer = "";
        // long → String
        String num = String.valueOf(n);

        // String.split("")로 한 글자씩 잘라 배열에 담기
        String[] stringArr = num.toString().split("");

        Arrays.sort(stringArr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringArr.length; i++) {
            sb.append(stringArr[i]);
        }

        return Long.parseLong(sb.toString());

    }

    public long _제곱근(long n) {
        float result = (float) Math.sqrt(n);
        float really = (float) Math.ceil(result);
        float really2 = (float) Math.floor(result);
        boolean True = really == really2;
        if (True == true) {
            long result2 = (long) (result + 1);
            long answer = result2 * result2;
            return answer;
        }
        long answer = -1;
        return answer;
    }

    public int[] small(int[] arr) {
        int[] array = {};
        //배열 길이가 1인 경우
        if(arr.length == 1){
            int[] answer = {-1};
            return answer;
        }
        //배열길이가 1보다 클 때
        //가장 작은 수를 뺀 길이로 초기화
        int[] answer = new int[arr.length-1];

        int min = arr[0]; //하나의 값을 기준으로 잡음.
        //제일 작은 수를 구한다.
        for(int i=1; i<arr.length; i++){
            min = Math.min(min, arr[i]);
        }

        //반복문 index 용
        int index = 0;

        //가장 작은 수를 제외한 배열 만들기
        for(int i=0; i<arr.length; i++){
            //배열의 값이 가장 작은 수라면
            if(arr[i] == min){
                //continue를 이용해 배열에 넣지 않고 넘어간다.
                continue;
            }
            answer[index++] = arr[i];
        }

        return answer;
    }

    public boolean hashad(int x) {

        String y = String.valueOf(x);
        String[] xy = y.split("");
        int sum = 0;
        for (int i = 0; i < xy.length; i++) {
            sum += Float.parseFloat(xy[i]);
        }
        float xyz = x;
        float True = xyz / sum;
        float really = (float) Math.ceil(True);
        float really2 = (float) Math.floor(True);
        if (really == really2) {
            boolean answer = true;
            return answer;
        }
        boolean answer = false;
        return answer;
    }

    public int onebyone(int num) {
        long n = num;
        int count = 0;
        while (n != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
             count++;

        if (count > 500)
            return -1;
        }
        return count;
    }
}


















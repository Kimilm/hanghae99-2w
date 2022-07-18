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
        if (arr.length == 1) {
            int[] answer = {-1};
            return answer;
        }
        //배열길이가 1보다 클 때
        //가장 작은 수를 뺀 길이로 초기화
        int[] answer = new int[arr.length - 1];

        int min = arr[0]; //하나의 값을 기준으로 잡음.
        //제일 작은 수를 구한다.
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        //반복문 index 용
        int index = 0;

        //가장 작은 수를 제외한 배열 만들기
        for (int i = 0; i < arr.length; i++) {
            //배열의 값이 가장 작은 수라면
            if (arr[i] == min) {
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

    public int[] twointwo(int[] numbers) {
        // 어레이리스트 만들기
        ArrayList<Integer> sumArr = new ArrayList<>();
        // i가 numbers의 길이보다 1작을때까지 반복
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 1 + i; j < numbers.length; j++) {
                int temp = numbers[i] + numbers[j];
//                 배열 안에 숫자가 있으면 추가하지않고
//                 없으면 추가함
                if (sumArr.indexOf(temp) < 0) {
                    sumArr.add(temp);
                }
            }
        }
        int[] answer = new int[sumArr.size()];
        int index = 0;
        for (int num : sumArr) {
            answer[index++] = num;
        }
        Arrays.sort(answer);
        return answer;
    }

    public int three(int n) {
        int answer = 0;
        long getthree = Long.parseLong(Integer.toString(n, 3));
        long num = 0;
        while (getthree > 0) {
            num = (num * 10) + (getthree % 10);
            getthree /= 10;
        }
        answer = (Integer.parseInt(String.valueOf(num), 3));

        return answer;
    }


    public int[] holdtwo(int[] arr) {
        ArrayList<Integer> get = new ArrayList<>();
//      열의 끝까지 반복
        int i = 1;
        for (i = 1; i < arr.length; i++) {
//            열의 끝일 경우 값 그대로 출력
            if (arr[i] != arr[(i - 1)]) {
                get.add(arr[i - 1]);
            }
        }
        get.add(arr[i - 1]);
        int[] answer = new int[get.size()];
        int index = 0;
        for (int num : get) {
            answer[index++] = num;
        }
        return answer;
    }

    //    문자 내림차순 대문자는 맨뒤로
    public String Lower(String s) {
        String answer = "";
        ArrayList<String> upper = new ArrayList<>();
        char[] sxy = s.toCharArray();
        for (char c : sxy) {
            upper.add(String.valueOf(c));
        }
        upper.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String x : upper) {
            sb.append(x);
        }
        return sb.toString();
    }

    public int[] math(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (student1[i % student1.length] == answers[i]) answer1++;
            if (student2[i % student2.length] == answers[i]) answer2++;
            if (student3[i % student3.length] == answers[i]) answer3++;
        }
        int max = Math.max(Math.max(answer1, answer2), answer3);
        ArrayList<Integer> score = new ArrayList<Integer>();
        if (max == answer1) score.add(1); //max값이랑 같으면 넣는다.
        if (max == answer2) score.add(2);
        if (max == answer3) score.add(3);

        int[] answer = new int[score.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = score.get(i);
        }

        return answer;
    }

    public String[] 문자열_내맘대로(String[] strings, int n) {
        String[] answer = {};
//         리스트 만들기
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
//    리스트에 넣는다... 공백 뒤에 문자모음의 i번째.n번째 글자와 i번째 문자를
//    ex) " ssun"," bbed","ccar"
            arr.add(strings[i].charAt(n) + strings[i]);
        }
//         리스트를 오름차순 시킨다.
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {

            answer[i] = arr.get(i).substring(1);
        }
        return answer;
    }

    public int[] 로또(int[] lottos, int[] win_nums) {
        int zero = 0;
        int success = 0;
        ArrayList<Integer> lottonumber = new ArrayList<>();
        for (int S : lottos) {
            if (S == 0) {
                zero++;
            } else {
                lottonumber.add(S);
            }
        }
        for (int winnum : win_nums) {
            if (lottonumber.contains(winnum)) {
                success++;
            }
        }
        int man = 0;
        int change = success + zero;
        if (change == 6) {
            man = 1;
        } else if (change == 5) {
            man = 2;
        } else if (change == 4) {
            man = 3;
        } else if (change == 3) {
            man = 4;
        } else if (change == 2) {
            man = 5;
        } else {
            man = 6;
        }

        int oman = 0;
        if (success == 6) {
            oman = 1;
        } else if (success == 5) {
            oman = 2;
        } else if (success == 4) {
            oman = 3;
        } else if (success == 3) {
            oman = 4;
        } else if (success == 2) {
            oman = 5;
        } else {
            oman = 6;
        }


        int[] answer = {man, oman};


        return answer;
    }

    public int 문자를_숫자로(String s) {
        int answer = 0;
        String[][] change =
                {{"zero", "0"}, {"one", "1"}, {"two", "2"}, {"three", "3"}, {"four", "4"}, {"five", "5"}, {"six", "6"}, {"seven", "7"}, {"eight", "8"}, {"nine", "9"}};
        for (String[] R : change) {
            s = s.replaceAll(R[0], R[1]);
        }
        answer = Integer.parseInt(s);
        return answer;
    }

    public int 소수(int[] nums) {
        int numslength = nums.length;
        int count = 0;
        for (int i = 0; i < numslength - 2; i++) {

            for (int j = i + 1; j < numslength - 1; j++) {

                for (int k = j + 1; k < numslength; k++) {

                    int num = nums[i] + nums[j] + nums[k];
                    if (sosu(num)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean sosu(int math) {
        int sqrt = (int) Math.sqrt(math);
        for (int i = 2; i <= sqrt; i++) {
            if (math % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String 시저개색(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) { //소문자
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            } else if (Character.isUpperCase(ch)) { //대문자
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            }

            answer += ch;
        }


        return answer;
    }

    public int 약수의개수(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (yaksu(i) % 2 == 0) {
                answer -= i;
                System.out.println(answer);
            } else {
                answer += i;
                System.out.println(answer);
            }
        }
        return answer;
    }

    public int yaksu(int num) {
        int gaesu = 0;
        for (int j = 1; j < num; j++) {
            if (num % j == 0) {
                gaesu++;
            }
        }
        return gaesu;
    }

    public int 약수의합(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer;
    }

    public int 예산(int[] d, int budget) {
        int count = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            if (budget - d[i] < 0) {
                return count;
            } else {
                budget -= d[i];
                count++;
            }
        }
        return count;

    }

    public int[] 최대최소(int n, int m) {
        int big = Math.max(n, m);
        int small = Math.min(n, m);

        int max = gcd(big, small);
        int min = (m * n) / max;

        int[] answer = {max, min};
        return answer;
    }

    static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public int[] K번째수(int[] array, int[][] commands) {

        int[] answer = new int[3];
        for (int i = 0; i < commands.length; i++) {
            int[] arr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2] - 1];
        }

        return answer;
    }

    public int 나머지1(int n) {
        int answer = 0;
        int i = 1;
        for (i = 1; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                return answer;
            }


        }
        return answer;
    }

    public int 또소(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (suuuuu(i)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean suuuuu(int math) {
        int sqrt = (int) Math.sqrt(math);
        for (int i = 2; i <= sqrt; i++) {
            if (math % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int[] 실패율(int N, int[] stages) {
        int[] answer = new int[N];
        double[] stage = new double[N+1];      // 스테이지마다 머물러 있는 사용자수를 담을 배열
        // stage배열에 머물러있는 사용자수를 담는다 , 인덱스값이 스테이지번호
        for(int i : stages){
            if(i == N+1){
                continue;
            }
            stage[i]++;
        }
        // 실패율을 계산해 담을 list
        ArrayList<Double> fail = new ArrayList<Double>();
        //스테이지에 도달한 명수
        double num =stages.length;
        //다음 스테이지로 올라갈때 줄어드는 사용자수를 계산하기 위해 사용
        double tmp = 0;
        //실패율을 구한 후 다시 stage배열에 담고, fail 리스트에도 담아준다.
        for(int i=1; i<stage.length; i++){
            tmp = stage[i];
            // 도달한 사용자 수가 0 일때, 실패율도 0
            if(num == 0){
                stage[i]=0;
            }else{
                stage[i] = stage[i]/num;
                num = num - tmp;
            }
            fail.add(stage[i]);
        }
        //  fail 리스트를 내림차순으로 정렬해준다.
        Collections.sort(fail,Collections.reverseOrder());
        //정렬된 fail리스트 값과 stage값을 비교해서 같으면 stage의 인덱스번호(스테이지번호)를 가져옴으로써
        //실패율이 높은 순으로 answer배열에 넣어준다.
        for(int i=0; i<fail.size(); i++){
            for(int j=1; j<stage.length; j++){
                if(fail.get(i) == stage[j]){
                    answer[i] = j;
                    stage[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}






















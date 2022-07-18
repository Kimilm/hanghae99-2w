package yeaseul;

import java.util.*;

public class Solutions {
    
    // https://programmers.co.kr/learn/courses/30/lessons/12901
    public String _2016년(int a, int b) {
        // String[] day = {"THU","FRI","SAT", "SUN","MON","TUE","WED"};
        // int allDay = calcDay(a, b);
        // int dayChar = allDay%7;
        // // System.out.println(allDay + " 몇번째? "+ dayChar);
        // return day[dayChar];
         int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = new String[]{"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        int days = b;

        for (int i = 0; i < a; ++i) {
            days += month[i];
        }

        days %= 7;

        return week[days];
    }
    
    // public int calcDay(int a, int b){
    //     int allDay = 0;
    //     for(int i=1; i<a; i++){
    //         switch(i) {
    //             case 1,3,5,7,8,10,12:
    //                 allDay += 31;
    //                 break;
    //             case 2:
    //                 allDay += 29;
    //                 break;
    //             case 4,6,9,11,30:
    //                 allDay += 30;
    //                 break;
    //             default:
    //                 System.out.println("invalid month");
    //                 break;
    //         }
    //     }
    //     allDay += b;
    //     return allDay;
    // }

    // https://programmers.co.kr/learn/courses/30/lessons/12910
    public int[] 나누어_떨어지는_숫자_배열(int[] arr, int divisor) {
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for(Integer i : arr){
            if(i%divisor == 0) list.add(i);
        }
        
        if( list.size() == 0) return new int[]{-1};
        int[] answer = list.stream().mapToInt(i->i).toArray();
        // for(int t : test) System.out.println(t);
        // int[] answer = new int[list.size()];
        // for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
        return answer;
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12922
    public String 수박수박수박수박수박수 (int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String word = "";
        for(int i=1; i<=n; i++){
            if(i%2 == 1){
                // word = "수"; 
                sb.append("수");
            }else if(i%2 == 0){
                // word = "박"; 
                sb.append("박");
            }
            // answer += word;
            
        }
        return new String(sb);
    }

    // https://programmers.co.kr/learn/courses/30/lessons/42576
    public String 완주하지_못한_선수(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0)+1);
        }
        for(String c : completion){
            map.replace(c, map.get(c)-1);
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) answer = entry.getKey();
        }
        
        return answer;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12930
    public String 이상한_문자_만들기(String s){
        StringBuilder sb = new StringBuilder();
        String[] sArr = s.split("");

        int j=0;
        for(int i=0; i<sArr.length; i++){
            if(sArr[i].equals(" ")) {
                sb.append(" ");
                j=0;
            }else{
                if(j%2 == 0){
                    sb.append(sArr[i].toUpperCase());
                }else{
                    sb.append(sArr[i].toLowerCase());
                }
                j++;
            }
        }
        return new String(sb);
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12931
    public int 자릿수_더하기(int n) {
        String num = String.valueOf(n);
        String[] numArr = num.split("");
        int answer = Arrays.stream(numArr)
                        .mapToInt(Integer::parseInt)
                        .sum();
        
        return answer;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12932
    public int[] 자연수_뒤집어_배열로_만들기(long n) {
        String[] nArr=String.valueOf(n).split("");
        int[] answer = new int[nArr.length];
        int index = 0;
        for(int i=nArr.length-1; i>=0; i--){
            answer[index]= Integer.valueOf(nArr[i]);
            index++;
        }
        return answer;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12933
    public long 정수_내림차순으로_배치하기(long n) {
        StringBuilder sb = new StringBuilder();
        String[] num = String.valueOf(n).split("");
        Arrays.sort(num);
        for(int i=num.length-1; i>=0; i--){
            sb.append(num[i]);
        }
        return Long.valueOf(new String(sb));
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12934
    public long 정수_제곱근_판별(long n) {
        long answer = 0;

        int i=1;
        double zegob = (i) * (i);
        while(n > (long)zegob){
            i++;
            zegob = Math.pow(i,2);
        }

        if(n == zegob) answer = (long) (i+1) * (i+1);
        else answer = -1;

        return answer;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12935
    public int[] 제일_작은_수_제거하기(int[] arr) {

        if(arr.length == 1) return new int[]{-1};
        int[] copyArr = arr.clone();
        Arrays.sort(copyArr);

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(copyArr[0]==arr[i]) continue;
            list.add(arr[i]);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12943
    public int 콜라츠_추측(int num) {
        int answer = 0;

        for(int i=0; i<500; i++){
            if(num == 1) break;

            if(num%2 == 0){
                num = num/2;
            }else if(num%2 == 1){
                num = (num*3)+1;
            }
            answer++;
        }

        if(num != 1) answer = -1;
        return answer;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12947
    public boolean 하샤드_수(int x) {
        boolean answer = false;
        String[] xStr = String.valueOf(x).split("");
        int hab = 0;
        for(String xs : xStr){
            hab += Integer.valueOf(xs);
        }
        if(x%hab == 0) answer=true;

        return answer;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/68935
    public int _3진법_뒤집기(int n){
        
        List<Integer> list = new ArrayList<>();
        while(n>2){
            list.add(n%3);
            n /= 3;
        }
        list.add(n);
 
        // 3^0 * 1 + 3^1*2 + 3^2*0 + 3^3*0
        int[] reverseArr = new int[list.size()];
        int index = list.size()-1;
        double sibzin = 0;
        for(int i=0; i<list.size(); i++){
            int gob = list.get(index);
            sibzin += Math.pow(3, i) * gob ; // 3^0 * 1 + 3^1*2 + 3^2*0 + 3^3*0
            index--;
        } 
        
        return (int) sibzin;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/86491#
    public int 최소직사각형(int[][] sizes) {
        int rightMax = 0;
        int leftMax = 0;
        
        for(int[] s : sizes){
            if(s[0] < s[1]){
                int shakeit = s[0];
                s[0] = s[1];
                s[1] = shakeit;
            }
            rightMax = Math.max(s[1], rightMax);
            leftMax = Math.max(s[0], leftMax);
        }
        
        return rightMax * leftMax;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12906
    public int[] 같은_숫자는_싫어(int []arr) {
        
        int log = 10;
        List<Integer> list = new ArrayList<>();
        for(int a : arr){
            if(log != a){
                list.add(a);
                log = a;
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/68644
    public int[] 두_개_뽑아_더하기(int[] numbers) {
        
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        
        int[] answer = new int[set.size()];
        int c = 0;
        for(int x : set) answer[c++] = x;
        
        Arrays.sort(answer);
        return answer;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/77484
    public int[] 로또의_최고_순위와_최저_순위(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int collect = 0;
        int unkonwV = 0;
        for(int l : lottos) if(l==0) unkonwV++;
        int j=0;
        for(int i=0; i<win_nums.length; i++){
            while(win_nums[i] >= lottos[j]){
                if(win_nums[i]==lottos[j]) collect++;
                if(j >= win_nums.length-1) break;
                j++;
            }
        }

        int[] score = {6, 6, 5, 4, 3, 2, 1};
        int maxScore = collect+unkonwV;

        // System.out.println(maxScore+ "개 맞으셨군요! "+ score[maxScore]+" 등입니다.");
        // System.out.println(collect+ "개 맞으셨군요! "+ score[collect]+" 등입니다.");
        int[] answer = {score[maxScore], score[collect]};
        return answer;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/42840
    public int[] 모의고사(int[] answers) {
        int[][] supoza = {{1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        int maxScore = 0;
        int[] scorelist= new int[supoza.length];
        for(int i=0; i< supoza.length; i++){
            int score = collect(supoza[i], answers);
            scorelist[i] = score;
            maxScore = Math.max(score,maxScore);
        }

        List<Integer> list = new ArrayList<>();
        for(int j=0; j<scorelist.length;j++){
            if(scorelist[j] == maxScore) list.add(j+1);
        }

//         int[] supoza1 = {1, 2, 3, 4, 5};
//         int[] supoza2 = {2, 1, 2, 3, 2, 4, 2, 5};
//         int[] supoza3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

//         int score1 = collect(supoza1, answers);
//         int score2 = collect(supoza2, answers);
//         int score3 = collect(supoza3, answers);

//         // int maxScore = Collections.max(list);
//         int maxScore = Math.max(score1, Math.max(score2, score3));

//         List<Integer> list = new ArrayList<>();
//         if(score1 == maxScore) list.add(1);
//         if(score2 == maxScore) list.add(2);
//         if(score3 == maxScore) list.add(3);

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int collect(int[] supoza, int[] answers){
        int s=0;
        int collect = 0;
        for(int i=0; i<answers.length; i++){
            if(s >= supoza.length) s=0;
            if(answers[i] == supoza[s]) collect++;
            s++;
        }
        return collect;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12915
    public String[] 문자열_내_마음대로_정렬하기(String[] strings, int n) {
        String[] answer = new String[strings.length];

        ArrayList<String> stringsArr = new ArrayList<>();
        for(String string : strings){
            stringsArr.add(string.charAt(n) + string);
        }
//        stringsArr.sort();
        Collections.sort(stringsArr);

        for(int i=0; i<stringsArr.size(); i++){
            answer[i] = stringsArr.get(i).substring(1);
        }

        return answer;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12917
    public String 문자열_내림차순으로_배치하기(String s) {

        String answer = "";
        String[] str = s.split("");

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int s1 = (byte)o1.charAt(0);
                int s2 = (byte)o2.charAt(0);
                return s2-s1;
            }
        });

        return String.join("",str);
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12977
    public int 소수_만들기(int[] nums) {
        int answer = 0;
        int len = nums.length;
        int hab = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    hab = nums[i] + nums[j] + nums[k];
                    // System.out.println(nums[i] +" + " + nums[j] + " + " + nums[k] + " = "+ hab);
                    if(sosu(hab)) answer++;
                }
            }
        }
        return answer;
    }

    public boolean sosu(int hab){
        for(int i=2; i < hab; i++)
            if(hab%i == 0)
                return false;
        return true;
    }
        /*
        // DFS 지지

        StringBuilder sb = new StringBuilder();
        for(int n : nums) sb.append(n);
        String arr= new String(sb);


        int n=arr.length();
        boolean[] chosen = new boolean[n];
        // System.out.println("\n" + n + " 개 중에서 3 개 뽑기");
        combination_DFS(arr,chosen,0,n,3);

        List<Integer> list = new ArrayList<>(sum);

        Iterator iter = sum.iterator();
        while(iter.hasNext()) {
            int sosuInGa = Integer.valueOf(iter.next().toString());
            // System.out.println(sosuInGa);
            sosu(sosuInGa, list);
        }

        return list.size();
    }

    static Set<Integer> sum = new HashSet<>();
    static void combination_DFS(String arr, boolean[] chosen, int start, int  n, int r){
        if(r == 0){
            sumFunc(arr, chosen, n);
            return;
        }
        if(start == n) return;
        chosen[start]=true;
        combination_DFS(arr, chosen, start+1, n ,r-1);
        chosen[start] = false;
        combination_DFS(arr, chosen, start+1, n ,r);
    }

    static void sumFunc(String arr, boolean[] chosen, int n){
        String[] arrArr = arr.split("");

        int hab = 0;
        for(int i=0; i<n; i++){
            if(chosen[i]){
                // System.out.print(arrArr[i] + " ");
                hab += Integer.valueOf(arrArr[i]);
            }
        }
        sum.add(hab);
        // System.out.print( " = "+ hab+ " 다음 선수 ! !!!!!!!!");
    }

    static void sosu(int sosuInGa, List<Integer> list){
        for(int i=2; i < sosuInGa; i++){
            if(sosuInGa%i == 0){
                list.remove(list.indexOf(sosuInGa));
                break;
            }
        }
    }

    */

    // https://school.programmers.co.kr/learn/courses/30/lessons/81301
    public int 숫자_문자열과_영단어(String s) {
        String[] strArr = {"zero", "one" ,"two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0; i<10; i++){
            s = s.replaceAll(strArr[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12926
    public String 시저_암호(String s, int n) {

        char[] answerArr = new char[s.length()];
        String[] sArr = s.split("");
        for(int i=0; i<s.length(); i++) {
            // if(s.charAt(i)== ' '){
            //     answerArr[i] = ' ';
            //     continue;
            // }
            // char alpa = s.charAt(i);
            // boolean condition = alpa >= 'a' && alpa <='z' && alpa + n > 'z' || alpa >= 'A' && alpa <='Z'&& alpa + n > 'Z';
            // if(condition){
            //     answerArr[i] = (char)(alpa + n-26);
            // }else{
            //     answerArr[i] = (char)(alpa+n);
            // }

            char alpa = s.charAt(i);
            if(alpa >= 'a' && alpa <='z'){
                if(alpa + n > 'z'){
                    answerArr[i] = (char)(alpa + n-26);
                }else answerArr[i] = (char)(alpa+n);
            }else if(alpa >= 'A' && alpa <='Z'){
                if(alpa + n > 'Z'){
                    answerArr[i] = (char)(alpa + n-26);
                }else answerArr[i] = (char)(alpa+n);
            }else answerArr[i] = (char)alpa;
        }

        return String.valueOf(answerArr);
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/72410
    public String 신규_아이디_추천(String new_id) {
        String step1 = new_id.toLowerCase();
        String step2 = step1.replaceAll("[^-_.a-z0-9]", "");
        String step3 = step2.replaceAll("[.]+", ".");
        String step4 = step3.replaceAll("^[.]|[.]$", "");

        //step5
        if(step4.isEmpty()) step4 = "a";

        //step6
        if(step4.length() >= 16) {
            step4 = step4.substring(0,15);
            step4 = step4.replaceAll("^[.]|[.]$", "");
        }

        // step7
        if(step4.length() <= 2){
            int length = step4.length();
            String iter = step4.substring(length-1, length);
            for(int i=length; i<3; i++) step4 += iter;
        }

        return step4;
    }
}

package yeaseul;

import java.util.*;

public class Solutions {
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
}

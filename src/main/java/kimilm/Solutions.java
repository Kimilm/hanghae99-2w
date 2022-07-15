package kimilm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solutions {
    // https://programmers.co.kr/learn/courses/30/lessons/12901
    public String _2016년(int a, int b) {
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = new String[]{"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        int days = b;

        for (int i = 0; i < a; ++i) {
            days += month[i];
        }

        days %= 7;

        return week[days];
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12910
    public int[] 나누어_떨어지는_숫자_배열(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        for(int num : arr) {
            if (num % divisor == 0) {
                list.add(num);
            }
        }

        if (list.size() == 0) {
            list.add(-1);
        }

        Collections.sort(list);
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12922
    public String 수박수박수박수박수박수 (int n) {
        String[] watermelon = new String[] {"수", "박"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(watermelon[i % 2]);
        }

        return sb.toString();
    }
}

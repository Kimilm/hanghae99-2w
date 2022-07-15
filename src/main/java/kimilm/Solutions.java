package kimilm;

import java.util.*;
import java.util.stream.Collectors;

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

        for (int num : arr) {
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
    public String 수박수박수박수박수박수(int n) {
        String[] watermelon = new String[]{"수", "박"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(watermelon[i % 2]);
        }

        return sb.toString();
    }

    // https://programmers.co.kr/learn/courses/30/lessons/42576
    public String 완주하지_못한_선수(String[] participant, String[] completion) {
        Map<String, Integer> marathon = new HashMap<>();

        for (String person : participant) {
            marathon.put(person, marathon.getOrDefault(person, 0) + 1);
        }

        for (String person : completion) {
            marathon.put(person, marathon.get(person) - 1);
        }

        String answer = "";

        for (Map.Entry<String, Integer> entry : marathon.entrySet()) {
            if (entry.getValue() == 1) {
                answer = entry.getKey();
            }
        }

        return answer;
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12931
    public int 자릿수_더하기(int n) {
        String str = String.valueOf(n);
        return Arrays.stream(str.split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12930
    public String 이상한_문자_만들기(String s) {
        // 공백이 두개면 두개를 남겨야 함
        char[] chars = s.toUpperCase().toCharArray();

        int flag = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                flag = 0;
                continue;
            }
            if (flag % 2 == 1) {
                chars[i] = Character.toLowerCase(chars[i]);
            }
            ++flag;
        }

        return new String(chars);
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12932
    public int[] 자연수_뒤집어_배열로_만들기(long n) {
        String str = String.valueOf(n);
        StringBuilder sb = new StringBuilder(str).reverse();

        return sb.chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12933
    public long 정수_내림차순으로_배치하기(long n) {
        String str = String.valueOf(n).chars()
                .map(Character::getNumericValue)
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining());

        return Long.parseLong(str);
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12935
    public int[] 제일_작은_수_제거하기(int[] arr) {
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        Integer min = Collections.min(list);
        list.remove(min);

        if (list.size() == 0) {
            list.add(-1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12934
    public long 정수_제곱근_판별(long n) {
        long sqrt = (long) Math.sqrt(n);
        long pow = (long) Math.pow(sqrt, 2);

        if (pow != n) {
            return -1;
        }
        return (long) Math.pow(sqrt + 1, 2);
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12943
    public int 콜라즈_추측(int num) {
        long longNum = num;
        int answer = 0;

        while(answer < 500) {
            if (longNum == 1) {
                return answer;
            }
            if (longNum % 2 == 0) {
                longNum /= 2;
            } else {
                longNum = longNum * 3 + 1;
            }
            ++answer;
        }

        return -1;
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12947
    public boolean 하샤드_수(int x) {
        int sum = 자릿수_더하기(x);
        return x % sum == 0;
    }
}

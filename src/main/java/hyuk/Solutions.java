package hyuk;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

    public int[] 같은_숫자는_싫어(int[] arr) {
        ArrayList<Integer> list = new ArrayList();

        int dup = -1;

        for (int i = 0; i < arr.length; i++) {
            if (dup != arr[i]) {
                dup = arr[i];

                list.add(arr[i]);
            }
        }
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;


    }

    public int threeReverse(int n) {
        String three = Integer.toString(n, 3);

        StringBuffer sb = new StringBuffer(three);
        String reversedThree = sb.reverse().toString();
        int ten = Integer.parseInt(reversedThree, 3);

        return ten;
    }

    public int[] pickTwoPlus(int[] numbers) {
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int num = numbers[i] + numbers[j];
                if (!array.contains(num)) {
                    array.add(num);
                    //set 집합
                }
            }
        }
        int[] answer = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            answer[i] = array.get(i);
        }

        Arrays.sort(answer);
        return answer;
    }

    public int[] lotto(int[] lottos, int[] win_nums) {
        int[] answer = {};
        return answer;
    }

    public int makePrime(int[] nums) {
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int h = j + 1; h < nums.length; h++) {
                    sum = nums[i] + nums[j] + nums[h];
                    if (isPrime(sum)) {
                        answer++;

                    }

                }
            }

        }

        return answer;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;    // 1은 소수가 아니다.
        if (num <= 3) return true;    // 2와3은 소수이다.
        for (int i = 2; i <= num - 1; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public int switchNumStr(String s) {
        String words[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < words.length; i++) {
            s = s.replace(words[i], String.valueOf(i));
        }


        return Integer.parseInt(s);
    }

    public String caesar(String s, int n) {

//
//        char[] charArr = s.toCharArray();
//        for (int i=0; i < charArr.length ;i++) {
//            int ascii = charArr[i];
//            if(ascii == 32)continue;
//
//            if (ascii == 122 && n == 1){
//                ascii = 96;}
//
//            if (ascii == 122 && n != 1){
//                ascii = 97;
//                charArr[i] = (char)(ascii+n-1);
//                continue;
//
//            }
//            if (ascii == 90 && n == 1){ascii = 64; }
//
//            if(ascii == 90 && n != 1){
//                ascii = 65;
//                charArr[i] = (char)(ascii+n-1);
//                continue;
//            }
//            charArr[i] = (char)(ascii+n);
//
//        }
//        String answer = new String(charArr);
//
//
//
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 97 && ch <= 122) { //소문자
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            } else if (ch >= 65 && ch <= 90) { //대문자
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            }
            answer += ch;
        }
        return answer;


    }

    public int 약수개수덧셈뺄셈(int left, int right) {

        int sum = 0;
        int count = 0;
        for (int i = left; i <= right; i++) {
            sum += i;

            for (int j = 1; j * j <= i; j++) {
                if (j*j == i) count++;
                else if (i % j == 0) count += 2;


                if (count % 2 != 0){
                    sum = sum -(i*2);
                }
                count = 0;
            }



        }

        return sum;
    }
}



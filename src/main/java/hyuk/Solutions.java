package hyuk;

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
        String three = Integer.toString(n,3);

        StringBuffer sb = new StringBuffer(three);
        String reversedThree = sb.reverse().toString();
        int ten = Integer.parseInt(reversedThree,3);

        return ten;
    }

    public int[] pickTwoPlus(int[] numbers) {
        ArrayList<Integer> array = new ArrayList<>();

        for(int i = 0; i<numbers.length-1; i++){
            for(int j = i+1; j<numbers.length; j++){
                int num = numbers[i]+numbers[j];
                if(!array.contains(num)){
                    array.add(num);
                    //set 집합
                }
            }
        }
        int[] answer = new int[array.size()];
        for(int i = 0; i<array.size(); i++){
            answer[i] = array.get(i);
        }

        Arrays.sort(answer);
        return answer;
    }


}



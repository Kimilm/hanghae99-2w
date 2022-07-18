package hyuk;

import org.junit.jupiter.api.Test;

class SolutionsTest {
    private Solutions solution = new Solutions();

    @Test
    void Dateyoung() {
        String result = solution.Dateyoung(5, 24);
        System.out.println(result);
    }

    @Test
    void 같은_숫자는_싫어(){
//        https://school.programmers.co.kr/learn/courses/30/lessons/12906#
        int[] arr = new int[] {1, 1, 3, 3, 0, 1, 1};
        int[] result = solution.같은_숫자는_싫어(arr);

        System.out.println(result);
    }
    @Test
    void threeReverse() {
//        https://school.programmers.co.kr/learn/courses/30/lessons/68935
        int n = 45;
        int result = solution.threeReverse(n);

        System.out.println(result);
    }
    @Test
    void pickTwoPlus(){
//        https://school.programmers.co.kr/learn/courses/30/lessons/68644

        int[] arr =  {2,1,3,4,1};
        int[] result = solution.pickTwoPlus(arr);

        System.out.println(result);
    }

    @Test
    void makePrime(){
        //https://programmers.co.kr/learn/courses/30/lessons/12977
        int[] nums = {1,2,7,6,4};
        int result = solution.makePrime(nums);
        System.out.println(result);

    }
    @Test
    void switchNumStr(){
        //https://school.programmers.co.kr/learn/courses/30/lessons/81301
        String s = "one4seveneight";

        int result = solution.switchNumStr(s);
        System.out.println(result);


    }
    @Test
    void  caesar(){
        //https://school.programmers.co.kr/learn/courses/30/lessons/12926
        String s = "AB";
        int n = 1;

        String result = solution.caesar(s,n);
        System.out.println(result);
    }

    @Test
    void 약수개수덧셈뺄셈(){
//        https://school.programmers.co.kr/learn/courses/30/lessons/77884
        int left = 24;
        int right = 27;
        int result = solution.약수개수덧셈뺄셈(left,right);
        System.out.println(result);
    }


}

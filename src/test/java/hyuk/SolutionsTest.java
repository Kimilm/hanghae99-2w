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
}

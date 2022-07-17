package yeaseul;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionsTest {
    private Solutions solution = new Solutions();

    @Test
    void 이상한_문자_만들기() {
        String s = "try hello world";
        String result = solution.이상한_문자_만들기(s);
        System.out.println(result);
    }

    @Test
    void _2016년() {
        String result = solution._2016년(5, 24);
        System.out.println(result);
    }

    @Test
    void 나누어_떨어지는_숫자_배열() {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        int[] result = solution.나누어_떨어지는_숫자_배열(arr, divisor);
        System.out.println(result);
    }


    @Test
    void 수박수박수박수박수박수() {
        String result = solution.수박수박수박수박수박수(3);
        System.out.println(result);
    }

    @Test
    void 완주하지_못한_선수() {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki","eden"};
        String result = solution.완주하지_못한_선수(participant, completion);
        System.out.println(result);
    }

    @Test
    void _3진법_뒤집기() {
        assertEquals(7, solution._3진법_뒤집기(45));
        assertEquals(229, solution._3진법_뒤집기(125));
    }
}


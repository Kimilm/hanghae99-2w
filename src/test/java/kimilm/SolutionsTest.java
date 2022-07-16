package kimilm;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionsTest {
    private Solutions solution = new Solutions();

    @Test
    void _2016년() {
        String result = solution._2016년(5, 24);
        System.out.println(result);
    }

    @Test
    void 수박수박수박수박수박수() {
        String result = solution.수박수박수박수박수박수(3);
        System.out.println(result);
    }

    @Test
    void 이상한_문자_만들기() {
        String result = solution.이상한_문자_만들기("try hello world");
        System.out.println(result);
    }

    @Test
    void 자연수_뒤집어_배열로_만들기() {
        int[] result = solution.자연수_뒤집어_배열로_만들기(12345);
        System.out.println(Arrays.toString(result));
    }

    @Test
    void 정수_내림차순으로_배치하기() {
        long result = solution.정수_내림차순으로_배치하기(118372);
        System.out.println(result);
    }

    @Test
    void 모의고사() {
        int[] result = solution.모의고사(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(result));
    }
}
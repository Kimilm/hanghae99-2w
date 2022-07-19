package kimilm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void 소수_만들기() {
        int result = solution.소수_만들기(new int[]{1, 2, 7, 6, 4});
        assertEquals(4, result);
    }

    @Test
    void 신규_아이디_추천() {
        String result = solution.신규_아이디_추천("...!@BaT#*..y.abcdefghijklm");
        assertEquals("bat.y.abcdefghi", result);
    }

    @Test
    void getSubmultiple() {
        List<Integer> result = solution.getSubmultiple(12);
        assertEquals(Arrays.asList(1, 2, 3, 4, 6, 12), result);
    }

    @Test
    void k번째수() {
        int[] result = solution.K번째수(
                new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{
                        {2, 5, 3},
                        {4, 4, 1},
                        {1, 7, 3}
                });

        assertEquals(new int[]{5, 6, 3}, result);
    }

    @Test
    void hanghae() {
        assertEquals("3월 5일", solution.신대륙_발견(11, 27));
        assertEquals("9월 28일", solution.신대륙_발견(6, 22));
        assertEquals("4월 26일", solution.신대륙_발견(1, 18));
    }

    @Test
    void 소수_찾기() {
        assertEquals(4, solution.소수_찾기(10));
        assertEquals(3, solution.소수_찾기(5));
    }
}
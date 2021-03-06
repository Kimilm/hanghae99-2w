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

    @Test
    void 체육복() {
        assertEquals(5, solution.체육복(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }

    @Test
    void 비밀지도() {
        assertEquals(
                new String[]{"#####", "# # #", "### #", "# ##", "#####"},
                solution.비밀지도(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})
        );
    }

    @Test
    void 키패드_누르기() {
        assertEquals("LRLLRRLLLRR", solution.키패드_누르기(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
    }

    @Test
    void 다트게임() {
        assertEquals(37, solution.다트게임("1S2D*3T"));
        assertEquals(9, solution.다트게임("1D2S#10S"));
        assertEquals(3, solution.다트게임("1D2S0T"));
        assertEquals(23, solution.다트게임("1S*2T*3S"));
        assertEquals(5, solution.다트게임("1D#2S*3S"));
        assertEquals(-4, solution.다트게임("1T2D3D#"));
        assertEquals(59, solution.다트게임("1D2S3T*"));
    }

    @Test
    void 크레인_인형뽑기_게임() {
        assertEquals(4, solution.크레인_인형뽑기_게임(
                new int[][]{
                        {0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 3},
                        {0, 2, 5, 0, 1},
                        {4, 2, 4, 4, 2},
                        {3, 5, 1, 3, 1}
                },
                new int[]{1, 5, 3, 5, 1, 2, 1, 4}
        ));
    }
}
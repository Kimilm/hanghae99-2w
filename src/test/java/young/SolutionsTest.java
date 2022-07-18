package young;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class SolutionsTest {

    private Solutions solution = new Solutions();

    @Test
    void Dateyoung() {
        String result = solution.Dateyoung(5, 24);
        System.out.println(result);
    }

    @Test
    void _제곱근() {
        float result = solution._제곱근(123);
        System.out.println(result);
    }

    @Test
    void who_arrive() {
        String[] a = {"leo", "kiki", "eden"} ;
        String[] b = {"eden", "kiki"} ;
        String result = solution.who_arrive(a,b);
        System.out.println(result);
    }
    @Test
    void small() {
        int[] arr = {4,3,2,1};
        int[] result = solution.small(arr);
        System.out.println(result);
    }

    @Test
    void onebyone() {
        int result = solution.onebyone(6);
        System.out.println(result);
    }
    @Test
    void twointwo() {
        int[] arr = {2,1,3,4,1};
        int[] result = solution.twointwo(arr);
        System.out.println(result);
    }
    @Test
    void three() {
        int result = solution.three(120000);
        System.out.println(result);
    }

    @Test
    void holdtwo(){
        int[] arr = {2,1,3,4,1};
        int[] result = solution.holdtwo(arr);
        System.out.println(result);
    }
    @Test
    void Lower(){
        String result = solution.Lower("Zbcdefg");
        System.out.println(result);
    }

    @Test
    void 약수의개수(){
        int result = solution.약수의개수(13,17);
        System.out.println(result);
    }
    @Test
    void 예산(){
        int result = solution.예산(new int[]{2, 2, 3, 3},10);
        System.out.println(result);
    }

    @Test
    void 최대최소(){
        int[] result = solution.최대최소(1200,1500);
        System.out.println(result[0]+"="+result[1]);
    }

    @Test
    void K번째수(){
        int[][] arr = {{2,5,3},{4,4,1},{1,7,3}};
        int[] result = solution.K번째수(new int[]{1, 5, 2, 6, 3, 7, 4}, arr);
        System.out.println(result[0]+"="+result[1]);
    }


}
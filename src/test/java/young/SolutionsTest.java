package young;

import org.junit.jupiter.api.Test;

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
}
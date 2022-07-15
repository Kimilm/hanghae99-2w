package young;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionsTest {

    private Solutions solution = new Solutions();
    @Test
    void Dateyoung() {
        String result = solution.Dateyoung(5, 24);
        System.out.println(result);
    }

    @Test
    void suback() {
        String result = solution.suback(3);
        System.out.println(result);
    }

    @Test
    void who_arrive() {
        String[] a = {"leo", "kiki", "eden"} ;
        String[] b = {"eden", "kiki"} ;
        String result = solution.who_arrive(a,b);
        System.out.println(result);
    }
}
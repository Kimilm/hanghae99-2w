package kimilm;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionsTest {
    private Solutions solution = new Solutions();

    @Test
    void _2016년() {
        String result = solution._2016년(5, 24);
        System.out.println(result);
    }
}
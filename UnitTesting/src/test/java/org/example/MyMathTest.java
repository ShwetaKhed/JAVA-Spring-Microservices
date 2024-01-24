package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyMathTest{

    @Test
    public void test(){
        int[] numbers = {1,2,3};
        MyMath myMath = new MyMath();
        int sum = myMath.calculateSum(numbers);
        assertEquals(6, sum);


    }

}
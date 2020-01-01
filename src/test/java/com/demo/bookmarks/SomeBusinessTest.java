package com.demo.bookmarks;

import com.demo.bookmarks.testing.SomeBusinessImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SomeBusinessTest {
    @Test
    public void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {1,2,3,});
        int expectedResult = 8;
        assertEquals(expectedResult, actualResult);
    }
}

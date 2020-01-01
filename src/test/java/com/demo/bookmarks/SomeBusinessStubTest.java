package com.demo.bookmarks;

import com.demo.bookmarks.service.SomeDataService;
import com.demo.bookmarks.testing.SomeBusinessImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SomeDataServiceStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {1,2,3};
    }
}
public class SomeBusinessStubTest {
    @Test
    public void calculateSumService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }
}

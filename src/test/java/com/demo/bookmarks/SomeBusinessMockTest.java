package com.demo.bookmarks;

import com.demo.bookmarks.service.SomeDataService;
import com.demo.bookmarks.testing.SomeBusinessImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {
    /*SomeBusinessImpl business = new SomeBusinessImpl();
    SomeDataService dataServiceMock = mock(SomeDataService.class);
    @Before
    public void before() {
        business.setSomeDataService(dataServiceMock);
    }*/

    @InjectMocks
    SomeBusinessImpl business = new SomeBusinessImpl();
    @Mock
    SomeDataService dataServiceMock;


    public void setWhen(int[] data) {
        when(dataServiceMock.retrieveAllData())
                .thenReturn(data);
    }

    @Test
    public void calculateSumService_basic() {

        setWhen(new int[]{1,2,3});
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumService_zero() {

        setWhen(new int[]{});
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }
}

package com.demo.bookmarks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ListMockTest {
    @Mock
    List<String> mock = mock(List.class);

    @Test
    public void test() {
        when(mock.size())
                .thenReturn(5);
        assertEquals(5,mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size())
                .thenReturn(5)
                .thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt()))
                .thenReturn("adad");
        assertEquals("adad",mock.get(0));
    }

    @Test
    public void verificationBasics() {
        String value = mock.get(0);
        String value2 = mock.get(0);

        verify(mock).get(0);
        verify(mock).get(anyInt());
        verify(mock, times(2
         )).get(anyInt());
    }




}

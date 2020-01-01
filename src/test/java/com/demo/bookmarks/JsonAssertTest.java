package com.demo.bookmarks;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
    String actualResponse = "{\"id\":1, \"name\": \"Ball\", \"price\":10, \"quantity\": 100 }";

    @Test
    public void jsonAssert() throws JSONException {
        String expectedResponse = "{\"id\":1, \"name\": \"Ball\", \"price\":11}";
        JSONAssert.assertEquals(expectedResponse,actualResponse, false);
    }
}

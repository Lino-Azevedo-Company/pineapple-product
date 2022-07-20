package com.pineapple.product.service.config;
import net.minidev.json.JSONValue;
import org.springframework.test.web.servlet.MvcResult;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public abstract class AbstractIntegrationTest {
    protected String jsonAsString(final String path) {
        InputStreamReader reader = new InputStreamReader(getClass()
                .getResourceAsStream(String.format("/com/pineapple/product/service/test/jsons/%s", path)), StandardCharsets.UTF_8);
        return JSONValue.parse(reader).toString();
    }

    protected String getResultAsJson(MvcResult result) throws UnsupportedEncodingException {
        return result.getResponse().getContentAsString();
    }
}

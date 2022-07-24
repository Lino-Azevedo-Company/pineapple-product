package com.pineapple.product.service.restapi;

import com.pineapple.product.service.config.AbstractControllerTest;
import com.pineapple.product.service.config.IntegrationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@IntegrationTest
public class ProductControllerTest extends AbstractControllerTest {

    @Test
    @DisplayName("Given A Request To List Products Should Return 200 And The List Of Products")
    @Sql({
            "/com/pineapple/product/service/test/sql/drop-database.sql",
            "/com/pineapple/product/service/test/sql/create-database.sql"
    })
    @Sql(
            "/com/pineapple/product/service/test/sql/products.sql"
    )
    void givenARequestToListProductsShouldReturn200AndTheListOfProducts() throws Exception {
        var result = getMockMvc()
                .perform(get("/products/"))
                .andExpect(status().isOk())
                .andReturn();
        var json = getJsonArray(result);


        JSONAssert.assertEquals(
                jsonAsString("two-or-more-products.json"),
                getResultAsJson(result),
                true
        );
        assertThat(json.length(),equalTo(3));
    }

    @Test
    @Sql({
            "/com/pineapple/product/service/test/sql/drop-database.sql",
            "/com/pineapple/product/service/test/sql/create-database.sql"
    })
    @Sql(
            "/com/pineapple/product/service/test/sql/products.sql"
    )
    void givenARequestToFindAProductByItsIdShouldReturn200AndTheRequestedProduct() throws Exception {
        var result = getMockMvc()
                .perform(get("/products/1"))
                .andExpect(status().isOk())
                .andReturn();

        JSONAssert.assertEquals(
                jsonAsString("one-product.json"),
                getResultAsJson(result),
                true
        );
    }

    @Test
    @Sql({
            "/com/pineapple/product/service/test/sql/drop-database.sql",
            "/com/pineapple/product/service/test/sql/create-database.sql"
    })
    @Sql(
            "/com/pineapple/product/service/test/sql/products.sql"
    )
    void givenARequestToFindAProductByItsIdAndIfDoesNotExistsShouldReturn404AndFuck0ff() throws Exception {
        getMockMvc()
            .perform(get("/products/4"))
            .andExpect(status().is4xxClientError());
    }
}

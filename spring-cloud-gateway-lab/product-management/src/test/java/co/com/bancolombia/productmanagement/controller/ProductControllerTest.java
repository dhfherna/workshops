package co.com.bancolombia.productmanagement.controller;

import co.com.bancolombia.productmanagement.dto.ProductDTO;
import co.com.bancolombia.productmanagement.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService prodService;

    private List<ProductDTO> dummyList;

    @BeforeEach
    void setUp() {
        dummyList = new ArrayList<>();
        dummyList.add(ProductDTO.builder()
                .id(1).name("carne").build());
        dummyList.add(ProductDTO.builder()
                .id(2).name("leche").build());
    }

    @Test
    void testListProducts_ok() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products/list").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void testGetProductById_ok() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products/get/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void testCreateProduct_ok() throws Exception {
        String testReq = "{\"name\": \"Carne\",\"description\": \"Carne de Cerdo\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/products/create")
                .accept(MediaType.APPLICATION_JSON)
                .content(testReq)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(200, result.getResponse().getStatus());
    }
}
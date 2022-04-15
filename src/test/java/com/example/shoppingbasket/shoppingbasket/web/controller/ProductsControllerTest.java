package com.example.shoppingbasket.shoppingbasket.web.controller;

import com.example.shoppingbasket.shoppingbasket.model.Product;
import com.example.shoppingbasket.shoppingbasket.web.controller.ProductsController;
import com.example.shoppingbasket.shoppingbasket.repository.ProductRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductsController.class)
@ExtendWith(MockitoExtension.class)
class ProductsControllerTest {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllProducts_OneProduct() throws Exception {
        when(productRepository.findAll()).thenReturn(List.of(new Product(1, "test", BigDecimal.ONE, 0.5f)));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/products")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andReturn();

        List<Product> products = getProductsFromResponse(result);

        assertEquals(1, products.size());
    }

    @Test
    void getAllProducts_noProducts() throws Exception {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/products")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andReturn();

        List<Product> products = getProductsFromResponse(result);

        assertEquals(0, products.size());
    }

    private List<Product> getProductsFromResponse(MvcResult result) throws com.fasterxml.jackson.core.JsonProcessingException, UnsupportedEncodingException {
        return objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Product>>() {
        });
    }
}
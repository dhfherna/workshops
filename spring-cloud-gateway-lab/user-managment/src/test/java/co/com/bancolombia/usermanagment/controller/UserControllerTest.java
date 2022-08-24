package co.com.bancolombia.usermanagment.controller;

import co.com.bancolombia.usermanagment.dto.UserDTO;
import co.com.bancolombia.usermanagment.service.UserService;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userServiceMock;

    private List<UserDTO> dummyList;

    @BeforeEach
    void setUp() {
        dummyList = new ArrayList<>();
        dummyList.add(UserDTO.builder()
                .id(1).name("Fernando").lastName("Hernandez").user("nerfo").pass("Clave123*").build());
        dummyList.add(UserDTO.builder()
                .id(2).name("Laura").lastName("Mahecha").user("stepha").pass("Clave123*").build());
    }

    @Test
    void testConsultUserByCredentials() throws Exception {
        String testReq = "{\"user\": \"nerfo\",\"pass\": \"Clave123*\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/user/login")
                .accept(MediaType.APPLICATION_JSON)
                .content(testReq)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void testConsultUserByCredentials_error() throws Exception {
        String testReq = "{\"user\": \"nerfo\",\"pass\": \"ClaveError*\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/user/login")
                .accept(MediaType.APPLICATION_JSON)
                .content(testReq)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(200, result.getResponse().getStatus());
    }
}
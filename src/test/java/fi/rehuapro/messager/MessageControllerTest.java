package fi.rehuapro.messager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MessageControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Successful creation should have a status of created")
    void test_createMessageStatusSuccess() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/message")
                        .content(asJsonString(new Message(null, "My penguin")))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Successful creation should return a message with an ID")
    void test_createMessageWithID() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                        .post("/message")
                        .content(asJsonString(new Message(null, "My penguin")))
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertEquals(36, content.length(), "Id not equal in length");

    }

    public String asJsonString(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
package com.zazergel.bracketchecker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zazergel.bracketchecker.model.BracketsRequest;
import com.zazergel.bracketchecker.service.BracketCheckerService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BracketCheckerController.class)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class BracketCheckerControllerTest {
    private final ObjectMapper mapper;
    private final MockMvc mvc;

    @MockBean
    private BracketCheckerService bracketCheckerService;

    private final BracketsRequest request = new BracketsRequest();
    private final BracketsRequest request2 = new BracketsRequest();
    private final BracketsRequest request3 = new BracketsRequest();

    @BeforeEach
    public void beforeEach() {
        request.setText("Обычный текст (с корректно расставленными) скобками.");
        request2.setText("o".repeat(600));
        request3.setText("");
    }


    @Test
    void shouldCheck() throws Exception {
        mvc.perform(post("/api/checkBrackets")
                        .content(mapper.writeValueAsString(request))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(bracketCheckerService, times(1)).checkBrackets(ArgumentMatchers.any(String.class));
    }

    @Test
    void shouldNotCheckWithoutText() throws Exception {
        mvc.perform(post("/api/checkBrackets")
                        .content(mapper.writeValueAsString(request3))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        verify(bracketCheckerService, never()).checkBrackets(any());
    }

    @Test
    void shouldNotCheckWithOversizeText() throws Exception {
        mvc.perform(post("/api/checkBrackets")
                        .content(mapper.writeValueAsString(request2))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        verify(bracketCheckerService, never()).checkBrackets(any());
    }
}

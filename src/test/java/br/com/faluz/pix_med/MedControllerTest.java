package br.com.faluz.pix_med;

import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.faluz.pix_med.adapter.in.web.dto.MedRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class MedControllerTest {

    @Autowired
    private WebApplicationContext context;

    // Instanciamos manualmente para evitar erro de bean não encontrado
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void deveCriarRequisicaoMedComSucesso() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        MedRequestDto requestDto = new MedRequestDto();
        requestDto.setTransactionId("tx-test-999");
        requestDto.setAmount(new BigDecimal("250.50"));

        mockMvc.perform(post("/api/v1/med")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionId").value("tx-test-999"));
    }
}
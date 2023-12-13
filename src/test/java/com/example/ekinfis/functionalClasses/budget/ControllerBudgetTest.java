package com.example.ekinfis.functionalClasses.budget;

import com.example.ekinfis.functionalClasses.budget.dto.AddBudget;
import com.example.ekinfis.functionalClasses.budget.dto.UpdateBudget;
import com.example.ekinfis.functionalClasses.user.dto.AddUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerBudgetTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ObjectMapper objectMapper;
    private String token;

    @Test
    public void testCRUD() throws Exception {
        token = init();
        Integer id = addBudget();
        updateBudget(id);
        deleteBudget(id);
    }

    public String init() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/api/users/authorization")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(objectMapper.writeValueAsString(new AddUser("mark", "mark",";%;%АЦfaxvzvzafasfУ*):_vszvz№);?:r2vav3r2)_№;):twesdvs?;*№vzvzx№%_rthr*;2131243475ertrп:*:*qrrth*7erte_;*;:we123;:)*"))))
                .andExpect(status().isOk())
                .andReturn();

        return mvcResult.getResponse().getContentAsString();
    }

    public Integer addBudget() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/api/budgets")
                        .header(AUTHORIZATION, token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(objectMapper.writeValueAsString(new AddBudget("Three hundred bucks", 123.45F, 1))))
                .andExpect(status().isOk())
                .andReturn();

        return objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Integer.class);
    }

    public String getBudgets() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/budgets")
                        .header(AUTHORIZATION, token))

                .andExpect(status().isOk())
                .andReturn();

        return mvcResult.getResponse().getContentAsString();
    }

    public String updateBudget(Integer id) throws Exception {
        MvcResult mvcResult = mockMvc.perform(put("/api/budgets")
                        .header(AUTHORIZATION, token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(objectMapper.writeValueAsString(new UpdateBudget(id, "Threeee hundred bucks", 126.45F, 1))))
                .andExpect(status().isOk())
                .andReturn();

        return mvcResult.getResponse().getContentAsString();
    }

    public String deleteBudget(Integer id) throws Exception {
        MvcResult mvcResult = mockMvc.perform(delete("/api/budgets/{id}", id)
                        .header(AUTHORIZATION, token)
                        .characterEncoding("UTF-8"))

                .andExpect(status().isOk())
                .andReturn();

        return mvcResult.getResponse().getContentAsString();
    }
}
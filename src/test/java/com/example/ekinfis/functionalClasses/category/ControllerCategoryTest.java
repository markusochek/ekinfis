package com.example.ekinfis.functionalClasses.category;

import com.example.ekinfis.functionalClasses.category.dto.AddCategory;
import com.example.ekinfis.functionalClasses.category.dto.UpdateCategory;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerCategoryTest {
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
        Integer id = addCategory();
        updateCategory(id);
        deleteCategory(id);
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

    public Integer addCategory() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/api/categories")
                        .header(AUTHORIZATION, token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(objectMapper.writeValueAsString(new AddCategory(null, "food"))))
                .andExpect(status().isOk())
                .andReturn();

        return objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Integer.class);
    }

    public String getCategories() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/categories")
                        .header(AUTHORIZATION, token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        return mvcResult.getResponse().getContentAsString();
    }

    public String updateCategory(Integer id) throws Exception  {
        MvcResult mvcResult = mockMvc.perform(put("/api/categories")
                        .header(AUTHORIZATION, token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(objectMapper.writeValueAsString(new UpdateCategory(id, "food2"))))
                .andExpect(status().isOk())
                .andReturn();

        return mvcResult.getResponse().getContentAsString();
    }

    public String deleteCategory(Integer id) throws Exception  {
        MvcResult mvcResult = mockMvc.perform(delete("/api/categories/{id}", id)
                        .header(AUTHORIZATION, token)
                        .characterEncoding("UTF-8"))

                .andExpect(status().isOk())
                .andReturn();

        return mvcResult.getResponse().getContentAsString();
    }
}
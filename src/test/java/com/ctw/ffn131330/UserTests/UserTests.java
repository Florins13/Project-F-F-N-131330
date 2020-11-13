package com.ctw.ffn131330.UserTests;

import com.ctw.ffn131330.user.User;
import com.ctw.ffn131330.user.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserController userController;

    private UserTestsUtils userUtils = new UserTestsUtils();

    // write test cases here
    @Test
    public void saveUser(){
        assertThat(userController).isNotNull();
    }

    @Test
    public void itShouldSaveUser () {
        assertThat(this.userController.saveUser(userUtils.mockUser())).isInstanceOf(User.class);
    }

    @Test
    public void itShouldReturnUserId(){
        assertThat(this.userController.getUserById(1L).getId()).isEqualTo(1);
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome to Side project!")));
    }

}

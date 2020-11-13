package com.ctw.ffn131330.UserTests;

import com.ctw.ffn131330.user.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    public void itShouldReturnUserId(){
        this.userController.saveUser(userUtils.mockUser());
        assertThat(this.userController.getUserById(2L).getId()).isEqualTo(2);
    }

    @Test
    public void itShouldGetUserName(){
        this.userController.saveUser(userUtils.mockUser());
        assertThat(this.userController.getUserById(2L).getName()).isEqualTo("userone");
    }

    @Test
    public void itShouldDeleteOneUser(){
        this.userController.saveUser(userUtils.mockUser());
        this.userController.deleteUserById(1L);
        assertThat(this.userController.getAllUsers()).isEqualTo(new ArrayList<>());
    }

    /*  Useful approach is to not start the server at all but to test only the layer below that,
        where Spring handles the incoming HTTP request and hands it off to your controller.
        That way, almost of the full stack is used, and your code will be called in exactly the
        same way as if it were processing a real HTTP request but without the cost of starting the server.
        To do that, use Spring’s MockMvc and ask for that to be injected for you by using the
        @AutoConfigureMockMvc annotation on the test case. */

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome to Side project!")));
    }

    @Test
    public void shouldReturnEmptyList() throws Exception {
        this.mockMvc.perform(get("/getAllUsers")).andExpect(status().isOk()).andExpect(content().json("[]"));
    }


    @Test
    public void shouldAddUserByJson() throws Exception{
        this.mockMvc.perform(post("/saveUser").contentType(MediaType.APPLICATION_JSON)
                .content(userUtils.json)).andExpect(status().isOk()).andExpect(content().json(userUtils.json));
    }

}

package com.github.jakubborkowski.jpa.service;

import com.github.jakubborkowski.jpa.model.User;
import com.github.jakubborkowski.jpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void addNewUser() {
        //Given//
        User user = userService.addNewUser("test", "test",
                "test", "test", "test");
        //Then//
        assertNotNull(user);
    }

    @Test
    void findById() {
        //Given//
        User user = new User(1L, "test", "test", "test",
                "test", "test", new ArrayList<>(), new ArrayList<>());
        //When//
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));//define return value
        //Then//
        assertEquals(user, userService.findById(1L));
    }

    @Test
    void removeUser() {
        //Given//
        User user = new User(1L, "test", "test", "test",
                "test", "test", new ArrayList<>(), new ArrayList<>());
        //When//
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));//define return value
        //Then//
        assertTrue(userService.removeUser(1L));
    }

    @Test
    void editUser() {
        //Given//
        User oldUser = new User(1L, "test", "test", "test",
                "test", "test", new ArrayList<>(), new ArrayList<>());
        User newUser = new User(2L, "test", "test", "test",
                "test", "test", new ArrayList<>(), new ArrayList<>());
        //When//
        when(userRepository.findById(1L)).thenReturn(Optional.of(oldUser));//define return value
        //Then//
        assertNotNull(userService.editUser(newUser, 1L));
    }
}
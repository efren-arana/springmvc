package com.earana.mvc.springmvc.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.earana.mvc.springmvc.models.User;
import com.earana.mvc.springmvc.models.dto.ParamDto;
import com.earana.mvc.springmvc.models.dto.UserDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    
    List<UserDto> users = new ArrayList<>();

    @GetMapping(path = "/get")
    public UserDto getUser(@RequestParam(required = false,defaultValue = "Titulo por defecto",name = "titulo") String title, @RequestParam Short age) {
        UserDto userDto = new UserDto();
        userDto.setTitle(title);
        userDto.setUser(new User("Erick", "Earana", "XXXXXXXXXXXXXXXX", (short) age));
        return userDto;
    }

    @GetMapping(path = "/request")
    public ParamDto request(HttpServletRequest request){
        Integer code = 10;

        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {

        }

        ParamDto param = new ParamDto();
        param.setMessage(request.getParameter("message"));
        param.setNumber(code);

        return param;
    }

    @GetMapping(path = "path/{id}/{name}/{email}")
    public UserDto getUserByIdAndName(@PathVariable Long id, 
                                      @PathVariable String name, 
                                      @PathVariable String email) {
        UserDto userDto = new UserDto();
        userDto.setTitle("User " + id);
        userDto.setUser(new User(name, "LastName", email));
        return userDto;
    }

    @GetMapping(path = "/createUsers")
    public List<UserDto> getUsers() {
        
        UserDto user1 = new UserDto();
        user1.setTitle("User 1");
        user1.setUser(new User("John", "Doe", "XXXXXXXXXXXXXXXX"));
        
        UserDto user2 = new UserDto();
        user2.setTitle("User 2"); 
        user2.setUser(new User("Jane", "Smith", "XXXXXXXXXXXXXXXX"));
        
        UserDto user3 = new UserDto();
        user3.setTitle("User 3");
        user3.setUser(new User("Bob", "Johnson", "XXXXXXXXXXXXXXXX"));
        
        UserDto user4 = new UserDto();
        user4.setTitle("User 3");
        user4.setUser(new User("Bob", "Johnson", "XXXXXXXXXXXXXXXX"));
        
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        
        return users;
    }

    @GetMapping(path = "/search")
    public List<UserDto> searchUsersByName(@RequestParam String name) {
        // Filter users list by matching name (case-insensitive)
        return users.stream()
                .filter(userDto -> userDto.getUser().getName().toLowerCase()
                        .contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @GetMapping("/mapa")
    public Map<String,Object> mapa(){
        Map<String,Object> mapa = new HashMap<>();

        User user = new User("Efren", "Arana", "earana@hotmail.com");

        mapa.put("user", user);

        return mapa;
    }

    
}

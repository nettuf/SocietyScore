package com.societyscore.authservice.Controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.societyscore.authservice.Model.InputDTO.UserInputDTO;
import com.societyscore.authservice.Model.OutputDTO.UserOutputDTO;
import com.societyscore.authservice.Service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService service;
    
    public UserController(UserService service) {
		super();
		this.service = service;
	}

	@PostMapping("register")
    public UserOutputDTO register(@RequestBody @Validated UserInputDTO request) {
        return service.register(request);
    }
}
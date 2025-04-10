package com.societyscore.authservice.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.societyscore.authservice.Model.InputDTO.AuthRequestDTO;
import com.societyscore.authservice.Model.OutputDTO.TokenDTO;
import com.societyscore.authservice.Service.AuthService;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService service;
    
    public AuthController(AuthService service) {
		super();
		this.service = service;
	}

	@PostMapping("login")
    public TokenDTO login(@RequestBody AuthRequestDTO request) {
        return service.login(request);
    }

    @PostMapping("token/validate")
    public TokenDTO validateToken(@RequestHeader String accessToken) {
        return service.validateToken(accessToken);
    }
}
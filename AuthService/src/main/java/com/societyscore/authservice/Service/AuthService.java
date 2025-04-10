package com.societyscore.authservice.Service;

import static org.springframework.util.ObjectUtils.isEmpty;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.societyscore.authservice.Model.InputDTO.AuthRequestDTO;
import com.societyscore.authservice.Model.OutputDTO.TokenDTO;
import com.societyscore.authservice.Repository.UserRepository;
import com.societyscore.authservice.Service.Exceptions.ValidationException;

@Service
public class AuthService {

	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;;
	private final JwtService jwtService;

	public AuthService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}

	public TokenDTO login(AuthRequestDTO request) {
		var user = repository.findByUsername(request.username())
				.orElseThrow(() -> new ValidationException("User not found!"));
		validatePassword(request.password(), user.getPassword());
		var accessToken = jwtService.createToken(user);
		return new TokenDTO(accessToken);
	}

	private void validatePassword(String rawPassword, String encodedPassword) {
		if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
			throw new ValidationException("The password is incorrect!");
		}
	}

	public TokenDTO validateToken(String accessToken) {
		validateExistingToken(accessToken);
		jwtService.validateAccessToken(accessToken);
		return new TokenDTO(accessToken);
	}

	private void validateExistingToken(String accessToken) {
		if (isEmpty(accessToken)) {
			throw new ValidationException("The access token must be informed!");
		}
	}
}
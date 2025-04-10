package com.societyscore.authservice.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.societyscore.authservice.Model.Entities.User;
import com.societyscore.authservice.Model.InputDTO.UserInputDTO;
import com.societyscore.authservice.Model.Mapper.UserMapper;
import com.societyscore.authservice.Model.OutputDTO.UserOutputDTO;
import com.societyscore.authservice.Repository.UserRepository;
import com.societyscore.authservice.Util.Enums.StatusEnum;
import com.societyscore.authservice.Util.Enums.TypeEnum;

@Service
public class UserService {
	
	private final UserRepository repository;
    private final UserMapper userMapper;
    
	public UserService(UserRepository repository, UserMapper userMapper) {
		this.repository = repository;
		this.userMapper = userMapper;
	}

	public UserOutputDTO register(UserInputDTO input) {
        this.existsByUsername(input.getUsername());
        this.existsByEmail(input.getEmail());
        this.existByCpf(input.getCpf());
        this.verifyPassword(input.getPassword());
        
        User user = userMapper.toEntity(input);
        
        String hashedPassword = new BCryptPasswordEncoder().encode(input.getPassword());
        
        user.setPassword(hashedPassword);
        user.setStatus(StatusEnum.INACTIVE); 
        user.setType(TypeEnum.NORMAL); 

        User savedUser = repository.save(user);
        return userMapper.toOutputDTO(savedUser);
    }

	private void existsByUsername(String username) {
		if (repository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username já está em uso.");
        }
	}
	
	private void existsByEmail(String email) {
		if (repository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email já está em uso.");
        }
	}
	
	private void existByCpf(String cpf) {
		if (repository.existsByCpf(cpf)) {
            throw new IllegalArgumentException("Cpf já está em uso.");
        }
	}
	
	private void verifyPassword(String password) {
		if (password == null || password.length() < 8) {
	        throw new IllegalArgumentException("A senha deve conter no mínimo 8 caracteres.");
	    }
	}
	
	
	
}
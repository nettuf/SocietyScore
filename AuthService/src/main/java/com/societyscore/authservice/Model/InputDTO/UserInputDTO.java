package com.societyscore.authservice.Model.InputDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserInputDTO {
	
	private UUID id;
	private String username;
	private String password;
	private String name;
	private String cpf;
	private String email;
	private LocalDate birthdate;
	private LocalDateTime dateInsert;
	
	public LocalDateTime getDateInsert() {
		return dateInsert;
	}

	public UserInputDTO() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	

}

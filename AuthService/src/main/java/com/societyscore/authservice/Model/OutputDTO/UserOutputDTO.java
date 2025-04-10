package com.societyscore.authservice.Model.OutputDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserOutputDTO {
	
	private UUID id;
	private String username;
	private String name;
	private String cpf;
	private String email;
	private LocalDate birthdate;
	private LocalDateTime dateInsert;
	
	public UserOutputDTO() {
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

	public LocalDateTime getDateInsert() {
		return dateInsert;
	}

}

package com.societyscore.authservice.Model.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.societyscore.authservice.Util.Enums.StatusEnum;
import com.societyscore.authservice.Util.Enums.TypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false, unique = true, length = 50)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, unique = true, length = 14)
	private String cpf;

	@Column(nullable = false, unique = true, length = 100)
	private String email;

	@Column(nullable = false)
	private StatusEnum status;
	
	@Column(nullable = false)
	private TypeEnum type;

	@Column(nullable = false)
	private LocalDate birthdate;
	
	@CreationTimestamp // Hibernate irá gerar o valor automaticamente
    @Column(nullable = false, updatable = false) // Não pode ser atualizado
    private LocalDateTime dateInsert;

	public User() {
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

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
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

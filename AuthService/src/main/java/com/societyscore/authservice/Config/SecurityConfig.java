package com.societyscore.authservice.Config;

import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Value("${app.token.secret-key}")
	private String secretKey;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/public/**").permitAll().requestMatchers("/admin/**")
				.hasRole("ADMIN").requestMatchers("/user/**").hasRole("USER").anyRequest().authenticated())
				.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults())); // JWT com chave secreta

		return http.build();
	}

	@Bean
	JwtDecoder jwtDecoder() {
		byte[] secretBytes = Base64.getDecoder().decode(secretKey);
		SecretKeySpec key = new SecretKeySpec(secretBytes, "HmacSHA256");
		return NimbusJwtDecoder.withSecretKey(key).build();
	}
}
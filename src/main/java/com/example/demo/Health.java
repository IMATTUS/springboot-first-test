package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health") // quando chegar uma requisição para o /health vai cair aqui
public class Health {
	
	@GetMapping // quando chegar uma requisição com o HTTP GET
	public String listar() {
		return "OK"; 
	}
	
}

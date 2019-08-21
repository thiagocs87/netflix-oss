package br.com.client.service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.client.service.State;
import lombok.Data;

@Data
public class ClientDto {
	
	@NotBlank(message = "The field name must not be null")
	@Size(min = 3, max = 50, message = "The field name must be between 3 and 50 characters")
    private String name;
	
	@NotBlank(message = "The field surename must not be null")
	@Size(min = 3, max = 50, message = "The field slug must be between 3 and 50 characters")
    private String surename;
	
	@NotBlank(message = "The field city must not be null")
	@Size(min = 3, max = 50, message = "The field city must be between 3 and 50 characters")
    private String city;
    
    private State state;

}

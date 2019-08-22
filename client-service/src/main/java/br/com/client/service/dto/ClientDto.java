package br.com.client.service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientDto {
	
	@NotBlank(message = "The field name must not be null")
	@Size(min = 3, max = 50, message = "The field name must be between 3 and 50 characters")
    private String name;
	
	@NotBlank(message = "The field surename must not be null")
	@Size(min = 3, max = 50, message = "The field slug must be between 3 and 50 characters")
    private String surename;
	
	@NotBlank(message = "The field postal code must not be null")
	@Size(min = 8, max = 8, message = "The field postal code must have 7 characters")
    private String postalCode;
}
package br.com.client.persistence.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

	private String postalCode;
	private String streetName; 
	private String complement;
	private String district;
	private String city;
	private String state;

}

package br.com.client.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_client")
@NoArgsConstructor
public class Client {

	public Client(String name, String surename, String city, String state) {
		this.name = name;
		this.surename = surename;
		this.city = city;
		this.state = state;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private String name;
	
    private String surename;
	
    private String city;
    
    private String state;
	
    @CreationTimestamp
    private LocalDateTime createdAt;
	
    @UpdateTimestamp
    private LocalDateTime updatedAt;
	
	
}

package br.com.client.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.client.persistence.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	List<Client> findByNameContaining(String name);
	Optional<Client> findById(Long id);	
	
}

package br.com.client.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.client.api.event.ResourceCreatedEvent;
import br.com.client.persistence.entity.Client;
import br.com.client.service.ClientService;
import br.com.client.service.dto.ClientDto;


@RestController
@Api(value = "Client operations")
public class ClientResource {

	@Autowired
	private ApplicationEventPublisher publisher;
		
	@Autowired
	private ClientService service;
	
    @ApiOperation(value = "Get all the existing clients")
    @GetMapping(value = "/client", produces = "application/json")
    public ResponseEntity<?> getClientAll() {
        return ResponseEntity.ok(service.list());
    }
    
    @ApiOperation(value = "Get a specific client by ID")
    @GetMapping(value = "/client/{id}", produces = "application/json")
    public ResponseEntity<?> getClientById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.get(id));
    }
    
    @ApiOperation(value = "Get a specific client by Name")
    @GetMapping(value = "/client/name/{name}", produces = "application/json")
    public ResponseEntity<?> getClientByName(@PathVariable("name") String name) {
    	return ResponseEntity.ok(service.list(name));
    }

    @ApiOperation(value = "Save a client")
    @PostMapping(value = "/client", produces = "application/json")
    public ResponseEntity<?> postClient(@Valid @RequestBody ClientDto place, HttpServletResponse response, HttpServletRequest request) {
        Client savedClient = service.save(place);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, savedClient.getClientId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @ApiOperation(value = "Update a client")
    @PutMapping(value = "/client/{id}", produces = "application/json")
    public ResponseEntity<?> putClient(@Valid @RequestBody ClientDto place, @PathVariable("id") Long id, HttpServletResponse response, HttpServletRequest request) {
    	Client savedClient = service.update(place, id);
        return ResponseEntity.ok(savedClient);
    }
    
    @ApiOperation(value = "Delete a specific client by ID")
    @DeleteMapping(value = "/client/{id}", produces = "application/json")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id) {
		service.delete(id);
    	return ResponseEntity.ok().build();
    }
}
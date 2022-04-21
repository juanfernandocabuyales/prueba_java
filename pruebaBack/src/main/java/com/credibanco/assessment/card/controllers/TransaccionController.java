package com.credibanco.assessment.card.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.card.dto.PeticionAnularTransaccion;
import com.credibanco.assessment.card.dto.PeticionCrearTransaccion;
import com.credibanco.assessment.card.dto.RespuestaAnularTransaccion;
import com.credibanco.assessment.card.dto.RespuestaCrearTransaccion;
import com.credibanco.assessment.card.service.ITransaccionService;

@RestController
@RequestMapping("/api/transaccion")
public class TransaccionController {

	@Autowired
	private ITransaccionService transaccionService;
	
	@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping(value = "/crearTransaccion")
    public ResponseEntity<Object> crearTransaccion(@RequestBody PeticionCrearTransaccion peticionCrearTransaccion) {
		RespuestaCrearTransaccion respuestaCrearTransaccion = transaccionService.crearTransaccion(peticionCrearTransaccion);
        return ResponseEntity.ok().body(respuestaCrearTransaccion);
    }
	
	@CrossOrigin(origins = "*", methods = {RequestMethod.PUT})
    @PutMapping(value = "/anularTransaccion")
    public ResponseEntity<Object> anularTransaccion(@RequestBody PeticionAnularTransaccion peticionAnularTransaccion) {
		RespuestaAnularTransaccion respuestaAnularTransaccion = transaccionService.anularTransaccion(peticionAnularTransaccion);
        return ResponseEntity.ok().body(respuestaAnularTransaccion);
    }
}

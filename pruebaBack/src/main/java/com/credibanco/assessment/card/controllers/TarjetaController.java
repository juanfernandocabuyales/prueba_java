package com.credibanco.assessment.card.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.card.dto.PeticionCrearTarjeta;
import com.credibanco.assessment.card.dto.PeticionEliminarTarjeta;
import com.credibanco.assessment.card.dto.PeticionEnrolarTarjeta;
import com.credibanco.assessment.card.dto.RespuestaConsultarTarjeta;
import com.credibanco.assessment.card.dto.RespuestaConsultarTarjetas;
import com.credibanco.assessment.card.dto.RespuestaCrearTarjeta;
import com.credibanco.assessment.card.dto.RespuestaEliminarTarjeta;
import com.credibanco.assessment.card.dto.RespuestaEnrolarTarjeta;
import com.credibanco.assessment.card.service.ITarjetaService;
import com.credibanco.assessment.card.utils.Constantes;

@RestController
@RequestMapping("/api/tarjeta")
public class TarjetaController {

	@Autowired
	private ITarjetaService tarjetaService;
	
	@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping(value = "/crearTarjeta")
    public ResponseEntity<Object> crearTarjeta(@RequestBody PeticionCrearTarjeta peticionCrearTarjeta) {
		RespuestaCrearTarjeta respuestaCrearTarjeta = tarjetaService.crearTarjeta(peticionCrearTarjeta);
        return ResponseEntity.ok().body(respuestaCrearTarjeta);
    }
	
	@CrossOrigin(origins = "*", methods = {RequestMethod.PUT})
    @PutMapping(value = "/enrolarTarjeta")
    public ResponseEntity<Object> enrolarTarjeta(@RequestBody PeticionEnrolarTarjeta peticionEnrolarTarjeta) {
		RespuestaEnrolarTarjeta respuestaEnrolarTarjeta = tarjetaService.enrolarTarjeta(peticionEnrolarTarjeta);
        return ResponseEntity.ok().body(respuestaEnrolarTarjeta);
    }
	
	@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    @GetMapping(value = "/consultarTarjeta/{id}")
    public ResponseEntity<Object> consultarTarjeta(@PathVariable Long id) {
		RespuestaConsultarTarjeta respuestaConsultarTarjeta = tarjetaService.consultarTarjeta(id);
		if(respuestaConsultarTarjeta.getCodigoRespuesta().equalsIgnoreCase(Constantes.CODIGO_RESPUESTA_UNO)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
        return ResponseEntity.ok().body(respuestaConsultarTarjeta);
    }
	
	@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    @GetMapping(value = "/consultarTarjetas")
    public ResponseEntity<Object> consultarTarjetas() {
		RespuestaConsultarTarjetas respuestaConsultarTarjetas = tarjetaService.consultarTarjetas();
		return ResponseEntity.ok().body(respuestaConsultarTarjetas);
    }
	
	@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE})
    @DeleteMapping(value = "/eliminarTarjeta")
    public ResponseEntity<Object> eliminarTarjeta(@RequestBody PeticionEliminarTarjeta peticionEliminarTarjeta) {
		RespuestaEliminarTarjeta respuestaEliminarTarjeta = tarjetaService.eliminarTarjeta(peticionEliminarTarjeta);
		return ResponseEntity.ok().body(respuestaEliminarTarjeta);
    }
}

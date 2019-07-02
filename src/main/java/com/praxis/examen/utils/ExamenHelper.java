package com.praxis.examen.utils;

import com.praxis.examen.domain.ResponseDTO;
import com.praxis.examen.entity.ResponseEntity;

public class ExamenHelper {
	
	
	public static ResponseDTO toDTO(ResponseEntity responseEntity) {
		
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setEdad(|responseEntity.getEdad());
		responseDTO.setNombre(responseEntity.getNombre());
		responseDTO.setPrimerApellido(responseEntity.getPrimerApellido());
		responseDTO.setSegundoApellido(responseEntity.getSegundoApellido());
		
		return responseDTO;
		
	}

}

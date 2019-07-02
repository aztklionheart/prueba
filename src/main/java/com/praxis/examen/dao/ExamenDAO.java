package com.praxis.examen.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.praxis.examen.entity.ResponseEntity;

@Service
public class ExamenDAO {
	
	public List<ResponseEntity> getAll() {
		
		List<ResponseEntity> lstResponseEntity = new ArrayList();
		
		ResponseEntity responseEntity  = new ResponseEntity();
		responseEntity.setEdad(30);
		responseEntity.setNombre("Mario");
		responseEntity.setPrimerApellido("Perez");
		responseEntity.setSegundoApellido("Juarez");
		
		ResponseEntity responseEntity2  = new ResponseEntity();
		responseEntity2.setEdad(28);
		responseEntity2.setNombre("Jose");
		responseEntity2.setPrimerApellido("Figueroa");
		responseEntity2.setSegundoApellido("Martinez");
		
		ResponseEntity responseEntity3  = new ResponseEntity();
		responseEntity3.setEdad(35);
		responseEntity3.setNombre("Luis");
		responseEntity3.setPrimerApellido("Suarez");
		responseEntity3.setSegundoApellido("Hernandez");
		
		ResponseEntity responseEntity4  = new ResponseEntity();
		responseEntity4.setEdad(32);
		responseEntity4.setNombre("Alma");
		responseEntity4.setPrimerApellido("Zamora");
		responseEntity4.setSegundoApellido("Fernandez");
		
		lstResponseEntity.add(responseEntity);
		lstResponseEntity.add(responseEntity2);
		lstResponseEntity.add(responseEntity3);
		lstResponseEntity.add(responseEntity4);
		
		
		return lstResponseEntity;
	}

}

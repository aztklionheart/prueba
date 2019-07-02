package com.praxis.examen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praxis.examen.dao.ExamenDAO;
import com.praxis.examen.domain.RequestDTO;
import com.praxis.examen.domain.ResponseDTO;
import com.praxis.examen.entity.ResponseEntity;
import com.praxis.examen.errorhandling.DataNotFoundException;
import com.praxis.examen.utils.ExamenHelper;

@Service
public class ExamenService {

	@Autowired
	ExamenDAO examenDAO;
	
	public List<ResponseDTO> getAll() {

		List<ResponseEntity> lstResponseEntity = examenDAO.getAll();

		return lstResponseEntity.stream()
								.map(ExamenHelper::toDTO)
								.collect(Collectors.toList());

	}

	public List<ResponseDTO> getFilter(RequestDTO requestDTO) {

		List<ResponseEntity> lstResponseEntity = examenDAO.getAll();

		List<ResponseDTO> lstResponseDTO =  lstResponseEntity.stream()
				.filter(elemento -> elemento.getNombre().equals(requestDTO.getNombre())
						&& elemento.getPrimerApellido().equals(requestDTO.getPrimerApellido()))
				.map(ExamenHelper::toDTO)
				.collect(Collectors.toList());
		
		if(lstResponseDTO.isEmpty()) {
			throw new DataNotFoundException("Sin resultados encontrados");
		}
		return lstResponseDTO;
	}

}

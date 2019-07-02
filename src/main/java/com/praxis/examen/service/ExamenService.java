package com.praxis.examen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.praxis.examen.domain.RequestDTO;
import com.praxis.examen.domain.ResponseDTO;
import com.praxis.examen.entity.ResponseEntity;
import com.praxis.examen.utils.ExamenHelper;

public class ExamenService {

	public List<ResponseDTO> getAll() {

		List<ResponseEntity> lstResponseEntity = new ArrayList();

		return lstResponseEntity.stream()
								.map(ExamenHelper::toDTO)
								.collect(Collectors.toList());

	}

	public List<ResponseDTO> getFilter(RequestDTO requestDTO) {

		List<ResponseEntity> lstResponseEntity = new ArrayList();

		return lstResponseEntity.stream()
				.filter(elemento -> elemento.getNombre().equals(requestDTO.getNombre())
						&& elemento.getPrimerApellido().equals(requestDTO.getPrimerApellido()))
				.map(ExamenHelper::toDTO)
				.collect(Collectors.toList());

	}

}

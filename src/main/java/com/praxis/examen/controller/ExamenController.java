package com.praxis.examen.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.praxis.examen.domain.RequestDTO;
import com.praxis.examen.domain.ResponseDTO;
import com.praxis.examen.service.ExamenService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("examen")
@Api(value = "examen", consumes="application/json", tags="Examen")
public class ExamenController {
	
	@Autowired
	ExamenService examenService;

	 @ApiOperation(value = "getAll", produces="application/json")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "OK", response = ResponseDTO.class),
	            @ApiResponse(code = 400, message = "Bad Request"),
	            @ApiResponse(code = 500, message = "Internal server error")
	    })
	    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
	    public Object getAll() throws Exception {


	        return examenService.getAll();
	    }
	
	 @ApiOperation(value = "getFilter", produces="application/json")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "OK", response = ResponseDTO.class),
	            @ApiResponse(code = 400, message = "Bad Request"),
	            @ApiResponse(code = 500, message = "Internal server error")
	    })
	    @RequestMapping(value = "/getFilter", method = RequestMethod.POST)
	    public Object getFilter(@RequestBody @Valid RequestDTO requestDTO) throws Exception {


	        return examenService.getFilter(requestDTO);
	    }
	 
}

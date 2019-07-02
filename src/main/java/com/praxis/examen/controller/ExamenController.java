package com.praxis.examen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("examen")
@Api(value = "examen", consumes="application/json", tags="Examen")
public class ExamenController {

	 @ApiOperation(value = "getAllTipoPersona", produces="application/json")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "OK", response = Object.class),
	            @ApiResponse(code = 400, message = "Bad Request"),
	            @ApiResponse(code = 500, message = "Internal server error")
	    })
	    @RequestMapping(value = "/getAllTipoPersona", method = RequestMethod.GET)
	    public Object getAllTipoPersona() throws Exception {


	        return "Hola Mundo";
	    }
	
}

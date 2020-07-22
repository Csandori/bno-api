package hu.wirthandras.bno.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.wirthandras.bno.domain.Bno;
import hu.wirthandras.bno.service.ReadService;

@RestController
public class ApiController {

	@Autowired
	private ReadService readService;
	
	@GetMapping(value = "/api/list", produces = { "application/json" })
	public List<Bno> getData(
			@RequestParam(value = "code", required = false) Optional<String> code,
			@RequestParam(value = "name", required = false) Optional<String> name) {
		
			return readService.getBnos()
					.stream()
					.filter(c ->
			(code.isPresent() ? c.KOD10.contains(code.get()) : true) && 
			(name.isPresent() ? c.NEV.contains(name.get()) : true)
			)
					.collect(Collectors.toList());
	}
}

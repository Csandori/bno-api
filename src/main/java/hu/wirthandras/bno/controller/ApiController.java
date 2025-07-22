package hu.wirthandras.bno.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import hu.wirthandras.bno.domain.Bno;
import hu.wirthandras.bno.domain.Gender;
import hu.wirthandras.bno.service.FilterService;
import hu.wirthandras.bno.service.GenderService;

@RestController
@RequestMapping("api/bno")
@CrossOrigin(origins = "*")
public class ApiController {

	@Autowired
	private FilterService filterService;
	
	@Autowired
	private GenderService genderService;
	
	@GetMapping(value = "/list", produces = { "application/json" })
	public List<Bno> getData(
			@RequestParam(value = "code", required = false) Optional<String> code,
			@RequestParam(value = "name", required = false) Optional<String> name,
			@RequestParam(value = "signal", required = false) Optional<String> signal,
			@RequestParam(value = "sex", required = false) Optional<String> sex,
			@RequestParam(value = "general", required = false) Optional<String> general,
			@RequestParam(value = "page", required = false) Optional<Integer> page,
			@RequestParam(value = "limit", required = false) Optional<Integer> limit
			) {
		
			return filterService.filter(code, name, signal, sex, general, page, limit);
	}
	
	@GetMapping(value = "/genders", produces = { "application/json" })
	public List<Gender> getGenders() {
		return genderService.listGenders();
	}
}

package hu.wirthandras.bno.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.wirthandras.bno.domain.Bno;

@Service
public class FilterService {

	@Autowired
	private ReadService readService;

	public List<Bno> filter(
			Optional<String> code,
			Optional<String> name,
			Optional<String> signal,
			Optional<String> sex
			) {
		return readService.getBnos().stream()
				.filter(c -> 
				(code.isPresent() ? c.KOD10.contains(code.get()) : true) &&
				(name.isPresent() ? c.NEV.contains(name.get()) : true) &&
				(signal.isPresent() ? c.JEL.contains(signal.get()) : true) &&
				(sex.isPresent() ? c.NEM.contains(sex.get()) : true)
				).collect(Collectors.toList());
	}
}

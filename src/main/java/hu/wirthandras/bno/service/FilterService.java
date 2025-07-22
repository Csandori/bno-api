package hu.wirthandras.bno.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import java.util.stream.Stream;

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
			Optional<String> sex,
			Optional<String> general,
			Optional<Integer> page, 
			Optional<Integer> limit
			) {
		
		Stream<Bno> base = readService.getBnos().stream()
				.filter(c -> 
				(code.isPresent() ? c.KOD10.toUpperCase().contains(code.get().toUpperCase()) : true) &&
				(name.isPresent() ? c.NEV.toUpperCase().contains(name.get().toUpperCase()) : true) &&
				(signal.isPresent() ? c.JEL.contains(signal.get()) : true) &&
				(sex.isPresent() ? c.NEM.contains(sex.get()) : true) &&
				(general.isPresent() ? (c.KOD10 + " - " + c.NEV).toUpperCase().contains(general.get().toUpperCase()) : true)
				);
		
		long pageNumber = page.orElse(1) - 1;
		long limitNumber = limit.orElse(50);
		if (limitNumber == 0) {
			limitNumber = 50;
		}
		
		return base.skip(pageNumber * limitNumber).limit(limitNumber).collect(Collectors.toList());
	}
}

package hu.wirthandras.bno.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hu.wirthandras.bno.domain.Gender;

@Service
public class GenderService {

	public List<Gender> listGenders() {
		List<Gender> result = new ArrayList<Gender>();
		result.add(new Gender("1", "Férfi"));
		result.add(new Gender("0", "Nő"));
		return result;
	}
			
}

package hu.wirthandras.bno.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.wirthandras.bno.domain.Bno;

@Service
public class ReadService {

	@Autowired
	private BnoCreator bnoCreator;
	
	public List<Bno> getBnos() {
		String fileName = "BNOTORZS_20150101.csv";

		List<Bno> result = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(s -> result.add(bnoCreator.create(s)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}

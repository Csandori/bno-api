package hu.wirthandras.bno.service;

import org.springframework.stereotype.Service;

import hu.wirthandras.bno.domain.Bno;

@Service
public class BnoCreator {

	public Bno create(String line) {
		String[] splitted = line.split("#");
		Bno bno = new Bno();
		bno.KOD10 = splitted[0];
		bno.JEL = splitted[1];
		bno.NEV = splitted[2];
		bno.NEM = splitted[3];
		bno.KOR_A = splitted[4];
		bno.KOR_F = splitted[5];
		bno.ERV_KEZD = splitted[6];
		bno.ERV_VEGE = splitted[7];
		return bno;
	}
}

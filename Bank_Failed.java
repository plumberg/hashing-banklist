package hw_1_hashing;

import java.time.LocalDate;

public class Bank_Failed {
/*	String name;
	String city;
	USState state;
	Integer CERT;
	String acqInst;
	LocalDate closDate;
	LocalDate updDate;

	public Bank_Failed(String name, String city, USState state, Integer cERT, String acqInst, LocalDate closDate,
			LocalDate updDate) {*/
	String name;
	String city;
	USState state;
	String CERT;
	String acqInst;
	String closDate;
	String updDate;


	public Bank_Failed(String name, String city, USState state, String cERT, String acqInst, String closDate,
			String updDate) {

		this.name = name;
		this.city = city;
		this.state = state;
		CERT = cERT;
		this.acqInst = acqInst;
		this.closDate = closDate;
		this.updDate = updDate;
	}

	public USState getState() {
		return state;
	}

	@Override
	public String toString() {
		return name + " " + city + " " + state + " " + CERT + " "
				+ acqInst + " " + closDate + " " + updDate;
	}
	
	

}

package praksa.zadatak.maven.eclipse;

import java.util.Date;

public class Transakcija {
	private Date datum;
	private double iznos;
	private String iban;
	
	public Transakcija(Date datum, double iznos, String iban) {
		this.datum = datum;
		this.iznos = iznos;
		this.iban = iban;
	}
	
	public Date getDatum() {
		return datum;
	}
	
	public double getIznos() {
		return iznos;
	}
	
	public String getIban() {
		return iban;
	}
}

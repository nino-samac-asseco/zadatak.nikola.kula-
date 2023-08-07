package praksa.zadatak.maven.eclipse;


public class Racun {
	private String brojRacuna;
	private double iznos;
	private String valuta;
	
	public Racun(String brojRacuna, double iznos, String valuta) {
		this.brojRacuna = brojRacuna;
		this.iznos = iznos;
		this.valuta = valuta;
	}
	
	public String getBrojRacuna() {
		return brojRacuna;
	}
	
	public double getIznos() {
		return iznos;
	}
	
	public String getValuta() {
		return valuta;
	}
	
	public void smanjiIznos(double svota) {
		iznos -= svota;
	}
}


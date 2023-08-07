package praksa.zadatak.maven.eclipse;

import java.util.Scanner;

import  praksa.zadatak.maven.eclipse.Menu;
import  praksa.zadatak.maven.eclipse.Prijava;
import  praksa.zadatak.maven.eclipse.Racun;
import  praksa.zadatak.maven.eclipse.TransakcijaLista;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean loggedIn = false;
		while (!loggedIn) {
			loggedIn = Prijava.login(scanner);
			if (loggedIn) {
				Racun stanjeRacuna = new Racun("54321", 10000, "EUR");
				TransakcijaLista transakcijaLista = new TransakcijaLista();
				Menu.showMenu(scanner, stanjeRacuna, transakcijaLista);
				
			}
		}
		
		scanner.close();
		
	}
}

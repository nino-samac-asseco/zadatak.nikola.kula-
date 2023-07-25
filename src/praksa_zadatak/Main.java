package praksa_zadatak;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean loggedIn = false;
		while (!loggedIn) {
			loggedIn = Prijava.login(scanner);
			if (loggedIn) {
				Racun stanjeRacuna = new Racun("54321", 10000, "EUR");
				Menu.showMenu(scanner, stanjeRacuna);
				
			}
		}
		
		scanner.close();
		
	}
}
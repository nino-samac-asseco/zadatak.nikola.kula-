package praksa.zadatak.maven.eclipse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
	private static boolean logout = false;
	
	public static void showMenu(Scanner scanner, Racun stanjeRacuna, TransakcijaLista transakcijaLista) {
		while (!logout) {
			System.out.println("Odaberi opciju: ");
			System.out.println("1 - Odjava");
			System.out.println("2 - Stanje racuna");
			System.out.println("3 - Placanje");
			System.out.println("4 - Povijest transakcija");
			System.out.println("5 - Tecajna lista");
		
			int choice = Integer.parseInt(scanner.nextLine());
		
			switch (choice) {
			
				case 1:
					System.out.println("Jeste li sigurni? y/n");
					String answer = scanner.nextLine().toLowerCase();
					if (answer.equals("y")) {
						logout = true;
						System.out.println("Uspjesna odjava");
					} else {
						System.out.println("Povratak na izbornik");
					}
					break;
					
				case 2:
					showStanjeRacuna(stanjeRacuna);
					break;
					
				case 3:
					napraviPlacanje(scanner, stanjeRacuna, transakcijaLista);
					break;
					
				case 4:
					showPovijestTransakcija(scanner, transakcijaLista);
					break;
				
				case 5:
	                TecajnaListaIspis.showTecajnaLista();
					break;
					
				default:
					System.out.println("Unos nije prepoznat kao postojeca opcija");
					break;
				
			}
		}
	}
	
	private static void showStanjeRacuna(Racun stanjeRacuna) {
		System.out.println("Broj racuna: " + stanjeRacuna.getBrojRacuna());
		System.out.println("Stanje: " + stanjeRacuna.getIznos() + " " + stanjeRacuna.getValuta());
		System.out.println("Pritisnite enter za povratak na izbornik.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	private static void napraviPlacanje (Scanner scanner, Racun stanjeRacuna, TransakcijaLista transakcijaLista) {
		
		System.out.print("Upisi IBAN: ");
		String iban = scanner.nextLine();
		
		if (iban.length() != 21) {
			System.out.println("Nevazeca duzina IBAN-a. Mora imati 21 znak.");
			return;
		}
		
		System.out.print("Upisi iznos: ");
		double iznos = Double.parseDouble(scanner.nextLine());
		
		if (iznos > stanjeRacuna.getIznos()) {
			System.out.println("Nedovoljno novaca na racunu, placanje nije bilo moguce izvrsiti.");
		} else {
			stanjeRacuna.smanjiIznos(iznos);
			
			boolean vazeciDatum = false;
			String datum = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date parsedDate = null;
			while (!vazeciDatum) {
				System.out.println("Upisi datum placanja (dd/mm/yyyy): ");
				datum = scanner.nextLine();
				try {
					dateFormat.setLenient(false);
					parsedDate = dateFormat.parse(datum);
					vazeciDatum = true;
				} catch (ParseException e) {
					System.out.println("Krivi format datuma, koristite dd/mm/yyyy");
				}
			}
			
			System.out.println("Placanje uspjesno!");
			
			
			Transakcija transakcija = new Transakcija(parsedDate, iznos, iban);
			transakcijaLista.addTransakcija(transakcija);
		}
		
	}
	
	private static void showPovijestTransakcija(Scanner scanner, TransakcijaLista transakcijaLista) {
		transakcijaLista.showPovijestTransakcija(scanner);
	}
	
	public static boolean shouldLogout() {
		return logout;
	}
}

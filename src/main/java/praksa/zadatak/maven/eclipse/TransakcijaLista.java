package praksa.zadatak.maven.eclipse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TransakcijaLista {
	private List<Transakcija> transakcijas = new ArrayList<>();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public void addTransakcija(Transakcija transakcija) {
		transakcijas.add(transakcija);
	}
	
	public void showPovijestTransakcija(Scanner scanner) {
		if (transakcijas.isEmpty()) {
			System.out.println("Nisu pronadene transakcije.");
			return;
		}
		
		
		System.out.println("Odaberi nacin sortiranja:");
		System.out.println("1 - Po datumu");
		System.out.println("2 - Po iznosu");
		
		int choice = Integer.parseInt(scanner.nextLine());
		
		if (choice == 1) {
			sortByDate();
		} else if (choice == 2) {
			sortByAmount();
		} else {
			System.out.println("Nepostojeci odabir, povratak na izbornik.");
			return;
		}
		
		printPovijestTransakcija();
	}
	
	private void sortByDate() {
		transakcijas.sort(Comparator.comparing(Transakcija::getDatum).reversed());
	}
	
	private void sortByAmount() {
		transakcijas.sort(Comparator.comparing(Transakcija::getIznos).reversed());
	}
	
	private void printPovijestTransakcija() {
		System.out.println("Povijest transakcija:\n");
		for (Transakcija transakcija : transakcijas) {
			String dateStr = dateFormat.format(transakcija.getDatum());
			System.out.println("Datum: " + dateStr);
			System.out.println("Iznos: " + transakcija.getIznos() + "EUR");
			System.out.println("IBAN: " + transakcija.getIban());
			System.out.println("----------");
		}
	}
}

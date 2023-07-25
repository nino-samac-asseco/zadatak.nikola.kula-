package praksa_zadatak;

import java.util.Scanner;

public class Menu {
	private static boolean logout = false;
	
	public static void showMenu(Scanner scanner, Racun stanjeRacuna) {
		while (!logout) {
			System.out.println("Odaberi opciju: ");
			System.out.println("1 - Odjava");
			System.out.println("2 - Stanje racuna");
			System.out.println("3 - opcija 3");
			System.out.println("4 - opcija 4");
		
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
		
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
	}
	
	public static boolean shouldLogout() {
		return logout;
	}
}
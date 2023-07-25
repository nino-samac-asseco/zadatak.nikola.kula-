package praksa_zadatak;

import java.util.Scanner;

public class Prijava {
	private static final String USERNAME = "johndoe";
	private static final String PASSWORD = "12345abcde";
	
	public static boolean login(Scanner scanner) {
		System.out.println("Prijava u aplikaciju");
		System.out.print("Username: ");
		String username = scanner.nextLine();
		System.out.print("Password: ");
		String password = scanner.nextLine();
		
		if (username.equals(USERNAME) && MD5Util.encrypt(password).equals(MD5Util.encrypt(PASSWORD))) {
			System.out.println("Prijava uspjesna!");
			return true;
		} else {
			System.out.println("Netocan username ili password");
			return false;
		}
	}
}

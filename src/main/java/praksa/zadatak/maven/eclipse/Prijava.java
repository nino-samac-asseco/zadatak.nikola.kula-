package praksa.zadatak.maven.eclipse;

import java.util.Scanner;
import org.apache.log4j.Logger;  



public class Prijava {
	
    private static final Logger logger = Logger.getLogger(Prijava.class);

	
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
			logger.info("Korisnik " + USERNAME + " uspjesno se prijavio.");
			return true;
		} else {
			System.out.println("Netocan username ili password");
			return false;
		}
	}
}

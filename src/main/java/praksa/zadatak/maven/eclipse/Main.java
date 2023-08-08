package praksa.zadatak.maven.eclipse;

import java.util.Scanner; 
import org.apache.log4j.Logger;  

public class Main {
	
    private static final Logger logger = Logger.getLogger(Main.class);
    
	public static void main(String[] args) {

		logger.info("Zapocet program");
		
		Scanner scanner = new Scanner(System.in);
		
		boolean loggedIn = false;
		while (!loggedIn) {
			loggedIn = Prijava.login(scanner);
			if (loggedIn) {
				Racun stanjeRacuna = new Racun("54321", 10000, "EUR");
				TransakcijaLista transakcijaLista = new TransakcijaLista();
				Menu.showMenu(scanner, stanjeRacuna, transakcijaLista);
				
			} else {
				logger.warn("Neuspjela prijava");
			}
		}
		
		scanner.close();
		
        logger.info("Program zavrsen");
        
	}
}

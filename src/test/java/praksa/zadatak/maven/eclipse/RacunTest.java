package praksa.zadatak.maven.eclipse;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacunTest {
	
	private Racun racun;
	
	@BeforeEach
	public void setUp() {
		racun = new Racun("12345", 1000, "HRK");
	}
	
    @Test
    public void testGetBrojRacuna() {
        assertEquals("12345", racun.getBrojRacuna());
    }
	
}

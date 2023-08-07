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

    @Test
    public void testGetIznos() {
        assertEquals(1000, racun.getIznos(), 0.001);
    }

    @Test
    public void testGetValuta() {
        assertEquals("HRK", racun.getValuta());
    }

    @Test
    public void testSmanjiIznos() {
        racun.smanjiIznos(500);
        assertEquals(500, racun.getIznos(), 0.001);
    }
	
}

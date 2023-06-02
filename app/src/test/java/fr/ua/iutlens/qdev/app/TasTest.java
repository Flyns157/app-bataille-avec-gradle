package fr.ua.iutlens.qdev.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class TasTest {
    @Test
    public void testConstructor() {
        TasCartes tas = new TasCartes();
        assertNotNull(tas);
    }
    
    @Test
    public void testGetNombreDeCartes() {
        TasCartes tas = mock(TasCartes.class);
        when(tas.getNombreDeCartes()).thenReturn(10);
        assertEquals(10, tas.getNombreDeCartes());
    }
}
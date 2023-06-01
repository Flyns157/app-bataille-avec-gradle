package fr.ua.iutlens.qdev.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarteTest {

    @Test
    void testConstructor() {
        Carte carte = new Carte(Couleur.CARREAU, Valeur.AS);
        assertEquals(Couleur.CARREAU, carte.getCouleur());
        assertEquals(Valeur.AS, carte.getValeur());
    }

    @Test
    void testFromString() {
        Carte carte = Carte.fromString("CA");
        assertEquals(Couleur.CARREAU, carte.getCouleur());
        assertEquals(Valeur.AS, carte.getValeur());
    }

    @Test
    void testToString() {
        Carte carte = new Carte(Couleur.CARREAU, Valeur.AS);
        assertEquals("CA", carte.toString());
    }

    @Test
    void testEquals() {
        Carte carte1 = new Carte(Couleur.CARREAU, Valeur.AS);
        Carte carte2 = new Carte(Couleur.CARREAU, Valeur.AS);
        assertTrue(carte1.equals(carte2));
    }

    @Test
    void testCompareTo() {
        Carte carte1 = new Carte(Couleur.CARREAU, Valeur.AS);
        Carte carte2 = new Carte(Couleur.PIQUE, Valeur.Roi);
        assertTrue(carte1.compareTo(carte2) < 0);
    }
}
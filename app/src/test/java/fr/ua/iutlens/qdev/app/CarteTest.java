package fr.ua.iutlens.qdev.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarteTest {

    @Test
    public void testConstructeur() {
        // Teste le constructeur de la classe Carte
        Carte carte = new Carte(Couleur.PIQUE, Valeur.AS);
        Assertions.assertEquals(Couleur.PIQUE, carte.getCouleur());
        Assertions.assertEquals(Valeur.AS, carte.getValeur());
    }

    @Test
    public void testFromString() {
        // Teste la méthode fromString() de la classe Carte
        Carte carte = Carte.fromString("S2");
        Assertions.assertEquals(Couleur.PIQUE, carte.getCouleur());
        Assertions.assertEquals(Valeur.DEUX, carte.getValeur());
    }

    @Test
    public void testToString() {
        // Teste la méthode toString() de la classe Carte
        Carte carte = new Carte(Couleur.COEUR, Valeur.Dame);
        Assertions.assertEquals("CD", carte.toString());
    }

    @Test
    public void testEquals() {
        // Teste la méthode equals() de la classe Carte
        Carte carte1 = new Carte(Couleur.TREFLE, Valeur.Valet);
        Carte carte2 = new Carte(Couleur.TREFLE, Valeur.Valet);
        Carte carte3 = new Carte(Couleur.CARREAU, Valeur.Valet);

        Assertions.assertEquals(carte1, carte2); // Vérifie que les deux cartes sont égales
        Assertions.assertNotEquals(carte1, carte3); // Vérifie que les deux cartes ne sont pas égales
    }

    @Test
    public void testCompareTo() {
        // Teste la méthode compareTo() de la classe Carte
        Carte carte1 = new Carte(Couleur.TREFLE, Valeur.AS);
        Carte carte2 = new Carte(Couleur.CARREAU, Valeur.DEUX);
        Carte carte3 = new Carte(Couleur.COEUR, Valeur.AS);

        Assertions.assertTrue(carte1.compareTo(carte2) > 0); // Vérifie que carte1 est supérieure à carte2
        Assertions.assertTrue(carte2.compareTo(carte3) < 0); // Vérifie que carte2 est inférieure à carte3
        Assertions.assertEquals(0, carte1.compareTo(carte3)); // Vérifie que carte1 est égale à carte3
    }
}

package fr.ua.iutlens.qdev.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class TasTest {

    @Mock
    private ITas mockTas;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Teste le constructeur de la classe TasCartes.
     */
    @Test
    public void testConstructeur() {
        List<Carte> cartes = new ArrayList<>();
        cartes.add(new Carte(Couleur.PIQUE, Valeur.AS));
        cartes.add(new Carte(Couleur.COEUR, Valeur.DEUX));
        TasCartes tas = new TasCartes(cartes);

        Assertions.assertEquals(2, tas.size());
        Assertions.assertEquals(new Carte(Couleur.PIQUE, Valeur.AS), tas.prendreCarte());
    }

    /**
     * Teste la méthode estVide() de la classe TasCartes.
     */
    @Test
    public void testEstVide() {
        TasCartes tas = new TasCartes();
        Assertions.assertTrue(tas.estVide());

        tas.ajouterCartes(new Carte(Couleur.PIQUE, Valeur.AS));
        Assertions.assertFalse(tas.estVide());
    }

    /**
     * Teste la méthode prendreCarte() de la classe TasCartes.
     */
    @Test
    public void testPrendreCarte() {
        TasCartes tas = new TasCartes();
        Carte carte = new Carte(Couleur.CARREAU, Valeur.Roi);
        tas.ajouterCartes(carte);

        Assertions.assertEquals(carte, tas.prendreCarte());
        Assertions.assertTrue(tas.estVide());
    }

    /**
     * Teste la méthode ajouterCarte() de la classe TasCartes.
     */
    @Test
    public void testAjouterCarte() {
        TasCartes tas = new TasCartes();
        Carte carte = new Carte(Couleur.TREFLE, Valeur.Dame);
        tas.ajouterCartes(carte);

        Assertions.assertEquals(1, tas.size());
        Assertions.assertEquals(carte, tas.prendreCarte());
    }

    /**
     * Teste la méthode ajouterCartes() de la classe TasCartes.
     */
    @Test
    public void testAjouterCartes() {
        TasCartes tas = new TasCartes();
        List<Carte> cartes = new ArrayList<>();
        cartes.add(new Carte(Couleur.COEUR, Valeur.Valet));
        cartes.add(new Carte(Couleur.PIQUE, Valeur.AS));
        tas.ajouterCartes(cartes);

        Assertions.assertEquals(2, tas.size());
        Assertions.assertEquals(new Carte(Couleur.COEUR, Valeur.Valet), tas.prendreCarte());
        Assertions.assertEquals(new Carte(Couleur.PIQUE, Valeur.AS), tas.prendreCarte());
    }

    /**
     * Teste la méthode melanger() de la classe TasCartes.
     */
    @Test
    public void testMelanger() {
        TasCartes tas = new TasCartes();
        List<Carte> cartes = new ArrayList<>();
        cartes.add(new Carte(Couleur.CARREAU, Valeur.TROIS));
        cartes.add(new Carte(Couleur.PIQUE, Valeur.Roi));
        cartes.add(new Carte(Couleur.TREFLE, Valeur.Dame));
        tas.ajouterCartes(cartes);
        tas.melanger();

        Assertions.assertEquals(3, tas.size());
        // Vérifie si les cartes mélangées sont différentes de l'ordre d'origine
        Assertions.assertNotEquals(new Carte(Couleur.CARREAU, Valeur.TROIS), tas.prendreCarte());
        Assertions.assertNotEquals(new Carte(Couleur.PIQUE, Valeur.Roi), tas.prendreCarte());
        Assertions.assertNotEquals(new Carte(Couleur.TREFLE, Valeur.Dame), tas.prendreCarte());
    }

    /**
     * Teste la méthode size() de la classe TasCartes.
     */
    @Test
    public void testsize() {
        TasCartes tas = new TasCartes();
        Assertions.assertEquals(0, tas.size());

        tas.ajouterCartes(new Carte(Couleur.CARREAU, Valeur.DIX));
        tas.ajouterCartes(new Carte(Couleur.COEUR, Valeur.Dame));
        Assertions.assertEquals(2, tas.size());
    }

    /**
     * Teste la méthode toString() de la classe TasCartes.
     */
    @Test
    public void testToString() {
        TasCartes tas = new TasCartes();
        tas.ajouterCartes(new Carte(Couleur.TREFLE, Valeur.SEPT));
        tas.ajouterCartes(new Carte(Couleur.CARREAU, Valeur.Valet));

        Assertions.assertEquals("[7♣, J♦]", tas.toString());
    }

    /**
     * Teste la méthode equals() de la classe TasCartes.
     */
    @Test
    public void testEquals() {
        TasCartes tas1 = new TasCartes();
        tas1.ajouterCartes(new Carte(Couleur.PIQUE, Valeur.AS));
        tas1.ajouterCartes(new Carte(Couleur.TREFLE, Valeur.Dame));

        TasCartes tas2 = new TasCartes();
        tas2.ajouterCartes(new Carte(Couleur.PIQUE, Valeur.AS));
        tas2.ajouterCartes(new Carte(Couleur.TREFLE, Valeur.Dame));

        TasCartes tas3 = new TasCartes();
        tas3.ajouterCartes(new Carte(Couleur.COEUR, Valeur.Roi));

        Assertions.assertEquals(tas1, tas2);
        Assertions.assertNotEquals(tas1, tas3);
    }
}

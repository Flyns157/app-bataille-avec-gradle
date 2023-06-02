package fr.ua.iutlens.qdev.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Classe de tests pour la classe Bataille.
 */
@DisplayName("Bataille Test")
public class BatailleTest {

    @Mock
    private ITas tas1;

    @Mock
    private ITas tas2;

    private Bataille bataille;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        bataille = new Bataille(tas1, tas2);
    }

    @Test
    @DisplayName("Test bataille - Player 1 wins")
    public void testBataille_Player1Wins() {
        Carte carte1 = new Carte(Couleur.PIQUE, Valeur.AS);
        Carte carte2 = new Carte(Couleur.COEUR, Valeur.Dame);

        when(tas1.prendreCarte()).thenReturn(carte1);
        when(tas2.prendreCarte()).thenReturn(carte2);

        boolean result = bataille.bataille();

        assertTrue(result);
        verify(tas1).prendreCarte();
        verify(tas2).prendreCarte();
        verify(tas1).ajouterCartes(anyList());
        verify(tas2, never()).ajouterCartes(anyList());
    }

    @Test
    @DisplayName("Test bataille - Player 2 wins")
    public void testBataille_Player2Wins() {
        Carte carte1 = new Carte(Couleur.CARREAU, Valeur.Valet);
        Carte carte2 = new Carte(Couleur.TREFLE, Valeur.AS);

        when(tas1.prendreCarte()).thenReturn(carte1);
        when(tas2.prendreCarte()).thenReturn(carte2);

        boolean result = bataille.bataille();

        assertTrue(result);
        verify(tas1).prendreCarte();
        verify(tas2).prendreCarte();
        verify(tas1, never()).ajouterCartes(anyList());
        verify(tas2).ajouterCartes(anyList());
    }

    @Test
    @DisplayName("Test bataille - Draw")
    public void testBataille_Draw() {
        Carte carte1 = new Carte(Couleur.PIQUE, Valeur.Dame);
        Carte carte2 = new Carte(Couleur.COEUR, Valeur.Dame);

        when(tas1.prendreCarte()).thenReturn(carte1);
        when(tas2.prendreCarte()).thenReturn(carte2);

        boolean result = bataille.bataille();

        assertFalse(result);
        verify(tas1).prendreCarte();
        verify(tas2).prendreCarte();
        verify(tas1, never()).ajouterCartes(anyList());
        verify(tas2, never()).ajouterCartes(anyList());
    }

    @Test
    @DisplayName("Test joue - Player 1 wins")
    public void testJoue_Player1Wins() {
        when(tas1.estVide()).thenReturn(false, true);
        when(tas2.estVide()).thenReturn(false, true);

        ITas winner = bataille.joue();

        assertSame(tas1, winner);
        verify(tas1, times(2)).estVide();
        verify(tas2, times(2)).estVide();
        verify(tas1, atLeastOnce()).prendreCarte();
        verify(tas2, atLeastOnce()).prendreCarte();
       
        verify(tas1, never()).ajouterCartes(anyList());
        verify(tas2, never()).ajouterCartes(anyList());
    }

    @Test
    @DisplayName("Test joue - Player 2 wins")
    public void testJoue_Player2Wins() {
        when(tas1.estVide()).thenReturn(false, true);
        when(tas2.estVide()).thenReturn(true, false);

        ITas winner = bataille.joue();

        assertSame(tas2, winner);
        verify(tas1, times(2)).estVide();
        verify(tas2, times(2)).estVide();
        verify(tas1, atLeastOnce()).prendreCarte();
        verify(tas2, atLeastOnce()).prendreCarte();
        verify(tas1, never()).ajouterCartes(anyList());
        verify(tas2, never()).ajouterCartes(anyList());
    }

    @Test
    @DisplayName("Test joue")
    public void testJoue_Draw() {
        when(tas1.estVide()).thenReturn(true);
        when(tas2.estVide()).thenReturn(true);

        ITas winner = bataille.joue();

        assertNull(winner);
        verify(tas1).estVide();
        verify(tas2).estVide();
        verify(tas1, never()).prendreCarte();
        verify(tas2, never()).prendreCarte();
        verify(tas1, never()).ajouterCartes(anyList());
        verify(tas2, never()).ajouterCartes(anyList());
    }
}

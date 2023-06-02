package fr.ua.iutlens.qdev.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TasFactoryTest {

    /**
     * Teste la méthode jeu52Cartes() de la classe TasFactory.
     */
    @Test
    public void testJeu52Cartes() {
        ITas tas = TasFactory.jeu52Cartes();
        Assertions.assertNotNull(tas);
        Assertions.assertEquals(52, tas.size());
    }

    /**
     * Teste la méthode jeu52CartesShuffle() de la classe TasFactory.
     */
    @Test
    public void testJeu52CartesShuffle() {
        ITas tas = TasFactory.jeu52CartesShuffle();
        Assertions.assertNotNull(tas);
        Assertions.assertEquals(52, tas.size());
    }

    /**
     * Teste la méthode jeu52CartesShuffle(long seed) de la classe TasFactory.
     */
    @Test
    public void testJeu52CartesShuffleWithSeed() {
        long seed = 12345L;
        ITas tas = TasFactory.jeu52CartesShuffle(seed);
        Assertions.assertNotNull(tas);
        Assertions.assertEquals(52, tas.size());
    }

    /**
     * Teste la méthode splitJeu52CartesShuffle(int nbTas, long seed) de la classe TasFactory.
     */
    @Test
    public void testSplitJeu52CartesShuffle() {
        int nbTas = 4;
        long seed = 12345L;
        ITas[] tasArray = TasFactory.splitJeu52CartesShuffle(nbTas, seed);
        Assertions.assertNotNull(tasArray);
        Assertions.assertEquals(nbTas, tasArray.length);

        int totalCards = 0;
        for (ITas tas : tasArray) {
            totalCards += tas.size();
        }
        Assertions.assertEquals(52, totalCards);
    }
}

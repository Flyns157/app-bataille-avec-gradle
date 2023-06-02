package fr.ua.iutlens.qdev.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class TasFactoryTest {

    @Mock
    private ITas tasMock;

    @Test
    public void testJeu52Cartes() {
        ITas tas = TasFactory.jeu52Cartes();
        Assertions.assertNotNull(tas);
        Assertions.assertEquals(52, tas.size());
    }

    @Test
    public void testJeu52CartesShuffle() {
        ITas tas = TasFactory.jeu52CartesShuffle();
        Assertions.assertNotNull(tas);
        Assertions.assertEquals(52, tas.size());
    }

    @Test
    public void testJeu52CartesShuffleWithSeed() {
        ITas tas = TasFactory.jeu52CartesShuffle(123L);
        Assertions.assertNotNull(tas);
        Assertions.assertEquals(52, tas.size());
    }

    @Test
    public void testSplitJeu52CartesShuffle() {
        int nbTas = 4;
        long seed = 123L;

        ITas[] tasArray = TasFactory.splitJeu52CartesShuffle(nbTas, seed);

        Assertions.assertNotNull(tasArray);
        Assertions.assertEquals(nbTas, tasArray.length);
        for (ITas tas : tasArray) {
            Assertions.assertNotNull(tas);
            Assertions.assertEquals(13, tas.size());
        }
    }
}

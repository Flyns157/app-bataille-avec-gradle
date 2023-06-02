package fr.ua.iutlens.qdev.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Classe Factory qui crée différents types de tas de cartes.
 *
 * <ul>
 *     <li>un tas composé de 52 cartes</li>
 *     <li>jun tas composé de 52 cartes mélangées</li>
 *     <li>un tableau de tas qui constituent un jeu de 52 cartes mélangées </li>
 * </ul>
 */
public class TasFactory {

    /**
     * On ne crée pas d'instance de la classe TasFactory.
     */
    private TasFactory() {
    }

    /**
     * Crée une liste de 52 cartes qui sera utilisée dans les autres fonctions.
     *
     * @return {@link List} of {@link Carte}
     */
    private static List<Carte> createListOf52Cards() {
        List<Carte> listeCartes = new ArrayList<>();
        for (Couleur c : Couleur.values()) {
            for (Valeur v : Valeur.values()) {
                listeCartes.add(new Carte(c, v));
            }
        }
        return listeCartes;
    }

    /**
     * Revoie un tas de 52 cartes.
     *
     * @return {@link ITas} of {@link Carte}
     */
    public static ITas jeu52Cartes() {
        List<Carte> listeCartes = createListOf52Cards();
        return new TasCartes(listeCartes);
    }

    /**
     * Revoie un tas de 52 cartes mélangées.
     *
     * @return {@link ITas} of {@link Carte}
     */
    public static ITas jeu52CartesShuffle() {
        return jeu52CartesShuffle(null);
    }

    /**
     * Revoie un tas de 52 cartes mélangées.
     *
     * @param seed la graine pour le random
     * @return {@link ITas} of {@link Carte}
     */
    public static ITas jeu52CartesShuffle(Long seed) {
        List<Carte> listeCartes = createListOf52Cards();
        if (seed == null) {
            Collections.shuffle(listeCartes);
        } else {
            Collections.shuffle(listeCartes, new Random(seed));
        }
        return new TasCartes(listeCartes);
    }

    /**
     * Renvoie un tableau de {@param nbTas} tas de cartes ({@link Carte}) à partir d'une collection de 52 cartes.
     *
     * @param nbTas number of tas
     * @param seed random seed
     * @return array {@link ITas} of {@link Carte}
     */
    public static ITas[] splitJeu52CartesShuffle(int nbTas, long seed) {
        List<Carte> listeCartes = createListOf52Cards();
        Collections.shuffle(listeCartes, new Random(seed));
        ITas[] tas = new TasCartes[nbTas];
        for (int i = 0; i < nbTas; i++) {
            tas[i] = new TasCartes(listeCartes.subList(i * (52 /nbTas), (i + 1) * (52 /nbTas)));
        }
        return tas;
    }
}
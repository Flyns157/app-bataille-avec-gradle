package fr.ua.iutlens.qdev.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Jeu de bataille.
 */
public class Bataille {

    /**
     * Tas de cartes du joueur 1
     */
    private final ITas t1;

    /**
     * Tas de cartes du joueur 2
     */
    private final ITas t2;

    /**
     * Crée une instance de la classe Bataille.
     *
     * @param t1 tas de cartes du joueur 1
     * @param t2 tas de cartes du joueur 2
     */
    public Bataille(ITas t1, ITas t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    /**
     * Renvoie {@code true} si le coup est possible et {@code false} sinon.
     *
     * C'est dans cette méthode que l'on joue à la bataille :
     *
     * <ol>
     *     <li>Chaque joueur prend une carte au sommet de son jeu</li>
     *     <li>En cas d'égalité :
     *     <ol>
     *         <li>En fonction des cartes disponibles on déroule les règles</li>
     *     </ol>
     *     </li>
     *     <li>On range les cartes dans le tas du joueur gagnant du coup</li>
     * </ol>
     *
     * @return
     */
    public boolean bataille() {
        if (t1.estVide() || t2.estVide())
            return false;
        List<Carte> liste = new ArrayList<>();
        Carte c1 = t1.prendreCarte();
        Carte c2 = t2.prendreCarte();
        liste.add(c1);
        liste.add(c2);
        while (c1.compareTo(c2) == 0) {
            for(int i = 0; i < 2; i++) {
                if (!t1.estVide())
                    c1 = t1.prendreCarte();
                else
                    c1 = t2.prendreCarte();
                if (!t2.estVide())
                    c2 = t2.prendreCarte();
                else
                    c2 = t1.prendreCarte();
                liste.add(c1);
                liste.add(c2);
            }
        }
        if (c1.compareTo(c2) > 0) {
            t1.ajouterCartes(liste);
        } else {
            t2.ajouterCartes(liste);
        }
        return true;
    }

    /**
     * Boucle du jeu de bataille.
     *
     * Le jeu continue tant que les deux joueurs ont des cartes dans leur jeu.
     *
     * @return un {@code ITas} du joueur gagnant
     */
    public ITas joue() {
        while (bataille()) ;

        if (t1.estVide()) {
            return t2;
        }
        return t1;
    }

}
package fr.ua.iutlens.qdev.app;

import java.util.Collection;

/**
 * Interface de gestion d'un tas de cartes instances de la classe {@link Carte}
 */
public interface ITas {
    /**
     * @return {@code true} s'il n'y a plus de carte dans le tas. La fonction {@code size()} renvoie {@code 0}, {@code false} sinon.
     */
    boolean estVide();

    /**
     * @return le nombre d'instances de la class {@link Carte} dans le tas
     */
    int size();

    /**
     * @return une instance de la class {@link Carte} en première position dans le tas
     */
    Carte prendreCarte();

    /**
     * Ajoute une collection d'instances de la classe {@link Carte} à la fin du tas
     *
     * @param cartes
     */
    void ajouterCartes(Collection<Carte> cartes);

    /**
     * Ajoute une liste d'instances de la classe {@link Carte} à la fin du tas
     *
     * @param cartes
     */
    void ajouterCartes(Carte... cartes);

    /**
     * Ajoute une liste de cartes {@code strs} au format VC (Valeur Couleur) séparées par un espace à la fin du tas.
     *
     * @param strs
     */
    void ajouterCartes(String strs);

    /**
     * Ajoute une liste de cartes {@code strs} au format VC (Valeur Couleur) séparées par le séparateur {@code separateur} à la fin du tas.
     *
     * @param strs
     * @param separateur
     */
    void ajouterCartes(String strs, String separateur);
}
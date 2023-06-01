package fr.ua.iutlens.qdev.app;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Classe qui implémente l'interface {@see fr.ua.iutlens.qdev.bataille.ITas} 
 */
public class TasCartes implements ITas {
    private final Queue<Carte> cartes = new LinkedList<>();

    public TasCartes() {
    }

    /**
     * Création à partir d'une collection d'instances de la classe {@link Carte}
     *
     * @param cartes La collection de cartes à ajouter dans le tas
     */
    public TasCartes(Collection<Carte> cartes) {
        if (cartes != null)
            this.cartes.addAll(cartes);
    }


    /**
     * Création à partir d'une liste de cartes {@code strs} au format VC (Valeur Couleur) séparées par un espace
     *
     * @param strs la liste des cartes
     */
    public TasCartes(String strs) {
        this(strs, "\s|\t");
    }

    /**
     * Création à partir d'une liste de cartes {@code strs} au format VC (Valeur Couleur) séparées par le séparateur {@code separateur}
     *
     * @param strs la liste des cartes
     * @param separateur Le séparateur dans la liste de cartes
     */
    public TasCartes(String strs, String separateur) {
        String[] lesCartes = strs.split(separateur);
        System.out.printf("%d %s%n", lesCartes.length, Arrays.toString(lesCartes));
        for (String s : lesCartes) {
            if (s.length() > 1)
                this.ajouterCartes(new Carte(Couleur.fromString(s.substring(0, 1)), Valeur.fromString(s.substring(1))));
        }
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.ua.iutlens.qdev.bataille.ITas#estVide()
     */
    @Override
    public boolean estVide() {
        return cartes.isEmpty();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.ua.iutlens.qdev.bataille.ITas#size()
     */
    @Override
    public int size() {
        return cartes.size();
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.ua.iutlens.qdev.bataille.ITas#prendreCarte()
     */
    @Override
    public Carte prendreCarte() {
        return this.cartes.poll();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.ua.iutlens.qdev.bataille.ITas#ajouterCartes(Collection<Carte> cartes)
     */
    @Override
    public void ajouterCartes(Collection<Carte> cartes) {
        this.cartes.addAll(cartes);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.ua.iutlens.qdev.bataille.ITas#ajouterCartes(Carte... cartes)
     */
    @Override
    public void ajouterCartes(Carte... cartes) {
        this.cartes.addAll(Arrays.asList(cartes));
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.ua.iutlens.qdev.bataille.ITas#ajouterCartes(String strs)
     */
    @Override
    public void ajouterCartes(String strs) {
        this.ajouterCartes(strs, " ");
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.ua.iutlens.qdev.bataille.ITas#ajouterCartes(String strs, String separateur)
     */
    @Override
    public void ajouterCartes(String strs, String separateur) {
        String[] lesStrCartes = strs.split(separateur);
        for (String s : lesStrCartes) {
            this.ajouterCartes(new Carte(Couleur.fromString(s.substring(0, 1)), Valeur.fromString(s.substring(1))));
        }
    }
}
package fr.ua.iutlens.qdev.app;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Carte implements Comparable<Carte> {
    private final Couleur couleur;
    private final Valeur valeur;

    public Carte(Couleur couleur, Valeur valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Valeur getValeur() {
        return valeur;
    }

    @Override
    public int compareTo(Carte o) {
        return valeur.compareTo(o.valeur);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + couleur.hashCode();
        result = prime * result + valeur.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carte other = (Carte) obj;
        if (couleur != other.couleur)
            return false;
        return valeur == other.valeur;
    }

    static public Carte fromString(String str) {
            return new Carte(Couleur.fromString(str.substring(0, 1)), Valeur.fromString(str.substring(1)));
    }

    @Override
    public String toString() {
        return String.format("%s%s",getCouleur(), getValeur());
    }
}
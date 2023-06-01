package fr.ua.iutlens.qdev.app;

/**
 * La couleur de la carte.
 */
public enum Couleur {
    PIQUE("♠"), CARREAU("♦"), COEUR("♥"), TREFLE("♣");

    /**
     * glyphe de la couleur
     */
    private final String value;

    /**
     * Association entre le nom de la couleur et le glyphe qui la représente
     *
     * @param value le glyphe
     */
    Couleur(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static Couleur fromString(String s) {
        switch (s) {
            case "♠":
                return PIQUE;
            case "♣":
                return TREFLE;
            case "♥":
                return COEUR;
            case "♦":
                return CARREAU;
            default:
                throw new IllegalArgumentException("Ne correspond pas à une couleur");
        }
    }
}
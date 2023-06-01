package fr.ua.iutlens.qdev.app;

/**
 * La valeur de la carte
 */
public enum Valeur {
    DEUX("2"), TROIS("3"), QUATRE("4"), CINQ("5"), SIX("6"), SEPT("7"), HUIT("8"), NEUF("9"), DIX("10"), Valet("V"), Dame("D"), Roi("R"), AS("1");

    /**
     * La valeur sous forme de {@code String}.
     */
    private final String value;

    /**
     * Création d'une {@code Valeur}.
     *
     * @param value
     */
    Valeur(String value) {
        this.value = value;
    }

    /**
     * (non-Javadoc)
     *
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return value;
    }

    /**
     * Renvoie une valeur à partir de la représentation sous forme de {@code String}.
     *
     * @param s la représentation de la valeur en {@code String}
     * @return l'élément de l'énumération qui correspond à la {@code String}
     * @throws IllegalArgumentException si la valeur en {@code String} ne correspond pas à une valeur dans l'énumération
     */
    public static Valeur fromString(String s) {
        for (Valeur v : values()) {
            if (v.value.equals(s)) {
                return v;
            }
        }
        throw new IllegalArgumentException(s + " ne correspond pas à une valeur");
    }
}
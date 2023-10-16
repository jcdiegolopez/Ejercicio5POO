/**
 * Representa la subclase Auxiliar de Jugador
 *
 */
public class Auxiliar extends Jugador {
    /**
     * Número de ataques realizados.
     */
    private int ataques;
    /**
     * Número de bloqueos efectivos realizados.
     */
    private int bloqueosE;
     /**
     * Número de bloqueos fallidos realizados.
     */
    private int bloqueosF;
    /**
     * Constructor de la clase.
     *
     * @param nombre Nombre del jugador.
     * @param pais País del jugador.
     * @param errores Número de errores cometidos por el jugador.
     * @param aces Número de aces realizados por el jugador.
     * @param servicios Número de servicios realizados por el jugador.
     * @param ataques Número de ataques realizados por el jugador.
     * @param bloqueosE Número de bloqueos efectivos realizados por el jugador.
     * @param bloqueosF Número de bloqueos fallidos realizados por el jugador.
     */
    public Auxiliar(String nombre, String pais, int errores, int aces, int servicios, int ataques, int bloqueosE, int bloqueosF) {
        super(nombre, pais, errores, aces, servicios);
        this.ataques = ataques;
        this.bloqueosE = bloqueosE;
        this.bloqueosF = bloqueosF;
    }
    /**
     * Devuelve el número de ataques realizados.
     *
     * @return Número de ataques realizados.
     */
    public int getAtaques() {
        return ataques;
    }
    /**
     * Devuelve el número de bloqueos efectivos realizados.
     *
     * @return Número de bloqueos efectivos realizados.
     */
    public int getBloqueosE() {
        return bloqueosE;
    }
    /**
     * Devuelve el número de bloqueos fallidos realizados.
     *
     * @return Número de bloqueos fallidos realizados.
     */
    public int getBloqueosF() {
        return bloqueosF;
    }
    /**
     * Calcula la efectividad del jugador.
     *
     * @return Efectividad del jugador.
     */
    @Override
    public int calcEfectividad() {
        return ((ataques + bloqueosE - bloqueosF - errores) *100 / (ataques + bloqueosE + bloqueosF + errores)) + aces *100/servicios;
    }
    /**
     * Devuelve una representación en cadena del jugador.
     *
     * @return Representación en cadena del jugador.
     */
    @Override
    public String toString() {
        return "Auxiliar{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", errores=" + errores +
                ", aces=" + aces +
                ", servicios=" + servicios +
                ", ataques=" + ataques +
                ", bloqueosE=" + bloqueosE +
                ", bloqueosF=" + bloqueosF +
                '}';
    }
}

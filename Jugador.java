/**
 * Clase abstracta que representa a un jugador de voleibol.
 *
 */
public abstract class Jugador {

    /**
     * Nombre del jugador.
     */
    protected String nombre;

    /**
     * País del jugador.
     */
    protected String pais;

    /**
     * Número de errores del jugador.
     */
    protected int errores;

    /**
     * Número de aces del jugador.
     */
    protected int aces;

    /**
     * Número de servicios del jugador.
     */
    protected int servicios;

    /**
     * Constructor de la clase.
     *
     * @param nombre Nombre del jugador.
     * @param pais País del jugador.
     * @param errores Número de errores del jugador.
     * @param aces Número de aces del jugador.
     * @param servicios Número de servicios del jugador.
     */
    public Jugador(String nombre, String pais, int errores, int aces, int servicios) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.servicios = servicios;
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return Nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el país del jugador.
     *
     * @return País del jugador.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Obtiene el número de errores del jugador.
     *
     * @return Número de errores del jugador.
     */
    public int getErrores() {
        return errores;
    }

    /**
     * Obtiene el número de aces del jugador.
     *
     * @return Número de aces del jugador.
     */
    public int getAces() {
        return aces;
    }

    /**
     * Obtiene el número de servicios del jugador.
     *
     * @return Número de servicios del jugador.
     */
    public int getServicios() {
        return servicios;
    }

    /**
     * Método abstracto que calcula la efectividad del jugador.
     *
     * @return Efectividad del jugador.
     */
    public abstract int calcEfectividad();

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", errores=" + errores +
                ", aces=" + aces +
                ", servicios=" + servicios +
                '}';
    }
}
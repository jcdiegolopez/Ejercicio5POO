/**
 * La clase Libero representa a un jugador de voleibol que se desempeña como libero.
 * Extiende la clase Jugador e incluye atributos y métodos específicos para un libero.
 */
public class Libero extends Jugador {

    private int recibosE;

    /**
     * Constructor para crear un objeto Libero.
     *
     * @param nombre Nombre del libero.
     * @param pais   País de origen del libero.
     * @param errores Cantidad de errores cometidos por el libero.
     * @param aces    Cantidad de aces logrados por el libero.
     * @param servicios Cantidad de servicios realizados por el libero.
     * @param recibosE Cantidad de recibos exitosos realizados por el libero.
     */
    public Libero(String nombre, String pais, int errores, int aces, int servicios, int recibosE) {
        super(nombre, pais, errores, aces, servicios);
        this.recibosE = recibosE;
    }

    /**
     * Obtiene la cantidad de recibos exitosos realizados por el libero.
     *
     * @return La cantidad de recibos exitosos.
     */
    public int getRecibosE() {
        return recibosE;
    }

    /**
     * Calcula la efectividad del libero en función de sus acciones en el campo.
     *
     * @return El valor de efectividad calculado.
     */
    @Override
    public int calcEfectividad() {
        return ((recibosE - errores) * 100 / (recibosE + errores)) + aces * 100 / servicios;
    }

    /**
     * Devuelve una representación en cadena de la información del libero.
     *
     * @return Una cadena que contiene los detalles del libero.
     */
    @Override
    public String toString() {
        return "Libero{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", errores=" + errores +
                ", aces=" + aces +
                ", servicios=" + servicios +
                ", recibosE=" + recibosE +
                '}';
    }
}

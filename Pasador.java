/**
/**
 * La clase Pasador representa a un jugador de voleibol especializado en pases y fintas.
 * Extiende la clase Jugador y agrega propiedades específicas para llevar un seguimiento de los pases y fintas realizados.
 */
public class Pasador extends Jugador {

    private int pases;   // El número de pases realizados por el jugador.
    private int fintas;  // El número de fintas realizadas por el jugador.

    /**
     * Constructor para crear un objeto Pasador con los atributos específicos de la clase y los heredados de Jugador.
     *
     * @param nombre     El nombre del jugador.
     * @param pais       El país de origen del jugador.
     * @param errores    La cantidad de errores cometidos por el jugador.
     * @param aces       La cantidad de aces realizados por el jugador.
     * @param servicios  La cantidad de servicios realizados por el jugador.
     * @param pases      La cantidad de pases realizados por el jugador.
     * @param fintas     La cantidad de fintas realizadas por el jugador.
     */
    public Pasador(String nombre, String pais, int errores, int aces, int servicios, int pases, int fintas) {
        super(nombre, pais, errores, aces, servicios);
        this.pases = pases;
        this.fintas = fintas;
    }

    /**
     * Obtiene la cantidad de pases realizados por el jugador.
     *
     * @return La cantidad de pases realizados.
     */
    public int getPases() {
        return pases;
    }

    /**
     * Obtiene la cantidad de fintas realizadas por el jugador.
     *
     * @return La cantidad de fintas realizadas.
     */
    public int getFintas() {
        return fintas;
    }

    /**
     * Calcula la efectividad del jugador como pasador.
     * La efectividad se basa en los pases, fintas, errores, aces y servicios realizados por el jugador.
     *
     * @return El valor de efectividad calculado.
     */
    @Override
    public int calcEfectividad() {
        return ((pases + fintas - errores) * 100 / (pases + fintas + errores)) + aces * 100 / servicios;
    }

    /**
     * Convierte el objeto Pasador en una representación de cadena que incluye sus atributos.
     *
     * @return Una cadena que representa el objeto Pasador.
     */
    @Override
    public String toString() {
        return "Pasador{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", errores=" + errores +
                ", aces=" + aces +
                ", servicios=" + servicios +
                ", pases=" + pases +
                ", fintas=" + fintas +
                '}';
    }
}

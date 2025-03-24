package co.edu.poli.ejemplo1.modelo;

/**
 * 
 */
public abstract class Personal {

    /**
     * Default constructor
     */
    public Personal() {
    }

    /**
     * 
     */
    protected String nombre;

    /**
     * @param componente
     */
    public void agregarComponente(Personal componente) {
        // TODO implement here
    }

    /**
     * @param componente
     */
    public void eliminarComponente(Personal componente) {
        // TODO implement here
    }

    /**
     * @return
     */
    public abstract void MostrarDetalles();

}
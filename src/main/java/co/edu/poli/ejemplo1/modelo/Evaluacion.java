package co.edu.poli.ejemplo1.modelo;

/**
 * 
 */
public class Evaluacion extends Proveedor implements ProveedorBuilder {

    /**
     * Default constructor
     */
    public Evaluacion() {
    }

    /**
     * 
     */
    private double puntuacion;

    /**
     * 
     */
    public String comentarios;

    /**
     * @param id 
     * @return
     */
    public ProveedorBuilder addId(String id) {
        // TODO implement ProveedorBuilder.addId() here
        return null;
    }

    /**
     * @param nombre 
     * @return
     */
    public ProveedorBuilder addNombre(String nombre) {
        // TODO implement ProveedorBuilder.addNombre() here
        return null;
    }

    /**
     * @param certificacion 
     * @return
     */
    public ProveedorBuilder addCertificacion(Certificacion certificacion) {
        // TODO implement ProveedorBuilder.addCertificacion() here
        return null;
    }

    /**
     * @param politicaEntrega 
     * @return
     */
    public ProveedorBuilder addPoliticaEntrega(Proveedor.PoliticaEntrega politicaEntrega) {
        // TODO implement ProveedorBuilder.addPoliticaEntrega() here
        return null;
    }

    /**
     * @param evaluacion 
     * @return
     */
    public ProveedorBuilder addEvaluacion(Evaluacion evaluacion) {
        // TODO implement ProveedorBuilder.addEvaluacion() here
        return null;
    }

}
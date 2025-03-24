package co.poli.edu.ejemplo1.modelo;

import java.io.*;
import java.util.*;

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
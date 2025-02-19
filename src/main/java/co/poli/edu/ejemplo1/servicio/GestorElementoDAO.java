package co.poli.edu.ejemplo1.servicio;

import java.util.List;

/**
 * 
 */
public interface GestorElementoDAO<T> {

    /**
     * @param elemento 
     * @return
     */
    public String createElemento(T elemento);

    /**
     * @return
     */
    public List<T> listAllElementos();

    /**
     * @param id 
     * @return
     */
    public T readElemento(String id);

    /**
     * @param id 
     * @param elemento 
     * @return
     */
    public String updateElemento(String id, T elemento);

    /**
     * @param id 
     * @return
     */
    public T deleteElemento(String id);

}
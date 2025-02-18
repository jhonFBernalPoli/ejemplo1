package co.poli.edu.ejemplo1.servicio;

import java.io.*;
import java.util.*;

/**
 * 
 */
public interface GestorElementoDAO {

    /**
     * @param elemento 
     * @return
     */
    public String createElemento(Object elemento);

    /**
     * @return
     */
    public List<Object> listAllElementos();

    /**
     * @param id 
     * @return
     */
    public Object readElemento(String id);

    /**
     * @param id 
     * @param elemento 
     * @return
     */
    public String updateElemento(String id, Object elemento);

    /**
     * @param id 
     * @return
     */
    public Object deleteElemento(String id);

}
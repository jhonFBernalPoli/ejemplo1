package co.edu.poli.ejemplo1.modelo;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements EmpresaComponente {
    private String nombre;
    private List<EmpresaComponente> componentes;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

    public void agregarComponent(EmpresaComponente componente) {
        componentes.add(componente);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Departamento: " + nombre);
        for (EmpresaComponente componente : componentes) {
            componente.mostrarDetalles();
        }
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EmpresaComponente> getComponentes() {
        return componentes;
    }
}

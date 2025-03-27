package co.edu.poli.ejemplo1.modelo;

public class Proveedor {
    private String nombre;
    private Certificacion certificacion;
    private Evaluacion evaluacion;
    private PoliticaEntrega politicaEntrega; // Inner class

    // Constructor privado, solo accesible a través del Builder
    private Proveedor(Builder builder) {
        this.nombre = builder.nombre;
        this.certificacion = builder.certificacion;
        this.evaluacion = builder.evaluacion;
        this.politicaEntrega = builder.politicaEntrega;
    }

    // Getters para acceder a los atributos (opcional)
    public String getNombre() {
        return nombre;
    }

    public Certificacion getCertificacion() {
        return certificacion;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public PoliticaEntrega getPoliticaEntrega() {
        return politicaEntrega;
    }

    // Clase interna estática para la construcción
    public static class Builder {
        private String nombre;
        private Certificacion certificacion;
        private Evaluacion evaluacion;
        private PoliticaEntrega politicaEntrega;

        // Métodos del builder para configurar los atributos
        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this; // Devuelve el Builder para encadenar métodos
        }

        public Builder setCertificacion(Certificacion certificacion) {
            this.certificacion = certificacion;
            return this;
        }

        public Builder setEvaluacion(Evaluacion evaluacion) {
            this.evaluacion = evaluacion;
            return this;
        }

        public Builder setPoliticaEntrega(String descripcionPolitica) {
            this.politicaEntrega = new PoliticaEntrega(descripcionPolitica);
            return this;
        }

        // Método para construir finalmente un objeto Proveedor
        public Proveedor build() {
            return new Proveedor(this);
        }
    }


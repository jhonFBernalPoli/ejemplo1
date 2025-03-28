package co.edu.poli.ejemplo1.modelo;

import co.edu.poli.ejemplo1.servicio.GestorElementoDAO;

public class NequiAdapter implements PagoAdapter {
    private Nequi nequi;
    private Pago pago;
    private GestorElementoDAO ged;
    public NequiAdapter(Nequi nequi, Pago pago) {
        this.nequi = nequi;
        this.pago = pago;
    }

    @Override
    public void procesarPago(Pago pago) {
        
        ged.createElemento(pago);
        System.out.println("Nos fuimos por Nequi");
        throw new UnsupportedOperationException("Unimplemented method 'procesarPago'");
    }
}

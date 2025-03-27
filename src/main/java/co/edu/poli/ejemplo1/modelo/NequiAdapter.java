package co.edu.poli.ejemplo1.modelo;

import co.edu.poli.ejemplo1.servicio.GestorElementoDAO;

public class NequiAdapter implements PagoAdapter {
    private Nequi nequi;
    private Pago pago;

    public NequiAdapter(Nequi nequi, Pago pago) {
        this.nequi = nequi;
        this.pago = pago;
    }

    @Override
    public void procesarPago(Pago pago) {
        GestorElementoDAO ged = null;
        ged.createElemento(pago);

        throw new UnsupportedOperationException("Unimplemented method 'procesarPago'");
    }
}

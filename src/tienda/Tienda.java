package tienda;

import tienda.servicios.TiendaService;

/**
 *
 * @author Federico Picighelli
 */
public class Tienda {

    private static String nombre;

    public static void main(String[] args) throws Exception {

        TiendaService ts = new TiendaService();

        try {

            ts.menuTienda();

        } catch (Exception e) {
            throw e;
        }
    }

}

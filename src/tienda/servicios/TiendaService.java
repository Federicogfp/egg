package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;

/**
 *
 * @author Federico Picighelli
 */
public class TiendaService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    ProductoService ps = new ProductoService();
    FabricanteService fs = new FabricanteService();

    public void menuTienda() throws Exception {
        int opcion;
        System.out.println("\n****************** MENÚ ******************\n");

        System.out.println("1. Agregar Producto");
        System.out.println("2. Agregar Fabricante");
        System.out.println("3. Modificar producto");
        System.out.println("4. Lista de Productos");
        System.out.println("5. Lista de Productos y Precios");
        System.out.println("6. Lista de Productos con valor entre $120 y $202");
        System.out.println("7. Producto más Barato de la lista");
        System.out.println("8. Productos del tipo Portátil");
        System.out.println("9. Salir");
        do {
            System.out.print("\nELIJA UNA OPCIÓN: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    try {
                        System.out.println("\n*********** AGREGAR PRODUCTO ***********\n");
                        ps.crearProducto();
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 2:
                    System.out.println("\n*********** AGREGAR FABRICANTE ***********\n");
                    fs.crearFabricante();
                    break;
                case 3:
                    System.out.println("\n*********** MODIFICAR PRODUCTO ***********\n");
                    ps.modificarProducto();
                    break;
                case 4:
                    
                    System.out.println("\n*********** LISTA PRODUCTOS ***********\n");
                    try {
                        Collection<Producto> productos = ps.listaDeProductos();
                        if (productos.isEmpty()) {
                            throw new Exception("No existen productos para mostrar");
                        } else {
                            for (Producto p : productos) {
                                System.out.println(p);
                            }
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 5:
                    System.out.println("\n*********** PRODUCTOS y PRECIOS ***********\n");
                    try {
                        Collection<Producto> productos = ps.listaProductosPrecios();
                        if (productos.isEmpty()) {
                            throw new Exception("No existen productos para mostrar");
                        } else {
                            for (Producto p : productos) {
                                System.out.println(p);
                            }
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 6:
                    System.out.println("\n*********** PRODUCTOS CON PRECIO ENTRE $120 - $202 ***********\n");
                    try {
                        Collection<Producto> productos = ps.listaProductosBetween();
                        if (productos.isEmpty()) {
                            throw new Exception("No existen productos para mostrar");
                        } else {
                            for (Producto p : productos) {
                                System.out.println(p);
                            }
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 7:
                    System.out.println("\n*********** PRODUCTO ECONÓMICO ***********\n");
                    try {
                        Collection<Producto> productos = ps.productoBarato();
                        if (productos.isEmpty()) {
                            throw new Exception("No existen productos para mostrar");
                        } else {
                            for (Producto p : productos) {
                                System.out.println(p);
                            }
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 8:
                    System.out.println("\n*********** LISTA DE PORTÁTILES ***********\n");
                    try {
                        Collection<Producto> productos = ps.listaPortatiles();
                        if (productos.isEmpty()) {
                            throw new Exception("No existen productos para mostrar");
                        } else {
                            for (Producto p : productos) {
                                System.out.println(p);
                            }
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 9:
                    break;
                default:
                    System.out.println("\nOpción nó válida\n");
                    break;
            }
        } while (opcion != 9);
    }//Fin de clase tiendaservice

}

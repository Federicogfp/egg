

package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.persistencia.Fabricante_Dao;
import tienda.persistencia.Producto_Dao;

/**
 *
 * @author Federico Picighelli
 */
public class ProductoService {
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private Producto_Dao dao;
    private Fabricante_Dao dao1;
    private FabricanteService fs;

    public ProductoService() {
        this.dao = new Producto_Dao();
        this.dao1= new Fabricante_Dao();
    }
   
    //f) Ingresar un producto a la base de datos.
   public void crearProducto() throws Exception{
        
        System.out.print("\nIngrese código de producto: ");
        int codigo=sc.nextInt();
        System.out.print("\nIngrese el nombre del producto: ");
        String nombre=sc.next();
        System.out.print("\nIngrese el precio del producto: $");
        double precio=sc.nextDouble();
        System.out.print("\nIngrese código del fabricante: ");
        Integer cod = sc.nextInt();
        Fabricante f1 = fs.buscarPorId(cod);
        try {
            if(nombre==null || nombre.trim().isEmpty()){
                throw new Exception ("Debe ingresar un nombre de producto");
            }
            if(dao.buscarPorNombreProducto(nombre)!=null){
             throw new Exception("Ya existe un porducto con ese nombre");   
            }
            if(precio<=0){
                throw new Exception ("Debe ingresar un nombre de producto");
            }
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setFabricante(f1);
            
            dao.guardarProducto(producto);
            
        } catch (Exception e) {
            throw e;
        }
        
        
        
        
        
        
    }
    
    //a) Lista el nombre de todos los productos que hay en la tabla producto.
   public Collection<Producto> listaDeProductos() throws Exception{
       try {
           Collection<Producto>productos=dao.listaDeProductos();
           return productos;
       } catch (Exception e) {
           throw e;
       }
   }
   
    //b) Lista los nombres y los precios de todos los productos de la tabla producto.
   public Collection<Producto>listaProductosPrecios() throws Exception{
       try {
           Collection<Producto>productos=dao.listaDeProductos1();
           return productos;
       } catch (Exception e) {
           throw e;
       }
       
       
   }

    //c) Listar aquellos productos que su precio esté entre 120 y 202.
   public Collection<Producto>listaProductosBetween() throws Exception{
       try {
           Collection <Producto> productos = dao.listaDeProductos2();
           return productos;
       } catch (Exception e) {
           throw e;
       }
       
       
       
   }
   
    //h) Editar un producto con datos a elección.
   public void modificarProducto() throws Exception{
       System.out.print("\nIngrese el código del producto a modificar: ");
       int codigo = sc.nextInt();
       
       try {
           if (dao.buscarPorCodigoProducto(codigo)==null){
               throw new Exception ("Ingrese un código válido");
           }
           Producto p1= dao.buscarPorCodigoProducto(codigo);
           System.out.print("\nAhora ingrese el nuevo nombre: ");
           String nombre = sc.next();
           System.out.print("\nAhora coloque su precio: $");
           double precio = sc.nextDouble();
//           System.out.print("\nPor último indique el código del fabricante: ");
//           Integer codigof=sc.nextInt();
//           Fabricante f1= dao1.buscarPorId(codigof);
//           p1.getCodigo();
           p1.setNombre(nombre);
           p1.setPrecio(precio);
//           p1.setFabricante(f1);
           
           dao.modificarProducto(p1);
       } catch (Exception e) {
           throw e;
       }
   }
   
    //d) Buscar y listar todos los Portátiles de la tabla producto.
   public Collection<Producto>listaPortatiles() throws Exception{
       try {
           Collection<Producto>productos=dao.listadoPortatiles();
           return productos;
       } catch (Exception e) {
           throw e;
       }
       
       
       
       
   }
   
    //e) Listar el nombre y el precio del producto más barato.
   public Collection<Producto> productoBarato() throws Exception{
       try {
           Collection<Producto> productos = dao.productoEconomico();
           return productos;
       } catch (Exception e) {
           throw e;
       }
   }
   
   public void imprimirProductos(){
       
       
   }
}//fin servicio

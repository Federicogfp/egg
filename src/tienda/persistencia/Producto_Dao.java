package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.servicios.FabricanteService;

/**
 *
 * @author Federico Picighelli
 */
public final class Producto_Dao extends DAO {
    
    private final FabricanteService fs;

    public Producto_Dao() {
        this.fs = new FabricanteService();
    }
    
    
    //f) Ingresar un producto a la base de datos.
    public void guardarProducto(Producto p1) throws Exception {
        try {
            if (p1 == null) {
                throw new Exception("Debe indicar un producto");

            }
            String sql = "INSERT INTO Producto"
                    + " VALUES ( " + p1.getCodigo() + " , '" + p1.getNombre() + "' , " + p1.getPrecio() + " , " + p1.getFabricante().getCodigo() + " );";
            System.out.println(sql);
            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }

    }

    //h) Editar un producto con datos a elección.
    public void modificarProducto(Producto p1) throws Exception {
        try {
            if (p1 == null) { 
                throw new Exception("Debe indicar el producto a modificar");

            }
            String sql = "UPDATE Producto SET"
                    + " nombre = '" + p1.getNombre() + "' , Precio = " + p1.getPrecio()
                    + " WHERE codigo = " + p1.getCodigo();
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }

    }

    public void eliminarProducto(int codigo) throws Exception {
        try {

            String sql = "DELETE FROM Producto WHERE codigo = " + codigo;
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
    }

    public Producto buscarPorNombreProducto(String nombre) throws Exception {
        try {
            String sql = "SELECT * FROM Producto"
                    + " WHERE nombre = '" + nombre + "'";
            System.out.println(sql);
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                Integer codigo_fabricante=resultado.getInt(4);
                Fabricante fabricante = fs.buscarPorId(codigo_fabricante);
                producto.setFabricante(fabricante);
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public Producto buscarPorCodigoProducto(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM Producto"
                    + " WHERE codigo = '" + codigo + "'";
            System.out.println(sql);
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                Integer codigo_fabricante=resultado.getInt(4);
                Fabricante fabricante = fs.buscarPorId(codigo_fabricante);
                producto.setFabricante(fabricante);
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    //a) Lista el nombre de todos los productos que hay en la tabla producto.
    public Collection<Producto> listaDeProductos() throws Exception {
        try {
            String sql = "SELECT nombre FROM Producto";
            System.out.println(sql);
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error del sistema");
        }

    }

    //b) Lista los nombres y los precios de todos los productos de la tabla producto.
    public Collection<Producto> listaDeProductos1() throws Exception {
        try {
            String sql = "SELECT nombre,precio FROM Producto";
            System.out.println(sql);
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error del sistema");
        }

    }

    //c) Listar aquellos productos que su precio esté entre 120 y 202.
    public Collection<Producto> listaDeProductos2() throws Exception {
        try {
            String sql = "SELECT * FROM Producto" + " WHERE precio>120 AND precio<202";
            System.out.println(sql);
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                Integer codigo_fabricante=resultado.getInt(4);
                Fabricante fabricante = fs.buscarPorId(codigo_fabricante);
                producto.setFabricante(fabricante);
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error del sistema");
        }
    }

    //d) Buscar y listar todos los Portátiles de la tabla producto.
    public Collection<Producto> listadoPortatiles() throws Exception{
        try {
            String sql="SELECT * FROM Producto"
                    +" WHERE nombre LIKE '%Portátil%';";
            System.out.println(sql);
            consultarBase(sql);
            Producto producto = null;
            Collection <Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                Integer codigo_fabricante = resultado.getInt(4);
                Fabricante fabricante = fs.buscarPorId(codigo_fabricante);
                producto.setFabricante(fabricante);
                productos.add(producto); 
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    //e) Listar el nombre y el precio del producto más barato.
    public Collection<Producto> productoEconomico() throws Exception{
        try {
            String sql="SELECT nombre,precio FROM Producto"
                    +" ORDER BY precio asc "
                    +"LIMIT 1;";
            System.out.println(sql);
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto>productos = new ArrayList();
            while(resultado.next()){
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    } 

}//Fin de la clase



package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;

/**
 *
 * @author Federico Picighelli
 */
public class Fabricante_Dao extends DAO{
 
    //g) Ingresar un fabricante a la base de datos   
    public void guardarFabricante(Fabricante f1) throws Exception {
        try {
            if (f1 == null) {
                throw new Exception("Debe indicar un fabricante");

            }
            String sql = "INSERT INTO Fabricante"
                    + " VALUES ( " + f1.getCodigo() + " , '" + f1.getNombre() + "' );";
            System.out.println(sql);
            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }

    }
 
    public void modificarFabricante(Fabricante f1) throws Exception {
        try {
            if (f1 == null) {
                throw new Exception("Debe indicar el fabricante a modificar");

            }
            String sql = "UPDATE Fabricante SET"
                    + " Nombre = '" + f1.getNombre()
                    + " WHERE codigo = " + f1.getCodigo();
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminarFabricante(int codigo) throws Exception {
        try {

            String sql = "DELETE FROM Fabricante WHERE codigo = " + codigo;
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Fabricante> listaDeFabricantes() throws Exception {
        try {
            String sql = "SELECT * FROM Fabricante";
            System.out.println(sql);
            consultarBase(sql);
            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricantes.add(fabricante);
            }
            desconectarBase();
            return fabricantes;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error del sistema");
        }

    }

    public Fabricante buscarPorNombreFabricante(String nombre) throws Exception {
        try {
            String sql = "SELECT * FROM Fabricante"
                    + " WHERE nombre = '" + nombre + "'";
            System.out.println(sql);
            consultarBase(sql);
            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }

    }
    
    public Fabricante buscarPorId(Integer cod) throws Exception{
        try {
            String sql = "SELECT * FROM Fabricante"
                    + " WHERE codigo = " + cod;
            System.out.println(sql);
            consultarBase(sql);
            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante=new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
        
        
        
    }

}//Fin clase

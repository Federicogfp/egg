

package tienda.servicios;

import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.persistencia.Fabricante_Dao;

/**
 *
 * @author Federico Picighelli
 */
public class FabricanteService {
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private Fabricante_Dao dao;

    public FabricanteService() {
        this.dao = new Fabricante_Dao();
    }

    //g) Ingresar un fabricante a la base de datos 
    public Fabricante crearFabricante() throws Exception{
        
        System.out.print("\nIngrese código de fabricante: ");
        int codigo=sc.nextInt();
        System.out.print("\nIngrese el nombre del fabricante: ");
        String nombre=sc.next();
  
        try {
            if(nombre==null || nombre.trim().isEmpty()){
                throw new Exception ("Debe ingresar un nombre de fabricante");
            }
            if(dao.buscarPorNombreFabricante(nombre)!=null){
             throw new Exception("Ya existe un fabricante con ese nombre");   
            }
            
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);
            
            dao.guardarFabricante(fabricante);
            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Fabricante buscarPorId(Integer cod) throws Exception {
        
        try {
            if (cod == null) {
                throw new Exception("Debe indicar el codigo del fabricante");
            }
            Fabricante fabricante = dao.buscarPorId(cod);
            return fabricante;
               
        } catch (Exception e) {
            throw e;
        }

    }
   
}//fin de clase service 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


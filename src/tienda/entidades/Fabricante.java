

package tienda.entidades;

/**
 *
 * @author Federico Picighelli
 */
public class Fabricante {
private int codigo;
private String nombre;

    public Fabricante() {
    }

    public Fabricante(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-15s%-15s",codigo,nombre);
    }


        
        




}

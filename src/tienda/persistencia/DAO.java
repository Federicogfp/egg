package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Federico Picighelli
 */
public abstract class DAO {

    protected Connection conexion = null;
    protected Statement st = null;
    protected ResultSet resultado = null;

    private final String user = "root";
    private final String password = "root";
    private final String database = "tienda";
    private final String driver = "com.mysql.cj.jdbc.Driver";

    protected void conectarBase() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(driver);
            String urlBase = "jdbc:mysql://localhost:3306/" + database + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBase, user, password);

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    protected void desconectarBase() throws Exception {
        try {
            if (conexion != null) {
                conexion.close();
            }
            if (st != null) {
                st.close();
            }
            if (resultado != null) {
                resultado.close();
            }
        } catch (SQLException e) {
            throw e;
        }

    }

    protected void consultarBase(String sql) throws Exception {
        try {
            conectarBase();
            st = conexion.createStatement();
            resultado = st.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;

        }

    }

    protected void insertarModificarEliminar(String sql) throws ClassNotFoundException, SQLException, Exception {
        try {
            conectarBase();
            st = conexion.createStatement();
            st.executeUpdate(sql);

        } catch (ClassNotFoundException | SQLException e) {
            conexion.rollback();
            throw e;
        } finally {
            desconectarBase();
        }

    }
}

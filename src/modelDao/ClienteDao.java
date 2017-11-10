package modelDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.Conexion;
import model.Cliente;


public class ClienteDao {
	public static final String SQL_INGRESAR=
			"INSERT INTO Cliente (Persona_perId,cliTelefono,created_at)"
			+ " VALUES (?,?,?)";
	public static final String SQL_ACTUALIZAR=
			"UPDATE Cliente SET cliTelefono = ? WHERE Persona_perId = ?";
	public static final String SQL_ELIMINAR=
			"DELETE FROM Cliente WHERE Persona_perId=? ";
	public static final Conexion cnn=Conexion.saberEstado();
	
	public boolean ingresar(Cliente c) {
    	Date fechaActual = new Date(System.currentTimeMillis());
    	SimpleDateFormat dia = new SimpleDateFormat("yyyy-MM-dd");
    	SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
        PreparedStatement ps;
        int bandera;
        try {
            ps=cnn.getCnn().prepareStatement(SQL_INGRESAR);
            ps.setInt(1, c.getPerId());
            ps.setInt(2, c.getCliTelefono());
            ps.setString(3, dia.format(fechaActual)+" "+hora.format(fechaActual));
            System.out.println(ps.toString());
            bandera=ps.executeUpdate();
            if(bandera > 0){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al momento de Ingresar Cliente");
        }finally{
            cnn.cerrarConexion();
        }
        return false;
        }
    public boolean actualizar(Cliente c) {
    	PreparedStatement ps;
    	int bandera;
    	try {
    		ps=cnn.getCnn().prepareStatement(SQL_ACTUALIZAR);
    		ps.setInt(1,c.getCliTelefono());
    		ps.setInt(2, c.getPerId());
    		System.out.println(ps.toString());
    		bandera=ps.executeUpdate();
    		if (bandera>0) {
				return true;
			}
    	}catch (SQLException ex) {
    		System.out.println("Error al Actualizar Cliente");
		}finally {
			cnn.cerrarConexion();
		}
    	return false;
        }
    public boolean eliminar(Cliente c) {
    	PreparedStatement ps;
    	int bandera;
    	try {
    		ps=cnn.getCnn().prepareStatement(SQL_ELIMINAR);
    		ps.setInt(1, c.getPerId());
    		System.out.println(ps.toString());
    		bandera=ps.executeUpdate();
    		if (bandera>0) {
    			return true;
    		}
    	}catch (SQLException ex) {
			System.out.println("Error Al Eliminar Cliente");
		}finally {
			cnn.cerrarConexion();
		}
    	return false;
    }

}

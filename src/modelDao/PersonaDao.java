package modelDao;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.Conexion;
import model.Persona;

public class PersonaDao {

    private static final String SQL_INGRESAR=
            "INSERT INTO Persona(perNombre,perApellidoPaterno,perApellidoMaterno,perFechaNacimiento,created_at)"
            + " VALUES (?,?,?,?,?);";
    private static final String SQL_ACTUALIZAR=
            "UPDATE Persona SET perNombre = ?, perApellidoPaterno = ?, perApellidoMaterno = ?, perFechaNacimiento = ?"
            + " WHERE perId = ?";
    private static final String SQL_ELIMINAR=
    		"DELETE FROM Persona WHERE perId=?";
    private static final Conexion cnn=Conexion.saberEstado();
	
    public boolean ingresar(Persona p) {
    	Date fechaActual = new Date(System.currentTimeMillis());
    	SimpleDateFormat dia = new SimpleDateFormat("yyyy-MM-dd");
    	SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
        PreparedStatement ps;
        int bandera;
        try {
            ps=cnn.getCnn().prepareStatement(SQL_INGRESAR);
            ps.setString(1, p.getPerNombre());
            ps.setString(2, p.getPerApellidoPaterno());
            ps.setString(3, p.getPerApellidoMaterno());
            ps.setString(4, p.getPerFechaNacimiento());
            ps.setString(5, dia.format(fechaActual)+" "+hora.format(fechaActual));
            bandera=ps.executeUpdate();
            if(bandera > 0){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al momento de Ingresar Persona");
        }finally{
            cnn.cerrarConexion();
        }
        return false;
    }
    
    public boolean actualizar(Persona x) {
        PreparedStatement ps;
        int bandera;
        try {
            ps=cnn.getCnn().prepareStatement(SQL_ACTUALIZAR);
            ps.setString(1,x.getPerNombre());
            ps.setString(2,x.getPerApellidoPaterno());
            ps.setString(3,x.getPerApellidoMaterno());
            ps.setString(4,x.getPerFechaNacimiento());
            ps.setInt(5, x.getPerId());
            System.out.println(ps.toString());
            bandera=ps.executeUpdate();
            if(bandera>0){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al modifiar a la Persona");
        }finally{
            cnn.cerrarConexion();
        }
        return false;
    }
    
    public boolean eliminar(Persona x) {
    	PreparedStatement ps;
    	int bandera;
    	try {
    		ps=cnn.getCnn().prepareStatement(SQL_ELIMINAR);
    		ps.setInt(1,x.getPerId());
    		bandera=ps.executeUpdate();
    		if(bandera>0) {
    			return true;
    		}
    	} catch (SQLException ex) {
    		System.out.println("Error al eliminar a la persona");
    	}finally {
    		cnn.cerrarConexion();
    	}
    	return false;
    }
    	
    
}

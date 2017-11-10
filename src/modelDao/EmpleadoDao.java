package modelDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.Conexion;
import model.Empleado;


public class EmpleadoDao {
	    private static final String SQL_INGRESAR=
	            "INSERT INTO Empleado(Persona_perID,empSueldoBRuto,created_at)"
	            + " VALUES (?,?,?);";
	    private static final String SQL_ACTUALIZAR=
	            "UPDATE Empleado SET empSueldoBruto = ?"
	            + " WHERE Persona_perID = ?";
	    private static final String SQL_ELIMINAR=
	    		"DELETE FROM Empleado WHERE Persona_perId=?";
	    
	    private static final Conexion cnn=Conexion.saberEstado();
	    
	    public boolean ingresar(Empleado e) {
	    	Date fechaActual = new Date(System.currentTimeMillis());
	    	SimpleDateFormat dia = new SimpleDateFormat("yyyy-MM-dd");
	    	SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
	        PreparedStatement ps;
	        int bandera;
	        try {
	            ps=cnn.getCnn().prepareStatement(SQL_INGRESAR);
	            ps.setInt(1, e.getPerId());
	            ps.setInt(2, e.getEmpSueldoBruto());
	            ps.setString(3, dia.format(fechaActual)+" "+hora.format(fechaActual));
	            System.out.println(ps.toString());
	            bandera=ps.executeUpdate();
	            if(bandera > 0){
	                return true;
	            }
	        } catch (SQLException ex) {
	            System.out.println("Error al momento de Ingresar Empleado");
	        }finally{
	            cnn.cerrarConexion();
	        }
	        return false;
	        }
	    public boolean actualizar(Empleado e) {
	    	PreparedStatement ps;
	    	int bandera;
	    	try {
	    		ps=cnn.getCnn().prepareStatement(SQL_ACTUALIZAR);
	    		ps.setInt(1,e.getEmpSueldoBruto());
	    		ps.setInt(2, e.getPerId());
	    		System.out.println(ps.toString());
	    		bandera=ps.executeUpdate();
	    		if (bandera>0) {
					return true;
				}
	    	}catch (SQLException ex) {
	    		System.out.println("Error al Actualizar Empleado");
			}finally {
				cnn.cerrarConexion();
			}
	    	return false;
	        }
	    public boolean eliminar(Empleado e) {
	    	PreparedStatement ps;
	    	int bandera;
	    	try {
	    		ps=cnn.getCnn().prepareStatement(SQL_ELIMINAR);
	    		ps.setInt(1, e.getPerId());
	    		System.out.println(ps.toString());
	    		bandera=ps.executeUpdate();
	    		if (bandera>0) {
	    			return true;
	    		}
	    	}catch (SQLException ex) {
				System.out.println("Error Al Eliminar Empleado");
			}finally {
				cnn.cerrarConexion();
			}
	    	return false;
	    }
	}


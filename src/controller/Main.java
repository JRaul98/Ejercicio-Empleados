package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Empleado;
import model.Persona;
import modelDao.EmpleadoDao;
import modelDao.PersonaDao;

public class Main {

	public static void main(String[] args) {
		Persona personita1=new Persona();
		Empleado empleado1=new Empleado();
		EmpleadoDao empDao=new EmpleadoDao();
		PersonaDao perDao=new PersonaDao();
		String n="",a="",id="",s="",f;
		
		Object [] opciones=new Object[] {"1.- Ingresar Persona", "2.- Modificar Persona","3.- Eliminar Persona",
				"4.- Registrar Empleado","5.- Actualizar Datos de Empleados","6.- Eliminar Empleado"};
		Object seleccion = JOptionPane.showInputDialog(
				   null, "Seleccione una opcion", "Sistema de Empleados",
				   JOptionPane.QUESTION_MESSAGE, null,opciones,"1.- Ingresar Persona");
		
		switch (String.valueOf(seleccion).charAt(0)) {
			case '1':
				//INGRESO DE VALORES
				while(n.equals("")) {
					n=JOptionPane.showInputDialog("Ingrese el Nombre de la Persona");
				}
				personita1.setPerNombre(n);
				while(a.equals("")) {
					a=JOptionPane.showInputDialog("Ingrese los Apellidos de la Persona");
				}
				personita1.setPerApellido(a);
				
				f=JOptionPane.showInputDialog("Ingrese la Fecha de Nacimiento ej. 2000-12-31");
				personita1.setPerFechaNacimiento(f);
	
				if(perDao.ingresar(personita1)) {
					JOptionPane.showMessageDialog(null, "Persona ingresada con Exito");
				}else {
					JOptionPane.showMessageDialog(null, "Persona NO ingresada");
				}
				break;
			case '2':
				id=JOptionPane.showInputDialog("Ingrese el Id de la Persona a Modificar");
				n=JOptionPane.showInputDialog("Ingrese el Nombre de la Persona");
				a=JOptionPane.showInputDialog("Ingrese los Apellidos de la Persona");
				f=JOptionPane.showInputDialog("Ingrese la Fecha de Nacimiento ej. 1900-05-31");
				personita1.setPerId(Integer.parseInt(id));
				personita1.setPerNombre(n);
				personita1.setPerApellido(a);
				personita1.setPerFechaNacimiento(f);
				if(perDao.actualizar(personita1)){
					JOptionPane.showMessageDialog(null, "Persona Actualizada con Exito");
				}else {
					JOptionPane.showMessageDialog(null, "Persona NO actualizada");
				}
				break;
			case '3':
				id=JOptionPane.showInputDialog("Ingrese la id de la Persona a Eliminar");
				personita1.setPerId(Integer.parseInt(id));
			if (perDao.eliminar(personita1)) {
				JOptionPane.showMessageDialog(null, "Persona eliminada con exito");
			} else {
				JOptionPane.showMessageDialog(null, "Persona no eliminada con exito");
			}
			break;
			case '4':
				id=JOptionPane.showInputDialog("Ingrese la ID de la Persona existente");
				s=JOptionPane.showInputDialog("Ingrese el Sueldo del Empleado");
				empleado1.setPerId(Integer.parseInt(id));
				empleado1.setEmpSueldoBruto(Integer.parseInt(s));
				if (empDao.ingresar(empleado1)) {
					JOptionPane.showMessageDialog(null, "Sueldo Ingresado con Exito");
				} else {
					JOptionPane.showMessageDialog(null, "Sueldo no Ingresado con Exito");
				}
				break;
			case '5':
				id=JOptionPane.showInputDialog("Ingrese la Id del Empleado");
				s=JOptionPane.showInputDialog("Ingrese El Sueldo del Empleado");
				empleado1.setPerId(Integer.parseInt(id));
				empleado1.setEmpSueldoBruto(Integer.parseInt(s));
				if (empDao.actualizar(empleado1)) {
					JOptionPane.showMessageDialog(null, "Sueldo Actualizado con exito ");
				} else {
					JOptionPane.showMessageDialog(null, "Sueldo NO Acutalizado con exito");
				}
				break;
			case '6':
				id=JOptionPane.showInputDialog("Ingrese la id de la Persona a Eliminar");
				empleado1.setPerId(Integer.parseInt(id));
				if(empDao.eliminar(empleado1)) {
					JOptionPane.showMessageDialog(null, "Empleado Eliminada con Exito");
				}else {
					JOptionPane.showMessageDialog(null, "Empleado no Eliminada");
				}		
		default:
			System.out.println("Opcion no valida.");
			break;
		}
	
		
		
		
		
		

	}

}

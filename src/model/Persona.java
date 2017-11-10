package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {
	protected int perId;
	protected String perNombre;
	protected String perApellidoPaterno;
	protected String perApellidoMaterno;
	protected String perFechaNacimiento;
	
	public Persona() {
	}
	
	public Persona(int perId, String perNombre, String perApellidoPaterno, String perApellidoMaterno,
			String perFechaNacimiento) {
		this.perId = perId;
		this.perNombre = perNombre;
		this.perApellidoPaterno = perApellidoPaterno;
		this.perApellidoMaterno = perApellidoMaterno;
		this.perFechaNacimiento = perFechaNacimiento;
	}

	public int getPerId() {
		return perId;
	}

	public void setPerId(int perId) {
		this.perId = perId;
	}

	public String getPerNombre() {
		return perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre.toLowerCase();
	}

	public String getPerApellidoPaterno() {
		return perApellidoPaterno;
	}
	
	public void setPerApellido(String perApellido){
		String aPaterno, aMaterno;
		if(perApellido.matches(".* .*")){
			String [] campos = perApellido.split("\\s");
			aPaterno = campos[0];
			aMaterno = campos[1];
		}else {
			aPaterno=perApellido;
			aMaterno=" ";
		}
		this.setPerApellidoPaterno(aPaterno);
		this.setPerApellidoMaterno(aMaterno);
	}

	public void setPerApellidoPaterno(String perApellidoPaterno) {
		this.perApellidoPaterno = perApellidoPaterno.toLowerCase();
	}

	public String getPerApellidoMaterno() {
		return perApellidoMaterno;
	}

	public void setPerApellidoMaterno(String perApellidoMaterno) {
		this.perApellidoMaterno = perApellidoMaterno.toLowerCase();
	}

	public String getPerFechaNacimiento() {
		return perFechaNacimiento;
	}

	public void setPerFechaNacimiento(String perFechaNacimiento) {
		String dia,mes,anno;
		Date fechaActual = new Date(System.currentTimeMillis());
    	SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy-MM-dd");
		String [] fecha = perFechaNacimiento.split("-");
		try {
			anno = fecha[0];
			mes = fecha[1];
			dia = fecha[2];		
			if(Integer.parseInt(anno)>1990) {
				this.perFechaNacimiento=anno+"-"+mes+"-"+dia;
			}
		}
		catch(Exception ex) {
			System.out.println("Error al Ingresar la Fecha de Nacimiento");
			this.perFechaNacimiento=formatFecha.format(fechaActual);
		}
	}

	@Override
	public String toString() {
		return "Persona [perId=" + perId + ", perNombre=" + perNombre + ", perApellidoPaterno=" + perApellidoPaterno
				+ ", perApellidoMaterno=" + perApellidoMaterno + ", perFechaNacimiento=" + perFechaNacimiento + "]";
	}
	
}

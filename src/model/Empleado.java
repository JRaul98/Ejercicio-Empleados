package model;

public class Empleado extends Persona {
	protected int empSueldoBruto;

	public Empleado() {
		super();
	}

	public Empleado(int perId, String perNombre, String perApellidoPaterno, String perApellidoMaterno,
			String perFechaNacimiento, int empSueldoBruto) {
		super(perId, perNombre, perApellidoPaterno, perApellidoMaterno, perFechaNacimiento);
		this.empSueldoBruto = empSueldoBruto;
	}

	public int getEmpSueldoBruto() {
		return empSueldoBruto;
	}

	public void setEmpSueldoBruto(int empSueldoBruto) {
		this.empSueldoBruto = empSueldoBruto;
	}

	@Override
	public String toString() {
		return "Empleado [empSueldoBruto=" + empSueldoBruto + ", perId=" + perId + ", perNombre=" + perNombre
				+ ", perApellidoPaterno=" + perApellidoPaterno + ", perApellidoMaterno=" + perApellidoMaterno
				+ ", perFechaNacimiento=" + perFechaNacimiento + "]";
	}		
}

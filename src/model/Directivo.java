package model;

public class Directivo extends Empleado {
	private String dirCategoria;

	public Directivo() {
		super();
	}

	public Directivo(int perId, String perNombre, String perApellidoPaterno, String perApellidoMaterno,
			String perFechaNacimiento, int empSueldoBruto, String dirCategoria) {
		super(perId, perNombre, perApellidoPaterno, perApellidoMaterno, perFechaNacimiento, empSueldoBruto);
		this.dirCategoria = dirCategoria;
	}

	public String getDirCategoria() {
		return dirCategoria;
	}

	public void setDirCategoria(String dirCategoria) {
		this.dirCategoria = dirCategoria;
	}

	@Override
	public String toString() {
		return "Directivo [dirCategoria=" + dirCategoria + ", empSueldoBruto=" + empSueldoBruto + ", perId=" + perId
				+ ", perNombre=" + perNombre + ", perApellidoPaterno=" + perApellidoPaterno + ", perApellidoMaterno="
				+ perApellidoMaterno + ", perFechaNacimiento=" + perFechaNacimiento + "]";
	}
}

package model;

public class Cliente extends Persona {
	private int cliTelefono;

	public Cliente() {
		super();
	}

	public Cliente(int perId, String perNombre, String perApellidoPaterno, String perApellidoMaterno,
			String perFechaNacimiento, int cliTelefono) {
		super(perId, perNombre, perApellidoPaterno, perApellidoMaterno, perFechaNacimiento);
		this.cliTelefono = cliTelefono;
	}


	public int getCliTelefono() {
		return cliTelefono;
	}

	public void setCliTelefono(int cliTelefono) {
		this.cliTelefono = cliTelefono;
	}

	@Override
	public String toString() {
		return "Cliente [cliTelefono=" + cliTelefono + ", perId=" + perId + ", perNombre=" + perNombre
				+ ", perApellidoPaterno=" + perApellidoPaterno + ", perApellidoMaterno=" + perApellidoMaterno
				+ ", perFechaNacimiento=" + perFechaNacimiento + "]";
	}
	
}

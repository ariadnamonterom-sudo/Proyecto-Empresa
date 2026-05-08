package dominio;

public class Usuario {
	private String nombre;
	private String correo;
	private String constrasenia;
	
	public Usuario(String nombre, String correo, String constrasenia) {
		this.nombre = nombre;
		this.correo = correo;
		this.constrasenia = constrasenia;
	}
	
	public void inscribirEvento(Evento evento) {
		
	}
	
	public void cancelarInscripcion(Evento evento) {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getConstrasenia() {
	    return constrasenia;
	}
	

	public void setContrasenia(String constrasenia) {
		this.constrasenia = constrasenia;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", correo=" + correo + ", contrasenia=" + constrasenia + "]";
	}
	
	
	
}

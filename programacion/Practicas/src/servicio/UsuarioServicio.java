package servicio;

import java.util.Scanner;

import dominio.Usuario;
import persistencia.UsuarioDao;

public class UsuarioServicio implements IUsuarioServicio {
	private final Scanner sc;
	private UsuarioDao usuarioDao;
	
	public UsuarioServicio(Scanner sc) {
		this.sc = sc;
		this.usuarioDao = new UsuarioDao();
	}
	
	@Override
	    public Usuario hacerLogin() {
		
	        System.out.println("Introduce el nombre de usuario");
	        String nombre = sc.nextLine();
	        
	        System.out.println("Introduce la contraseña");
	        String contrasenia = sc.nextLine();

	        Usuario usuario = usuarioDao.login(nombre, contrasenia);
	        if (usuario == null) {
	            System.out.println("Nombre o contraseña incorrectos");
	        }
	        return usuario;
	    }

    @Override
    public void registrarUsuario() {
        System.out.println("Introduce el nombre");
        String nombre = sc.nextLine();
        System.out.println("Introduce el correo");
        String correo = sc.nextLine();
        
        System.out.println("Introduce la contraseña");
        String contrasenia = sc.nextLine();

        Usuario usuario = new Usuario(nombre, correo, contrasenia);
        
        if (usuarioDao.registrar(usuario)) {
            System.out.println("Usuario registrado");
        } else {
            System.out.println("el usuario ya existe");
        }
    }
}
    


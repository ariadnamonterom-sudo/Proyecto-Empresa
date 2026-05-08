package servicio;

import java.util.Scanner;

import dominio.Organizador;
import persistencia.OrganizadorDao;

public class OrganizadorServicio implements IOrganizadorServicio{
	private final Scanner sc;
	private OrganizadorDao organizadorDao;
	
	public OrganizadorServicio(Scanner sc) {
		this.sc = sc;
		this.organizadorDao = new OrganizadorDao();
	}
	
	@Override
    public Organizador hacerLogin() {
        System.out.println("Introduce el nombre de organizador");
        String nombre = sc.nextLine();
        System.out.println("Introduce la contraseña");
        String contrasenia = sc.nextLine();

        Organizador organizador = organizadorDao.login(nombre, contrasenia);
        if (organizador == null) {
            System.out.println("Nombre o contraseña incorrectos");
        }
        return organizador;
    }
	
	@Override
    public void registrarOrganizador() {
        System.out.println("Introduce el nombre");
        String nombre = sc.nextLine();
        System.out.println("introduce el correo");
        String correo = sc.nextLine();
        System.out.println("introduce la contraseña");
        String contrasenia = sc.nextLine();
        System.out.println("Introduce el telefono");
        String telefono = sc.nextLine();
        
        Organizador organizador = new Organizador(nombre, correo, contrasenia, telefono);
        
        if (organizadorDao.registrar(organizador)) {
            System.out.println("organizador registrado");
            
        } else {
            System.out.println("el nombre de organizador ya existe.");
        }
    }
       
}

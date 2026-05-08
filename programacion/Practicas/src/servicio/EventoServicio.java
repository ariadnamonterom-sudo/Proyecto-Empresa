package servicio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Scanner;

import dominio.Categoria;
import dominio.Evento;
import dominio.Organizador;
import dominio.Usuario;
import persistencia.CategoriaDao;
import persistencia.EventoDao;
import util.Util;

public class EventoServicio implements IEventoServicio{
	private final Scanner sc;
	private EventoDao eventoDao;
	private CategoriaDao categoriaDao;
	
	public EventoServicio(Scanner sc) {
		this.sc = sc;
		this.eventoDao = new EventoDao();
		this.categoriaDao = new CategoriaDao();
	}
	
	 @Override
	    public void mostrarEventos() {
	        HashMap<String, Evento> eventos = eventoDao.obtenerEventos();
	        if (eventos.isEmpty()) {
	            System.out.println("no hay eventos disponibles");
	            return;
	        }
	  
	        for (Evento e : eventos.values()) {
	            System.out.println(e);
	        } 
	    }
	 
	 @Override
	    public void mostrarEventosUsuario(Usuario usuario) {
	        HashMap<String, Evento> eventos = eventoDao.obtenerEventos();
	        
	        boolean Eventos = false;
	        for (Evento e : eventos.values()) {
	            if (e.getAsistentes().contains(usuario)) {
	                System.out.println(e);
	                Eventos = true;
	            }
	        }
	        if (!Eventos) {
	            System.out.println("no estas inscrito en ningun evento");
	        }
	    }
	 
	 @Override
	    public void inscribirUsuario(Usuario usuario) {
	        mostrarEventos();
	        
	        System.out.print("\nIntroduce el nombre del evento ");
	        String nombre = sc.nextLine();
	        Evento e = eventoDao.obtenerEventos().get(nombre);
	        
	        if (e != null) {
	           
	            if (e.getAsistentes().add(usuario)) {
	                System.out.println("Inscripción hecha");
	            } else {
	                System.out.println("ya estabas inscrito");
	            }
	        } else {
	            System.out.println("elevento no existe");
	        }
	    }
	 
	 @Override
	    public void cancelarInscripcion(Usuario usuario) {
	        System.out.print("\nIntroduce el nombre del evento que quieres cancelar");
	        String nombre = sc.nextLine();
	        
	        Evento e = eventoDao.obtenerEventos().get(nombre);
	        
	        if (e != null && e.getAsistentes().remove(usuario)) {
	            System.out.println("inscripción anulada");
	        } else {
	            System.out.println("no existe");
	        }
	    }
	 @Override
	    public void mostrarEventosOrganizador(Organizador organizador) {
	        HashMap<String, Evento> eventos = eventoDao.obtenerEventos();
	        boolean Eventos= false;
	        for (Evento e : eventos.values()) {
	            if (e.getOrganizador() != null && e.getOrganizador().getNombre().equals(organizador.getNombre())) {
	                System.out.println(e);
	                Eventos= true;
	            }
	        }
	        if (!Eventos) {
	            System.out.println("No tienes eventos creados.");
	        }
	    }
	 @Override
	    public void crearEvento(Organizador organizador) {
	        System.out.println("Nombre del evento");
	        String nombre = sc.nextLine();
	        
	        System.out.println("Descripción");
	        String descripcion = sc.nextLine();
	        
	        System.out.println("Fecha");
	        LocalDate fecha = LocalDate.parse(sc.nextLine());
	        
	        System.out.println("hora");
	        LocalTime hora = LocalTime.parse(sc.nextLine());
	        
	        int duracion = Util.pedirNumeroEntero(sc, "Duracion");
	        System.out.println("Ubicación:");
	        String ubicacion = sc.nextLine();
	        
	        System.out.println("Categorias disponibles" + categoriaDao.obtenerCategorias().keySet());
	        System.out.print("escribe el nombre de la categoria ");
	        String nombreCategoria = sc.nextLine();
	        Categoria categoria = categoriaDao.obtenerCategoria(nombreCategoria);
	        
	        if (categoria != null) {
	            Evento evento = new Evento(nombre, descripcion, fecha, hora, duracion, ubicacion, categoria, organizador);
	            
	            if (eventoDao.insertarEvento(evento)) {
	                System.out.println("evento creado");
	            } else {
	                System.out.println("ya existe un evento con ese nombre");
	            }
	        } else {
	            System.out.println("la categora no existe");
	        }
	 }
}

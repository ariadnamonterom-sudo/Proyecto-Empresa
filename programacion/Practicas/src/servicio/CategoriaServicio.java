package servicio;


import java.util.Scanner;

import dominio.Categoria;
import persistencia.CategoriaDao;

public class CategoriaServicio implements ICategoriaServicio{
	private final Scanner sc;
	private CategoriaDao categoriaDao;
	
	public CategoriaServicio(Scanner sc) {
		this.sc = sc;
		this.categoriaDao = new CategoriaDao();
	}
	
	public Categoria buscarCategoria() {
        for (String nombreCategoria : categoriaDao.obtenerCategorias().keySet()) {
            System.out.println(nombreCategoria);
        }
        
        System.out.print("Inserta el nombre de la categoria");
        String nombre = sc.nextLine();
        
        Categoria categoriaEventos = categoriaDao.obtenerCategoria(nombre);
        
        if (categoriaEventos == null) {
            System.out.println("La categoría no existe");
        }

        return categoriaEventos;
    }
        
}

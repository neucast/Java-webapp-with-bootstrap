package com.ecodeup.estudiante.dao;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.ecodeup.estudiante.model.Estudiante;
import com.ecodeup.estudiante.service.ListaEstudiante;

/*
 * @autor: Elivar Largo
 * @web: www.ecodeup.com
 */

public class EstudianteDAO {

	List<Estudiante> listaEstudiantes = ListaEstudiante.getListaEstudiante();

	public List<Estudiante> obtenerEstudiantes() {
		return listaEstudiantes;
	}

	public List<Estudiante> buscarPorNombre(String nombre) {
		Comparator<Estudiante> groupByComparator = Comparator.comparing(Estudiante::getNombre)
				.thenComparing(Estudiante::getApellido);
		List<Estudiante> result = listaEstudiantes.stream()
				.filter(e -> e.getNombre().equalsIgnoreCase(nombre) || e.getApellido().equalsIgnoreCase(nombre))
				.sorted(groupByComparator).collect(Collectors.toList());
		return result;
	}

	public Estudiante obtenerEmpleado(long id) throws Exception {
		Optional<Estudiante> match = listaEstudiantes.stream().filter(e -> e.getId() == id).findFirst();
		if (match.isPresent()) {
			return match.get();
		} else {
			throw new Exception("El estudiante con ID: " + id + " no fue econtrado");
		}
	}

	public long guardarEstudiante(Estudiante estudiante) {
		listaEstudiantes.add(estudiante);
		return estudiante.getId();
	}

	public boolean actualizarEstudiante(Estudiante estudiante) {
		int idActualizar = 0;
		Optional<Estudiante> estudianteEncontrado = listaEstudiantes.stream().filter(c -> c.getId() == estudiante.getId()).findFirst();
		if (estudianteEncontrado.isPresent()) {
			idActualizar = listaEstudiantes.indexOf(estudianteEncontrado.get());
			listaEstudiantes.set(idActualizar, estudiante);
			return true;
		} else {
			return false;
		}
	}

	public boolean eliminarEstudiante(long id) {
		Predicate<Estudiante> estudiante = e -> e.getId() == id;
		if (listaEstudiantes.removeIf(estudiante)) {
			return true;
		} else {
			return false;
		}
	}

}

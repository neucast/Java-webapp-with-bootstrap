package com.ecodeup.estudiante.model;

import java.util.concurrent.atomic.AtomicLong;

public class Estudiante {
	private long id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String carrera;
    private String semestre;
    private String email;
    private static final AtomicLong contador = new AtomicLong(100);
    
	public Estudiante(long id, String nombre, String apellido, String fechaNacimiento, String carrera, String semestre,
			String email) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.carrera = carrera;
		this.semestre = semestre;
		this.email = email;
	}
	public Estudiante(String nombre, String apellido, String fechaNacimiento, String carrera, String semestre,
			String email) {
		this.id = contador.incrementAndGet();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.carrera = carrera;
		this.semestre = semestre;
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

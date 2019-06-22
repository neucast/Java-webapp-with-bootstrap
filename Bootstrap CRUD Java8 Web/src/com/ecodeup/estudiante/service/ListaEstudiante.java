package com.ecodeup.estudiante.service;
import java.util.ArrayList;
import java.util.List;

import com.ecodeup.estudiante.model.*;;

public class ListaEstudiante {
private static final List<Estudiante> listaEstudiante = new ArrayList();
    
    private ListaEstudiante(){
    }
    
    static{
        listaEstudiante.add(new Estudiante("Luis","Andrade","12-12-1980","Ing. en Sistemas","Cuarto","landrade@gmail.com"));
        listaEstudiante.add(new Estudiante("Laura","Vasquez","02-11-1979","Educación","Segundo","lvasquez@gmail.com"));
        listaEstudiante.add(new Estudiante("Pedro","Toro","22-10-1966","Contabilidad","Primero","ptoro@gmail.com"));
        listaEstudiante.add(new Estudiante("Johana","Salcedo","11-11-1976","Administración","Segundo","jsalcedo@gmail.com"));
        listaEstudiante.add(new Estudiante("John","Pilco","18-08-1988","Medicina","Sexto","jpilco@gmail.com"));
        listaEstudiante.add(new Estudiante("Samuel","Pardo","22-03-1985","Educación","Primer","spardo@gmail.com"));
    }
    
    public static List <Estudiante> getListaEstudiante(){
        return listaEstudiante;
    }

}

package com.ecodeup.estudiante.controller;

import com.ecodeup.estudiante.dao.EstudianteDAO;
import com.ecodeup.estudiante.model.Estudiante;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class EstudianteServlet
 */
@WebServlet(name = "EstudianteServlet", urlPatterns = { "/estudiante" })
public class EstudianteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EstudianteDAO estudianteDAO = new EstudianteDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EstudianteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String action = request.getParameter("buscarAction");
		System.out.println(action);
		if (action != null) {
			switch (action) {
			case "buscarPorId":
				buscarPorId(request, response);
				break;
			case "buscarPorNombre":
				buscarPorNombre(request, response);
				break;
			case "nuevo":
				nuevoEstudiante(request, response);
				break;
			}
		} else {
			List<Estudiante> result = estudianteDAO.obtenerEstudiantes();
			mostrarListaEstudiantes(request, response, result);
		}
	}

	private void buscarPorId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long idEstudiante = Integer.valueOf(req.getParameter("idEstudiante"));
		Estudiante estudiante = null;
		try {
			estudiante = estudianteDAO.obtenerEmpleado(idEstudiante);
		} catch (Exception ex) {
			Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
		req.setAttribute("estudiante", estudiante);
		req.setAttribute("action", "actualizar");
		String paginaJSP = "/vista/nuevo-estudiante.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(req, resp);
	}
	
	private void nuevoEstudiante(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("action", "");
		String paginaJSP = "/vista/nuevo-estudiante.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(req, resp);
	}

	private void buscarPorNombre(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nombreEstudiante = req.getParameter("nombreEstudiante");
		List<Estudiante> result = estudianteDAO.buscarPorNombre(nombreEstudiante);
		mostrarListaEstudiantes(req, resp, result);
	}

	private void mostrarListaEstudiantes(HttpServletRequest req, HttpServletResponse resp, List listaEstudiantes)
			throws ServletException, IOException {
		String paginaJsp = "/vista/lista-estudiantes.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
		req.setAttribute("listaEstudiantes", listaEstudiantes);
		dispatcher.forward(req, resp);
	}
	
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        String action = req.getParameter("action");
	        System.out.println("Do Post");
	        System.out.println(action);
	        switch (action) {
	            case "guardar":
	                guardarEstudiante(req, resp);
	                break;
	            case "actualizar":
	                actualizarEstudiante(req, resp);
	                break;            
	            case "eliminar":
	                eliminarEstudiante(req, resp);
	                break;            
	        }

	    }
	 
	 private void guardarEstudiante(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        String nombre = req.getParameter("nombre");
	        String apellido = req.getParameter("apellido");
	        String fnacimiento = req.getParameter("fnacimiento");
	        String carrera = req.getParameter("carrera");
	        String semestre = req.getParameter("semestre");
	        String email = req.getParameter("email");
	        Estudiante estudiante = new Estudiante(nombre, apellido, fnacimiento, carrera, semestre, email);
	        long idEstudiante = estudianteDAO.guardarEstudiante(estudiante);
	        List<Estudiante> listaEstudiantes = estudianteDAO.obtenerEstudiantes();
	        req.setAttribute("idEstudiante", idEstudiante);
	        String message = "Resgistro creado satisfactoriamente.";
	        req.setAttribute("message", message);
	        mostrarListaEstudiantes(req, resp, listaEstudiantes);
	    }

	    private void actualizarEstudiante(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        String nombre = req.getParameter("nombre");
	        String apellido = req.getParameter("apellido");
	        String fnacimiento = req.getParameter("fnacimiento");
	        String carrera = req.getParameter("carrera");
	        String semestre = req.getParameter("semestre");
	        String email = req.getParameter("email");
	        long idEstudiante = Integer.valueOf(req.getParameter("idEstudiante"));
	        Estudiante estudiante = new Estudiante(nombre, apellido, fnacimiento, carrera, semestre, email);
	        estudiante.setId(idEstudiante);
	        boolean success = estudianteDAO.actualizarEstudiante(estudiante);
	        String message = null;
	        if (success) {
	            message = "Registro actualizado satisfactoriamente.";
	        }
	        List<Estudiante> listaEstudiantes = estudianteDAO.obtenerEstudiantes();
	        req.setAttribute("idEstudiante", idEstudiante);
	        req.setAttribute("message", message);
	        mostrarListaEstudiantes(req, resp, listaEstudiantes);
	    }  

	    private void eliminarEstudiante(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        long idEstudiante = Integer.valueOf(req.getParameter("idEstudiante"));
	        boolean confirmar = estudianteDAO.eliminarEstudiante(idEstudiante);
	        if (confirmar){
	            String message = "Registro eliminado satisfactoriamente.";
	            req.setAttribute("message", message);
	        }
	        List<Estudiante> listaEstudiantes = estudianteDAO.obtenerEstudiantes();
	        mostrarListaEstudiantes(req, resp, listaEstudiantes);
	    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.PersonaDao;
import conexion.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Persona;


public class ActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ArrayList<Persona> personas = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Si lo queremos hacer a traves de un get, tenemos que poner el codigo del post en esta clase
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();

		// Obtengo los datos de la peticion
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String edad = request.getParameter("edad");
                //-------------------------------------------
                try {
                Persona  persona=new Persona();
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setEdad(edad);
                
                DBConnection conn=new DBConnection();
                PersonaDao perdao= new PersonaDao(conn);
                boolean status = perdao.Insert(persona);
                String msg = "";

            if (status) {
                msg = "Exito al ingresar su Informacion a la Base de Datos";
            } else {
                msg = "ERROR al ingresar su Información a la Base de Datos";
            }
            request.setAttribute("msg", msg);
   
            } catch (Exception e) {
            }
                //---------------------------------------------
		// Compruebo que los campos del formulario tienen datos para añadir a la tabla
		if (!nombre.equals("") && !apellido.equals("") && !edad.equals("")) {
			// Creo el objeto persona y lo añado al arrayList
			Persona persona = new Persona(nombre, apellido, edad);
			personas.add(persona);
		}
                out.println("<table  class='table-hover' width='100%' border= '2' cellspacing= '1'>");
                out.println("thead");
		out.println("<tr>");
		
		out.println("<th> NOMBRE </th>");			
		out.println("<th>APELLIDO</th>");
		out.println("<th>EDAD</th>");
		out.println("</tr>");
                out.println("/thead");
		for(int i=0; i<personas.size(); i++){
			Persona persona = personas.get(i);
                       
			out.println("<tr>");
			out.println("<td>"+persona.getNombre()+"</td>");			
			out.println("<td>"+persona.getApellido()+"</td>");
			out.println("<td>"+persona.getEdad()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");

	}
        
        
        
        
}
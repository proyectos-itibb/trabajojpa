
package com.emergentes.Controller;

import com.emergentes.beam.Beamestudiante;
import com.emergentes.entidades.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstudianteServlet", urlPatterns = {"/EstudianteServlet"})
public class EstudianteServlet extends HttpServlet {

 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id;
        Beamestudiante dao=new Beamestudiante();
        Estudiante e =new Estudiante();
        String action=(request.getParameter("action")!=null)?request.getParameter("action"):"view";
        switch(action) {
                case "add":
                    request.setAttribute("Estudiante", e);
                    request.getRequestDispatcher("Estudiante-edit.jsp").forward(request, response);
                    break;
                    
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    e =dao.buscar(id);
                    request.setAttribute("cliente", e);
                    request.getRequestDispatcher("Estudiante-edit.jsp").forward(request, response);
                    break;
                    
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect("EstudianteControlador");
                    break;
                    
                case "view":
                    List<Estudiante> lista = dao.listarTodos();
                    request.setAttribute("Estudiantes", lista);
                    request.getRequestDispatcher("Estudiantes.jsp").forward(request, response);
                    break;
            }
        
      
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    Beamestudiante dao=new Beamestudiante();
        int id = Integer.parseInt(request.getParameter("id"));
        String apellido = request.getParameter("apellido");
        String nombre = request.getParameter("nombre");
        String email= request.getParameter("email");
        
        Estudiante e= new    Estudiante();
         e.setApellidos("Mamani");
        e.setNombre("Eli");
        e.setEmail("elimamani@gmail.com");
       
        if (id == 0) {
            dao.editar(e);
            
        } else {
            try {
                // Actualizar registro existente
                dao.insertar(e);
            } catch (Exception ex) {
                System.out.println("Error al editar: " + ex.getMessage());
            }
        }
        response.sendRedirect("EstudianteServlet");
    }
}
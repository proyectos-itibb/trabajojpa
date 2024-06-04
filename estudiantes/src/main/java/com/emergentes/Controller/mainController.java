/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.Controller;

import com.emergentes.beam.Beamestudiante;
import com.emergentes.entidades.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dani
 */
@WebServlet(name = "mainController", urlPatterns = {"/mainController"})
public class mainController extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        System.out.println("ESTAMOS EN EL SERVLET");
      //nuevo();
      //eliminar();
      
      mostrar();
       editar();
        mostrar();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         }
    
    private void nuevo(){
    
      Beamestudiante dao=new  Beamestudiante();
        Estudiante e=new Estudiante();
        e.setApellidos("Mamani");
        e.setNombre("Eli");
        e.setEmail("elimamani@gmail.com");
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
        e.setFechaNacimiento(sdf.parse("2001-03-02"));
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    dao.insertar(e);
    }
    
    private void editar(){
    
    Beamestudiante dao=new Beamestudiante();
    //id para editarlo
    Integer id = 4;
    Estudiante e=dao.buscar(id);
    
    e.setNombre("dulce");
    e.setEmail("dulce@gmail.com");
    dao.editar(e);
    
    
    }
    
    
    private void eliminar(){
    
    Beamestudiante dao=new Beamestudiante();
   //id para eliminar
    Integer id = 3;
    dao.eliminar(id);
    }
    
    
    
    
private void mostrar(){

 Beamestudiante dao=new  Beamestudiante();
      List<Estudiante> lista=dao.listarTodos();
       
      for(Estudiante item:lista){
      
          System.out.println(item.toString());  
      }



}
}

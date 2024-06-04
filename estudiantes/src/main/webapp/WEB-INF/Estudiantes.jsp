<%@page import="com.emergentes.entidades.Estudiante"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

List<Estudiante> Estudiantes=(List<Libro>) request.getAttribute("Estudiantes");
        
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <div class="container">
    <h1>VENTAS</h1>
    <p>
        <a href="EstudianteServlet=add">nuevo</a>
        
    </p>
    <br>
    <a href="EstudianteServlet=add">nuevo</a>
    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>APELLIDO</th>
            <th>EMAIL</th>
            <th>FECHA NACIMIENTO</th>
            <th></th>
            <th></th>
        </tr>
        <%
            for(Estudiante item :Estudiantes){
            
            }
            %>
            <tr>
                <td><%=item.getId() %></td>
                <td><%=item.getapellido() %></td>
                <td><%=item.getnombre() %></td>
                <td><%=item.getemail() %></td>
                 <td><%=item.fecha() %></td>
                <td><a href="VentaControlador?action=edit&id=${item.id}"><i class="fa-regular fa-pen-to-square"></i></a></td>
                <td><a href="VentaControlador?action=delete&id=${item.id}" onclick="return(confirm('¿Está seguro de borrar?'))">
                        <i class="fa-solid fa-eraser"></i>
                    </a></td>
            </tr>
        
    </table>

    </body>
</html>

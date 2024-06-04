
package com.emergentes.beam;

import com.emergentes.entidades.Estudiante;
import com.emergentes.jpa.EstudianteJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Beamestudiante {
   private EntityManagerFactory emf;
   private EstudianteJpaController jpaEstudiante;

    public Beamestudiante() {
    
    emf=Persistence.createEntityManagerFactory("UPestudiante");
jpaEstudiante=new EstudianteJpaController (emf);    
    }
public List<Estudiante> listarTodos()
{
return jpaEstudiante.findEstudianteEntities();
}
   public void insertar(Estudiante e){
   jpaEstudiante.create(e);
   
   }
   public void eliminar(Integer id){
       try {
           jpaEstudiante.destroy(id);
       } catch (NonexistentEntityException ex) {
           Logger.getLogger(Beamestudiante.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   }
   public void editar(Estudiante e){
   
       try {
           jpaEstudiante.edit(e);
       } catch (Exception ex) {
           Logger.getLogger(Beamestudiante.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   }
   
   public Estudiante buscar (Integer id){
   
   Estudiante est=new Estudiante();
   est=jpaEstudiante.findEstudiante(id);
   return est;  
   }
 
}

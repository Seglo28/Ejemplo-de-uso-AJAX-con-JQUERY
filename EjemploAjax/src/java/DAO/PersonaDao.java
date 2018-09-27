/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexion.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelo.Persona;


public class PersonaDao {
    
    DBConnection conn;
    
    public PersonaDao(DBConnection conn){
    this.conn = conn;
    }
  
    public boolean Insert(Persona per){
         String sql = "insert into persona values (?,?,?)";
        try {
            PreparedStatement ps = conn.getConeccion().prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getApellido());
            ps.setString(3, per.getEdad());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("error al ingresar la información de la persona "+e);
          return false;   
        }
       
    }
//     public List<Persona> getAll() {
//        String sql = "select * from persona order by nombre";
//        try {
//            PreparedStatement ps = conn.getConeccion().prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            List<Persona> lista = new LinkedList<>();
//            Persona persona = new Persona();
//            while (rs.next()) {
//                persona.setNombre(rs.getString("nombre"));         
//                persona.setApellido(rs.getString("apellido"));
//                persona.setEdad(rs.getString("edad"));
//
//                lista.add(persona);
//            }
//            return lista;
//        } catch (SQLException e) {
//            System.out.println("ERROR al Obtener tu Información ... " + e);
//            return null;
//        }
//    }
    
    
    
    
    
    
}

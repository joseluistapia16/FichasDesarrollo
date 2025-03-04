/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Persona;
import impl.PersonaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class CrudPersona implements PersonaDAO {

    private String base = "fichas_medicas_desarrollo";
    private Conexion conexion;

    public CrudPersona() {
        this.conexion = new Conexion();
    }

    @Override
    public boolean save(Persona obj) {
        var sql = "INSERT INTO persona(cedula, nombres, apellidos, lugar_nacimiento, fecha_nacimiento, n_hijos, correo, "
                + "direccion, telefono, id_rol+, id_grupo_sanguineo, id_estado_civil, id_area, id_usuario,fecha_registro, estado) "
                + "VALUES(?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                java.sql.Connection conect = this.conexion.conectar(base); PreparedStatement st = conect.prepareStatement(sql)) {
            st.setString(1, obj.getCedula());
            st.setString(2, obj.getNombre());
            st.setString(3, obj.getNombre());
            st.setString(4, obj.getApellidos());
            st.setDate(5, obj.getFecha_nacimiento());
            st.setString(6, obj.getLugar_nacimiento());
            st.setInt(7, obj.getN_hijos());
            st.setString(8, obj.getDireccion());
            st.setString(10, obj.getTelefono());
            st.setInt(11, obj.getId_grupo_sanguineo());
            st.setInt(12, obj.getId_area());
            st.setInt(13, obj.getId_area());
            st.setDate(14, obj.getFecha_registro());
            st.setString(15, obj.getEstado());
            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CrudArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Persona obj) {
        var query = "UPDATE persona SET nombres = ?, apellidos = ? , fecha_nacimiento = ? ,lugar_nacimiento = ?, n_hijos=?, direccion=?, id_grupo_sanguineo, id_estado_civil, id_area, estado  "
                + "where cedula=?";
        try (
                Connection conect = this.conexion.conectar(base); PreparedStatement st = conect.prepareStatement(query)) {
            st.setString(1, obj.getNombre());     // Asigna el nombre del área
            st.setString(2, obj.getApellidos());         // Asigna el ID del usuario         // Asigna el estado ('A' o 'I')
            st.setDate(3, obj.getFecha_nacimiento());
            st.setString(4, obj.getLugar_nacimiento());
            st.setInt(5, obj.getN_hijos());
            st.setString(6, obj.getDireccion());
            st.setInt(8, obj.getId_grupo_sanguineo());
            st.setInt(9, obj.getId_estado_civil());
            st.setInt(10, obj.getId_area());
            st.setString(11, obj.getEstado());
            st.setString(12, obj.getCedula());
            int rowsAffected = st.executeUpdate();     // Ejecuta la actualización
            return rowsAffected > 0;                   // Retorna true si se actualizaron filas
        } catch (SQLException ex) {
            Logger.getLogger(CrudArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String cedula) {
        var query = "UPDATE persona SET  estado = ? WHERE cedula = ?";
        try (
                Connection conect = this.conexion.conectar(base); PreparedStatement st = conect.prepareStatement(query)) {
            st.setString(1, "I");          // Asigna el estado ('A' o 'I')
            st.setString(2, cedula);
            // Asigna el ID del área para actualizar
            int rowsAffected = st.executeUpdate();     // Ejecuta la actualización
            return rowsAffected > 0;                   // Retorna true si se actualizaron filas
        } catch (SQLException ex) {
            Logger.getLogger(CrudArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Persona getOne(String cedula) {
        Persona obj = null;
        var query = "SELECT * FROM persona WHERE cedula = ? AND estado = 'A'";
        try (
                Connection conect = this.conexion.conectar(base); PreparedStatement st = conect.prepareStatement(query)) {
            st.setString(1, cedula);                      // Asigna el idArea al parámetro de la consulta
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {                       // Si se encuentra un resultado
                    obj = new Persona(
                            rs.getString("cedula"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getDate("fecha_nacimiento"),
                            rs.getString("lugar_nacimiento"),
                            rs.getInt("n_hijos"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("telefono_emergencia"),
                            rs.getInt("id_grupo_sanguineo"),
                            rs.getInt("id_estado_civil"),
                            rs.getInt("id_area"),
                            rs.getString("id_usuario"),
                            rs.getDate("fecha_registro"),
                            rs.getString("estado")
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    @Override
    public List<Persona> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

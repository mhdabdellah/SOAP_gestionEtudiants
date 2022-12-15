/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.DBConnection;
import model.Etudiant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chouaib
 */
public class EtudiantController extends DBConnection{
    
//    DBConnection  dbConnection = new DBConnection();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //Obtener todos los clientes de la base de datos
    public List<Etudiant> findAll() throws SQLException {
        try {
            String sql = "SELECT * FROM Etudiant";
            List<Etudiant> listEtudiants = new ArrayList<>();

            con = conector();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Etudiant etudiant = new Etudiant(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6));

                listEtudiants.add(etudiant);
            }
            return listEtudiants;
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
    }

    //Obtener un cliente por su id
    public Etudiant findById(int id_Etudiant) throws SQLException {
        try {
            String sql = "SELECT * FROM Etudiant WHERE id = " + id_Etudiant + "";

            Etudiant etudiant = null;

            con = conector();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                etudiant = new Etudiant(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6));

            }

            return etudiant;
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
    }

    //Crear un nuevo cliente
    public boolean create(Etudiant etudiant) throws SQLException {
        try {
            String sql = "INSERT INTO Etudiant VALUES(null, ?, ?, ?,?, ?)";

            boolean inseree = false;

            con = conector();

            ps = con.prepareStatement(sql);
            ps.setString(1, etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.setInt(3, etudiant.getAge());
            ps.setString(4, etudiant.getSpecialite());
            ps.setString(5, etudiant.getNumero());

            if (ps.executeUpdate() == 1) {
                inseree = true;
            }

            return inseree;
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ps.close();
            con.close();
        }
    }

    //Actualizar un cliente por su id
    public boolean update(Etudiant etudiant) throws SQLException {
        try {
            String sql = "UPDATE Etudiant SET nom = ?, prenom = ?, age = ?,specialite = ?, numero = ? WHERE id = ?";

            boolean respuesta = false;

            con = conector();

            ps = con.prepareStatement(sql);
            ps.setString(1, etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.setInt(3, etudiant.getAge());
            ps.setString(4, etudiant.getSpecialite());
            ps.setString(5, etudiant.getNumero());
            ps.setInt(6, etudiant.getId());

            if (ps.executeUpdate() == 1) {
                respuesta = true;
            }

            return respuesta;
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ps.close();
            con.close();
        }
    }

    //Eliminar un cliente por su id
    public boolean delete(int id_etudiant) throws SQLException {
        try {
            String sql = "DELETE FROM Etudiant WHERE id = " + id_etudiant + "";

            boolean respuesta = false;

            con = conector();
            ps = con.prepareStatement(sql);

            if (ps.executeUpdate() == 1) {
                respuesta = true;
            }

            return respuesta;
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ps.close();
            con.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.EtudiantController;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Etudiant;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chouaib
 */
@WebService(serviceName = "EtudiantWebService")
public class EtudiantWebService {
    
    EtudiantController etudiantController = new EtudiantController();

    // afficher tous les etudiant
    @WebMethod(operationName = "findAll")
    public List<Etudiant> findAll() {
        System.out.print("getALL Students");
        try {
            return etudiantController.findAll();
        } catch (NullPointerException|SQLException ex) {
            Logger.getLogger(EtudiantWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //rechercher a un etudiant par son id
    @WebMethod(operationName = "findById")
    public Etudiant findById(@WebParam(name = "id") int id) {
        try {
            return etudiantController.findById(id);
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //Creer un nouveau etudiant
    @WebMethod(operationName = "create")
    public String create(@WebParam(name = "etudiant") Etudiant etudiant) {
        try {
            if (etudiantController.create(etudiant)) {
                return "L'Etudiant " + etudiant.getNom() + " est Cree.";
            }
            return "Erreur dans la creation d'un etudiant";
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantWebService.class.getName()).log(Level.SEVERE, null, ex);
            return "Erreur au niveau du requete";
        }
    }

    //Modifier un etudiant
    @WebMethod(operationName = "update")
    public Etudiant update(@WebParam(name = "etudiant") Etudiant etudiant) {
        try {
            Etudiant cletudiantUpdated = null;
            if (etudiantController.update(etudiant)) {
                cletudiantUpdated = etudiantController.findById(etudiant.getId());
            }
            return cletudiantUpdated;
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //Supprimer un etudiant
    @WebMethod(operationName = "delete")
    public String delete(@WebParam(name = "id") int id) {
        try {
            String msg = "l'etudiant ne peut pas supprimer";
            if (etudiantController.delete(id)) {
                msg = "l'etudiant est Supprimee";
            }
            return msg;
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantWebService.class.getName()).log(Level.SEVERE, null, ex);
            return "Erreur au niveau de requete";
        }
    }
}

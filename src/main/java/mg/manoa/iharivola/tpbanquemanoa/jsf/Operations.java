/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.manoa.iharivola.tpbanquemanoa.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.util.List;
import mg.manoa.iharivola.tpbanquemanoa.entity.CompteBancaire;
import mg.manoa.iharivola.tpbanquemanoa.entity.OperationBancaire;
import mg.manoa.iharivola.tpbanquemanoa.service.GestionnaireCompte;

/**
 *
 * @author My PC
 */
@Named(value = "operations")
@RequestScoped
public class Operations {

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    private Long idCompteBancaire;
    private CompteBancaire compte;

    /**
     * Creates a new instance of Operations
     */
    public Operations() {
    }

    public Long getIdCompteBancaire() {
        return idCompteBancaire;
    }

    public void setIdCompteBancaire(Long idCompteBancaire) {
        this.idCompteBancaire = idCompteBancaire;
    }

    public void setCompte() {
        this.compte = gestionnaireCompte.findById(idCompteBancaire);
    }

    public CompteBancaire getCompte() {
        return compte;
    }
    
    public List<OperationBancaire> getOperations() {
        return compte.getOperations();
    }
}

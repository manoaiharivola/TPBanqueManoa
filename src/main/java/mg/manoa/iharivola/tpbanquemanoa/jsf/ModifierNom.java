/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.manoa.iharivola.tpbanquemanoa.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import mg.manoa.iharivola.tpbanquemanoa.entity.CompteBancaire;
import mg.manoa.iharivola.tpbanquemanoa.jsf.util.Util;
import mg.manoa.iharivola.tpbanquemanoa.service.GestionnaireCompte;

/**
 *
 * @author My PC
 */
@Named(value = "modifierNom")
@ViewScoped
public class ModifierNom implements Serializable {

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    private Long idCompte;
    private CompteBancaire compte;
    private String nom;
    private String ancienNom;

    /**
     * Creates a new instance of ModifierNom
     */
    public ModifierNom() {
    }

    public String getNom() {
        return nom;
    }

    public void setMontant(String nom) {
        this.nom = nom;
    }

    public Long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void loadCompte() {
        compte = gestionnaireCompte.findById(idCompte);
        this.ancienNom = compte.getNom();
    }

    public String enregistrer() {
        gestionnaireCompte.update(compte);
        Util.addFlashInfoMessage("Nom " + this.ancienNom + " changé en " + compte.getNom());
        return "listeComptes?faces-redirect=true";
    }
}

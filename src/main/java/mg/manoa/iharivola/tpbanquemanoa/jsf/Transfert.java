/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.manoa.iharivola.tpbanquemanoa.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import mg.manoa.iharivola.tpbanquemanoa.entity.CompteBancaire;
import mg.manoa.iharivola.tpbanquemanoa.jsf.util.Util;
import mg.manoa.iharivola.tpbanquemanoa.service.GestionnaireCompte;

/**
 *
 * @author My PC
 */
@Named(value = "transfert")
@RequestScoped
public class Transfert {

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    private long idSource;
    private long idDestination;
    private int montant;

    public Transfert() {
    }

    public long getIdSource() {
        return idSource;
    }

    public void setIdSource(long id) {
        this.idSource = id;
    }

    public long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(long id) {
        this.idDestination = id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String enregistrer() {
        boolean erreur = false;

        CompteBancaire source = gestionnaireCompte.findById(idSource);
        if (source == null) {
            Util.messageErreur("Aucun compte source avec cet id !", "Aucun compte source avec cet id !", "form:source");
            erreur = true;
        } else {
            if (source.getSolde() < montant) {
                Util.messageErreur("Le solde du compte source est insuffisant !", "Le solde du compte source est insuffisant !", "form:source");
                erreur = true;
            }
        }

        CompteBancaire destination = gestionnaireCompte.findById(idDestination);
        if (destination == null) {
            Util.messageErreur("Aucun compte destination avec cet id !", "Aucun compte destination avec cet id !", "form:destination");
            erreur = true;
        } 

        if (erreur) {
            return null;
        }

        gestionnaireCompte.transferer(source, destination, montant);
        Util.addFlashInfoMessage("Le transfert de " + source.getNom() + " vers " + destination.getNom() + " pour un montant de " + montant + " est effectué avec succès !");
        return "listeComptes?faces-redirect=true";
    }
}
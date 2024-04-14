/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.manoa.iharivola.tpbanquemanoa.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import mg.manoa.iharivola.tpbanquemanoa.entity.CompteBancaire;
import mg.manoa.iharivola.tpbanquemanoa.service.GestionnaireCompte;

/**
 *
 * @author My PC
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    private List<CompteBancaire> listeComptes;

    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
    }

    public List<CompteBancaire> getAllComptes() {
        if (listeComptes == null) {
            listeComptes = gestionnaireCompte.getAllComptes();
        }
        return listeComptes;
    }
}

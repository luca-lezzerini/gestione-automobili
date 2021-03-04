package it.iad2.gestauto.service;

import it.iad2.gestauto.dto.ListeAutoDto;
import it.iad2.gestauto.model.Automobile;

public interface GestioneAutoService {

    ListeAutoDto inserisciAuto(Automobile auto);
    
    ListeAutoDto aggiornaListe();
}

package it.iad2.gestauto.service;

import it.iad2.gestauto.dto.CriterioRicercaDto;
import it.iad2.gestauto.dto.ListeAutoDto;
import it.iad2.gestauto.model.Automobile;
import org.springframework.web.bind.annotation.RequestBody;

public interface GestioneAutoService {

    ListeAutoDto inserisciAuto(Automobile auto);

    ListeAutoDto cancellaAuto(Automobile auto);

    ListeAutoDto ricercaAuto(String criterio);

    ListeAutoDto aggiornaListe();
}

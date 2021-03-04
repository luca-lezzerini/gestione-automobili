package it.iad2.gestauto.service.impl;

import it.iad2.gestauto.dto.AutoDto;
import it.iad2.gestauto.dto.BolloDto;
import it.iad2.gestauto.dto.ListeAutoDto;
import it.iad2.gestauto.model.Automobile;
import it.iad2.gestauto.repository.AutomobileRepository;
import it.iad2.gestauto.service.GestioneAutoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestioneAutoServiceImpl implements GestioneAutoService {

    @Autowired
    AutomobileRepository automobileRepository;

    @Override
    public ListeAutoDto inserisciAuto(Automobile auto) {
        // salva l'auto
        automobileRepository.save(auto);
        // aggiorna la lista delle auto
        return aggiornaListe();
    }

    @Override
    public ListeAutoDto cancellaAuto(Automobile auto) {
        // cancello l'auto
        automobileRepository.delete(auto);
        // aggiorna la lista
        return aggiornaListe();
    }

    @Override
    public ListeAutoDto aggiornaListe() {
        ListeAutoDto dto = new ListeAutoDto();
        List<Automobile> lista = automobileRepository.findAll();
        if (lista == null) {
            dto.setListaAuto(new ArrayList<>());
        } else {
            dto.setListaAuto(lista);
        }
        return dto;
    }

    @Override
    public ListeAutoDto ricercaAuto(String criterio) {
        List<Automobile> filtrati = automobileRepository.findByTargaContainsOrModelloContains(criterio, criterio);
        return new ListeAutoDto(filtrati);
    }

    @Override
    public BolloDto calcolaBollo(Automobile auto) {
        // mai fidarsi dei dati del client e riprenderli dal DB sempre
        Automobile autoDB = automobileRepository.getOne(auto.getId());
        if (autoDB == null) {
            return new BolloDto();
        } else {
            double bollo = autoDB.getCilindrata() / 10.0;
            System.out.println("Bollo = " + bollo);
            return new BolloDto(bollo);
        }
    }
}

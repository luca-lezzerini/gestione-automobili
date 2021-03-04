package it.iad2.gestauto.controller;

import it.iad2.gestauto.dto.AutoDto;
import it.iad2.gestauto.dto.BolloDto;
import it.iad2.gestauto.dto.CriterioRicercaDto;
import it.iad2.gestauto.dto.ListeAutoDto;
import it.iad2.gestauto.service.GestioneAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class GestioneAutoController {

    @Autowired
    GestioneAutoService gestioneAutoService;

    @RequestMapping("/inserisci-auto")
    @ResponseBody
    public ListeAutoDto inserisciAuto(@RequestBody AutoDto dto) {
        return gestioneAutoService.inserisciAuto(dto.getAutomobile());
    }

    @RequestMapping("/ricerca-auto")
    @ResponseBody
    public ListeAutoDto ricercaAuto(@RequestBody CriterioRicercaDto dto) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping("/cancella-auto")
    @ResponseBody
    public ListeAutoDto cancellaAuto(@RequestBody AutoDto dto) {
        return gestioneAutoService.cancellaAuto(dto.getAutomobile());
    }

    @RequestMapping("/calcola-bollo")
    @ResponseBody
    public BolloDto calcolaBollo(@RequestBody AutoDto dto) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping("/reset-db")
    @ResponseBody
    public ListeAutoDto resetDB() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping("/aggiorna-liste")
    @ResponseBody
    public ListeAutoDto aggiornaListe() {
        throw new UnsupportedOperationException();
    }

}

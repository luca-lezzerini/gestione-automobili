import { CriterioRicercaDto } from './criterio-ricerca-dto';
import { Automobile } from './automobile';
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ListeAutoDto } from './liste-auto-dto';
import { AutoDto } from './auto-dto';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  auto: Automobile = new Automobile();
  automobili: Automobile[] = [];
  ricerca: string = "";
  bolloAnnuo: number;

  constructor(private http: HttpClient) {
    this.aggiorna();
  }

  cerca() {
    // preparo i dati per il server
    let dto: CriterioRicercaDto = new CriterioRicercaDto();
    dto.stringa = this.ricerca;
    // chiamo il servizio REST e aggiorno la tabella
    let ox: Observable<ListeAutoDto> = this.http.post<ListeAutoDto>(
      "http://localhost:8080/ricerca-auto",
      dto
    );
    ox.subscribe(elle => this.automobili = elle.listaAuto);
  }

  elimina(a: Automobile) {
    // preparo i dati per il servizio REST
    let dto: AutoDto = new AutoDto();
    dto.automobile = a;

    // chiamo il servizio REST e con la risposta aggiorno la tabella
    let ox: Observable<ListeAutoDto> = this.http.post<ListeAutoDto>(
      "http://localhost:8080/cancella-auto",
      dto
    );
    ox.subscribe(elle => this.automobili = elle.listaAuto);
  }

  aggiungi() {
    // preparo i dati da inviare al server via DTO
    let dto: AutoDto = new AutoDto();
    dto.automobile = this.auto;

    // chiamo il servizio REST
    let oss: Observable<ListeAutoDto> = this.http.post<ListeAutoDto>(
      "http://localhost:8080/inserisci-auto",
      dto
    );
    oss.subscribe(v => this.automobili = v.listaAuto);
    this.auto = new Automobile();
  }

  calcolaBollo() { }

  resetDB() { }

  aggiorna() {
    // chiamo il servizio REST
    let oss: Observable<ListeAutoDto> = this.http.get<ListeAutoDto>("http://localhost:8080/aggiorna-liste");
    oss.subscribe(v => this.automobili = v.listaAuto);
  }
}

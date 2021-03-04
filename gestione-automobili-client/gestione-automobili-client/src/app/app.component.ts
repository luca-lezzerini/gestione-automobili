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

  cerca() { }

  elimina() { }

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

  aggiorna() { }
}

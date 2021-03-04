import { Automobile } from './automobile';
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

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

  }

  calcolaBollo() { }

  resetDB() { }
  
  aggiorna() { }
}

import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ticket2Associazione } from 'src/app/models/Ticket2Associazione';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
  })

export class Ticket2AssociazioneService {

    private apiServerUrl = environment.apiBaseUrl+"/ticketassociazione";

    constructor(private http: HttpClient) { }

    public findAll(): Observable<Ticket2Associazione[]> {
        return this.http.get<Ticket2Associazione[]>(`${this.apiServerUrl}/findAll`);
    }

    public findById(id: number): Observable<Ticket2Associazione> {
        return this.http.get<Ticket2Associazione>(`${this.apiServerUrl}/findById/${id}`);
    }

    public delete(id: number): Observable<number> {
        return this.http.delete<number>(`${this.apiServerUrl}/deleteById/${id}`);
    }

    public insert(ticketassociazione: Ticket2Associazione): Observable<number> {
        return this.http.post<number>(`${this.apiServerUrl}/insert`, ticketassociazione);
    }

    public update(ticketassociazione: Ticket2Associazione): Observable<number> {
        return this.http.post<number>(`${this.apiServerUrl}/update`, ticketassociazione);
    }

}
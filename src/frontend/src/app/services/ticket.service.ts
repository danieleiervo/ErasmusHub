import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ticket } from 'src/app/models/Ticket';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
  })

export class TicketService {

    private apiServerUrl = environment.apiBaseUrl+"/ticket";

    constructor(private http: HttpClient) { }

    public findAll(): Observable<Ticket[]> {
        return this.http.get<Ticket[]>(`${this.apiServerUrl}/findAll`);
    }

    public findById(id: number): Observable<Ticket> {
        return this.http.get<Ticket>(`${this.apiServerUrl}/findById/${id}`);
    }

    public delete(id: number): Observable<number> {
        return this.http.delete<number>(`${this.apiServerUrl}/deleteById/${id}`);
    }

    public insert(ticket: Ticket): Observable<number> {
        return this.http.post<number>(`${this.apiServerUrl}/insert`, ticket);
    }

    public update(ticket: Ticket): Observable<number> {
        return this.http.post<number>(`${this.apiServerUrl}/update`, ticket);
    }

    public findAllTicketByStudente(matricola: string): Observable<Ticket[]> {
        return this.http.get<Ticket[]>(`${this.apiServerUrl}/findAllTicketByStudente/${matricola}`);
    }

      
}
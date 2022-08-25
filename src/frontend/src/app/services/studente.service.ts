import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Studente } from 'src/app/models/Studente';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
  })

export class StudenteService {

    private apiServerUrl = environment.apiBaseUrl+"/studente";

    constructor(private http: HttpClient) { }
    
    public login(data: string[]): Observable<Studente> {
        return this.http.post<Studente>(`${this.apiServerUrl}/login`, data);
    }
    public findAll(): Observable<Studente[]> {
        return this.http.get<Studente[]>(`${this.apiServerUrl}/findAll`);
    }

    public findByMatricola(matricola: string): Observable<Studente> {
        return this.http.get<Studente>(`${this.apiServerUrl}/findByMatricola/${matricola}`);
    }

    public delete(matricola: string): Observable<number> {
        return this.http.delete<number>(`${this.apiServerUrl}/deleteByMatricola/${matricola}`);
    }

    public insert(Studente: Studente): Observable<number> {
        return this.http.post<number>(`${this.apiServerUrl}/insert`, Studente);
    }

    public update(Studente: Studente): Observable<number> {
        return this.http.post<number>(`${this.apiServerUrl}/update`, Studente);
    }

}
import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Associazione } from 'src/app/models/Associazione';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
  })

export class AssociazioneService {

    private apiServerUrl = environment.apiBaseUrl+"/associazione";

    constructor(private http: HttpClient) { }

    public login(data: string[]): Observable<Associazione> {
        return this.http.post<Associazione>(`${this.apiServerUrl}/login`, data);
    }

    public findAll(): Observable<Associazione[]> {
        return this.http.get<Associazione[]>(`${this.apiServerUrl}/findAll`);
    }

    public findById(id: number): Observable<Associazione> {
        return this.http.get<Associazione>(`${this.apiServerUrl}/findById/${id}`);
    }

    public delete(id: number): Observable<number> {
        return this.http.delete<number>(`${this.apiServerUrl}/deleteById/${id}`);
    }

    public insert(associazione: Associazione): Observable<number> {
        return this.http.post<number>(`${this.apiServerUrl}/insert`, associazione);
    }

    public update(associazione: Associazione): Observable<number> {
        return this.http.post<number>(`${this.apiServerUrl}/update`, associazione);
    }

    public findAssociazioneByPost(id_post: number): Observable<Associazione> {
        return this.http.get<Associazione>(`${this.apiServerUrl}/findAssociazioneByPost/${id_post}`);
    }
      
}
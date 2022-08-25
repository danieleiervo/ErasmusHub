import { HttpClient, HttpParams} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post2Studente } from 'src/app/models/Post2Studente';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
  })

export class Post2StudenteService {

    private apiServerUrl = environment.apiBaseUrl+"/poststudente";

    constructor(private http: HttpClient) { }

    public findAll(): Observable<Post2Studente[]> {
        return this.http.get<Post2Studente[]>(`${this.apiServerUrl}/findAll`);
    }

    public findById(id: number): Observable<Post2Studente> {
        return this.http.get<Post2Studente>(`${this.apiServerUrl}/findById/${id}`);
    }

    public delete(id: number): Observable<number> {
        return this.http.delete<number>(`${this.apiServerUrl}/deleteById/${id}`);
    }

    public insert(Post2Studente: Post2Studente): Observable<number> {
        return this.http.post<number>(`${this.apiServerUrl}/insert`, Post2Studente);
    }

    public update(Post2Studente: Post2Studente): Observable<number> {
        return this.http.post<number>(`${this.apiServerUrl}/update`, Post2Studente);
    }

}
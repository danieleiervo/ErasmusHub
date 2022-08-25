import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from 'src/app/models/Post';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
  })

export class PostService {

    private apiServerUrl = environment.apiBaseUrl+"/post";

    constructor(private http: HttpClient) { }

    public findAll(): Observable<Post[]> {
        return this.http.get<Post[]>(`${this.apiServerUrl}/findAll`);
    }

    public findById(id: number): Observable<Post> {
        return this.http.get<Post>(`${this.apiServerUrl}/findById/${id}`);
    }

    public delete(id: number): Observable<number> {
        return this.http.delete<number>(`${this.apiServerUrl}/deleteById/${id}`);
    }

    public insert(Post: Post): Observable<number> {
        return this.http.post<number>(`${this.apiServerUrl}/insert`, Post);
    }

    public update(Post: Post): Observable<number> {
        return this.http.post<number>(`${this.apiServerUrl}/update`, Post);
    }

}
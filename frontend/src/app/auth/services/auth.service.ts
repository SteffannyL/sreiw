import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8082/api/auth';

  constructor(private http: HttpClient) {}

  login(data: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, data)
      .pipe(
        tap((response: any) => {
          // Guardar datos en localStorage
          localStorage.setItem('usuario', JSON.stringify(response));
        })
      );
  }

  logout() {
    localStorage.removeItem('usuario');
  }

  getUsuario() {
    return JSON.parse(localStorage.getItem('usuario') || '{}');
  }

  estaLogueado(): boolean {
    return !!localStorage.getItem('usuario');
  }
}

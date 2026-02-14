import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private apiUsuariosUrl = 'http://localhost:8082/api/usuarios';
  private apiAuthUrl = 'http://localhost:8082/api/auth';

  constructor(private http: HttpClient) {}

  login(datos: { correo: string; contrasena: string }): Observable<any> {
    return this.http.post(`${this.apiAuthUrl}/login`, datos);
  }

  listar(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUsuariosUrl);
  }
}


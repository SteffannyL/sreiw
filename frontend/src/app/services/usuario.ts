import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private apiUrl = 'http://localhost:8082/api/usuarios';

  constructor(private http: HttpClient) {}


  login(datos: { correo: string; contrasena: string }): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, datos);
  }

registrarUsuario(datos: any) {
  return this.http.post(
    'http://localhost:8082/api/auth/register',
    datos
  );
}

}

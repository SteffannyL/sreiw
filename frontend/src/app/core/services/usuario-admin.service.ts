import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Usuario {
  idusuario?: number;
  nombres: string;
  correo: string;
  contrasena?: string;
  idtipousuario: number;
  activo: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private apiUrl = 'http://localhost:8082/api';
  private storageKey = 'usuario';

  constructor(private http: HttpClient) {}

  /* ========================
        AUTH
  ======================== */

  login(datos: { correo: string; contrasena: string }): Observable<Usuario> {
    return this.http.post<Usuario>(`${this.apiUrl}/auth/login`, datos);
  }

  guardarSesion(usuario: Usuario): void {
    localStorage.setItem(this.storageKey, JSON.stringify(usuario));
  }

  obtenerSesion(): Usuario | null {
    const data = localStorage.getItem(this.storageKey);
    return data ? JSON.parse(data) : null;
  }

  cerrarSesion(): void {
    localStorage.removeItem(this.storageKey);
  }

  estaLogueado(): boolean {
    return !!this.obtenerSesion();
  }

  esAdmin(): boolean {
    const usuario = this.obtenerSesion();
    return usuario?.idtipousuario === 1;
  }

  /* ========================
        USUARIOS
  ======================== */

  listar(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this.apiUrl}/usuarios`);
  }

  obtenerPorId(id: number): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.apiUrl}/usuarios/${id}`);
  }

  crear(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`${this.apiUrl}/usuarios`, usuario);
  }

  actualizar(usuario: Usuario): Observable<Usuario> {
    return this.http.put<Usuario>(
      `${this.apiUrl}/usuarios/${usuario.idusuario}`,
      usuario
    );
  }

  eliminar(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/usuarios/${id}`);
  }
}
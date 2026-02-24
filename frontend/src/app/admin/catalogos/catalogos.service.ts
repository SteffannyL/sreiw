import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class CatalogosService {

  private api = 'http://localhost:8082/api/catalogos';

  constructor(private http: HttpClient) {}

  listar(tabla: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.api}/${tabla}`);
  }

  insertar(tabla: string, nombre: string) {
    return this.http.post(`${this.api}/${tabla}`, { nombre });
  }

  actualizar(tabla: string, id: number, nombre: string) {
    return this.http.put(`${this.api}/${tabla}/${id}`, { nombre });
  }

  eliminar(tabla: string, id: number) {
    return this.http.delete(`${this.api}/${tabla}/${id}`);
  }
}
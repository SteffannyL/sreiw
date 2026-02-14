import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private baseUrl = '/api/usuarios';

  constructor(private http: HttpClient) {}

  registrarUsuario(datos: any, documento?: File) {
    const formData = new FormData();

    formData.append(
      'datos',
      new Blob([JSON.stringify(datos)], { type: 'application/json' })
    );

    if (documento) {
      formData.append('documento', documento);
    }

    return this.http.post(
      `${this.baseUrl}/registro`,
      formData,
      { responseType: 'text' }
    );
  }
}

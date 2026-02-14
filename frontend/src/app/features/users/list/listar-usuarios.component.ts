import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsuarioService } from '../../../core/services/usuario-admin.service';

@Component({
  standalone: true,
  imports: [CommonModule],
  template: `
    <h2>Usuarios</h2>

    <button (click)="logout()">Cerrar sesión</button>

    <ul>
      <li *ngFor="let u of usuarios">
        {{ u.correo }} -
        <span *ngIf="u.activo">Activo</span>
        <span *ngIf="!u.activo">Inactivo</span>
      </li>
    </ul>
  `
})
export class ListarUsuariosComponent implements OnInit {

  usuarios: any[] = [];

  constructor(
    private usuarioService: UsuarioService
  ) {}

  ngOnInit(): void {
    this.usuarioService.listar().subscribe({
      next: (data: any[]) => {
        this.usuarios = data;
      },
      error: err => {
        console.error('Error al listar usuarios', err);
      }
    });
  }

  logout(): void {
    localStorage.removeItem('usuario');
    location.href = '/login';
  }
}

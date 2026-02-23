import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsuarioService } from '../../core/services/usuario-admin.service';
import { Router, RouterLink } from '@angular/router';

@Component({
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './users.html',
  styleUrls: ['./users.css']
})
export class Users implements OnInit {

  usuarios: any[] = [];

  constructor(
    private usuarioService: UsuarioService,
    private router: Router,
    private cdr: ChangeDetectorRef   // 👈 agregado
  ) {}

  ngOnInit(): void {
    this.cargarUsuarios();
  }

  cargarUsuarios(): void {
    this.usuarioService.listar().subscribe({
      next: (data: any[]) => {

        console.log("Usuarios recibidos:", data);

        // 👇 FORZAMOS nueva referencia
        this.usuarios = [...data];

        // 👇 Forzamos detección de cambios
        this.cdr.detectChanges();
      },
      error: err => {
        console.error('Error cargando usuarios', err);
      }
    });
  }

  logout(): void {
    localStorage.removeItem('usuario');
    this.router.navigate(['/login']);
  }
  menuColapsado = false;

toggleMenu() {
  this.menuColapsado = !this.menuColapsado;
}
}

import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { UsuarioService } from '../../core/services/usuario-admin.service';

@Component({
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './user-form.html',
  styleUrls: ['./user-form.css']
})
export class UserForm implements OnInit {

  esEdicion = false;
  titulo = 'Crear usuario';

  usuario: any = {
    idusuario: null,
    nombres: '',
    correo: '',
    contrasena: '',
    idtipousuario: 2,
    activo: true
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private usuarioService: UsuarioService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');

    if (id) {
      this.esEdicion = true;
      this.titulo = 'Editar usuario';

      this.usuarioService.obtenerPorId(+id).subscribe(data => {
        this.usuario = data;
        this.usuario.contrasena = ''; // no mostrar hash
      });
    }
  }

  guardar(): void {

 
    if (this.esEdicion && !this.usuario.contrasena) {
      delete this.usuario.contrasena;
    }

    if (this.esEdicion) {
      this.usuarioService.actualizar(this.usuario).subscribe(() => {
        this.router.navigate(['/admin/users']);
      });
    } else {
      this.usuarioService.crear(this.usuario).subscribe(() => {
        this.router.navigate(['/admin/users']);
      });
    }
  }

  cancelar(): void {
    this.router.navigate(['/admin/users']);
  }
}
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CatalogosService } from './catalogos.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-catalogos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './catalogos.html',
  styleUrls: ['./catalogos.css']
})
export class CatalogosComponent implements OnInit {

  tablas = [
    'tipousuario',
    'tipoevento',
    'tipoarchivo',
    'ambito',
    'estadoasistencia',
    'estadocomentario',
    'estadoaprobacionevento',
    'estadopublicacion'
  ];

  tablaSeleccionada = 'tipoevento';
  lista: any[] = [];
  nuevoNombre = '';
  editandoId: number | null = null;

  constructor(
    private service: CatalogosService,
    private router: Router
  ) {}

  ngOnInit() {
    this.cargar();
  }

  volver() {
    this.router.navigate(['/admin/users']);
  }

  cargar() {
    this.service.listar(this.tablaSeleccionada)
      .subscribe(data => this.lista = data);
  }

  cambiarTabla() {
    this.editandoId = null;
    this.nuevoNombre = '';
    this.cargar();
  }

  guardar() {
    if (!this.nuevoNombre || this.nuevoNombre.trim() === '') {
      alert('El nombre no puede estar vacío');
      return;
    }

    if (this.editandoId) {
      this.service.actualizar(
        this.tablaSeleccionada,
        this.editandoId,
        this.nuevoNombre.trim()
      ).subscribe(() => this.reset());
    } else {
      this.service.insertar(
        this.tablaSeleccionada,
        this.nuevoNombre.trim()
      ).subscribe(() => this.reset());
    }
  }

  editar(item: any) {
    this.editandoId = Object.values(item)[0] as number;
    this.nuevoNombre = this.obtenerNombre(item);
  }

  eliminar(item: any) {
    const id = Object.values(item)[0] as number;
    if (confirm('¿Eliminar registro?')) {
      this.service.eliminar(this.tablaSeleccionada, id)
        .subscribe(() => this.cargar());
    }
  }

  reset() {
    this.editandoId = null;
    this.nuevoNombre = '';
    this.cargar();
  }

  obtenerId(item: any): number {
    const key = Object.keys(item).find(k => k.startsWith('id'));
    return key ? item[key] : 0;
  }

  obtenerNombre(item: any): string {
    return item.nombre 
        || item.nombretipousuario 
        || item.estado 
        || '';
  }
}
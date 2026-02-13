import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

interface Evento {
  id: number;
  nombre: string;
  fechaInicio: string;
  fechaFin: string;
  lugar: string;
  activo: boolean;
}

type Predicate<T> = (value: T) => boolean;
type FunctionTR<T, R> = (value: T) => R;

@Component({
  selector: 'app-events',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './events.html',
  styleUrls: ['./events.css']
})
export class Events {

  eventos: Evento[] = [
    {
      id: 1,
      nombre: 'Congreso de Tecnología',
      fechaInicio: '2025-03-10',
      fechaFin: '2025-03-12',
      lugar: 'Auditorio Central',
      activo: true
    },
    {
      id: 2,
      nombre: 'Feria Académica',
      fechaInicio: '2025-04-01',
      fechaFin: '2025-04-01',
      lugar: 'Campus María',
      activo: false
    },
    {
      id: 3,
      nombre: 'Seminario de Inteligencia Artificial',
      fechaInicio: '2025-05-15',
      fechaFin: '2025-05-15',
      lugar: 'Auditorio Campus María',
      activo: true
    }
  ];

 
  esEventoActivo: Predicate<Evento> =
    e => e.activo;

  eventoUnDia: Predicate<Evento> =
    e => e.fechaInicio === e.fechaFin;

  eventoEnAuditorio: Predicate<Evento> =
    e => e.lugar.toLowerCase().includes('auditorio');

  nombreEventoMayusculas: FunctionTR<Evento, string> =
    e => e.nombre.toUpperCase();

  rangoFechas: FunctionTR<Evento, string> =
    e => `${e.fechaInicio} → ${e.fechaFin}`;

  lugarMinusculas: FunctionTR<Evento, string> =
    e => e.lugar.toLowerCase();

  eventosMostrados: Evento[] =
    this.eventos.filter(this.esEventoActivo);

  filtroActual: 'activo' | 'unDia' | 'auditorio' = 'activo';

  aplicarFiltro(tipo: 'activo' | 'unDia' | 'auditorio') {

    this.filtroActual = tipo;

    if (tipo === 'activo') {
      this.eventosMostrados = this.eventos.filter(this.esEventoActivo);
    }

    if (tipo === 'unDia') {
      this.eventosMostrados = this.eventos.filter(this.eventoUnDia);
    }

    if (tipo === 'auditorio') {
      this.eventosMostrados = this.eventos.filter(this.eventoEnAuditorio);
    }
  }
}

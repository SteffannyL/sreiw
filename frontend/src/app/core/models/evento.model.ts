export interface Evento {
  idEvento: number;
  nombre: string;
  descripcion?: string;
  fechaInicio: string;
  fechaFin: string;
  activo: boolean;
}

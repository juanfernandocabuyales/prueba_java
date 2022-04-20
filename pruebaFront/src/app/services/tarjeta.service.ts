import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

import { RespuestaConsultarTarjetas } from '../models/clases';

@Injectable({
  providedIn: 'root'
})
export class TarjetaService {

  private CONSULTAR_TARJETAS = `${environment.url}/tarjeta/consultarTarjetas`;

  constructor(private httClient: HttpClient) { }

  consultarTarjetas(): Observable<RespuestaConsultarTarjetas>{
    return this.httClient.get<RespuestaConsultarTarjetas>(this.CONSULTAR_TARJETAS);
  }
}

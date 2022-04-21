import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { RespuestaConsultarTransacciones } from '../models/clases';


@Injectable({
  providedIn: 'root'
})
export class TransaccionService {

  private CONSULTAR_TARJETAS = `${environment.url}/transaccion/consultarTransacciones`;

  constructor(private httClient: HttpClient) { }

  consultarTarjetas(): Observable<RespuestaConsultarTransacciones>{
    return this.httClient.get<RespuestaConsultarTransacciones>(this.CONSULTAR_TARJETAS);
  }
}

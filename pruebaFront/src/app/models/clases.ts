export class RespuestaGenerica{
    codigoRespuesta: string | undefined;
    mensaje: string | undefined;
    
   
}

export class RespuestaConsultarTarjetas extends RespuestaGenerica{
    listTarjetasDto: Tarjeta[];

    constructor(listTarjetasDto: Tarjeta[]){
        super();
        this.listTarjetasDto = listTarjetasDto;
    }
}




export class Tarjeta {
    pan: string;
    titular: string;
    cedula: string;
    telefono: string;
    estado: string;

    constructor(pan:string, titular:string, cedula:string, telefono:string, estado:string){
        this.pan = pan;
        this.titular = titular;
        this.cedula = cedula;
        this.telefono = telefono;
        this.estado = estado;
    }
}
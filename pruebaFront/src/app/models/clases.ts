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

export class RespuestaConsultarTransacciones extends RespuestaGenerica {
    transaccionesList : Transaccion[];

    constructor(transaccionesList: Transaccion[]){
        super();
        this.transaccionesList = transaccionesList;
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

export class Transaccion{
    idTarjeta : number;
    numeroReferencia : string;
    totalCompra : number;
    direccionCompra : string;
    fechaTransaccion : string;

    constructor(idTarjeta : number, numeroReferencia : string, totalCompra : number, direccionCompra : string,
                fechaTransaccion : string){
        this.idTarjeta = idTarjeta; 
        this.numeroReferencia = numeroReferencia; 
        this.totalCompra = totalCompra; 
        this.direccionCompra = direccionCompra; 
        this.fechaTransaccion = fechaTransaccion;
    }
}
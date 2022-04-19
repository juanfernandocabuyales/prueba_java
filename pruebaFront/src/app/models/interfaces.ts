export interface Tarjeta {
    pan: string;
    titular: string;
    cedula: string;
    telefono: string;
    estado: string;
}

export interface RespuestaConsultarTarjetas{
    listTarjetasDto: Tarjeta[];
}
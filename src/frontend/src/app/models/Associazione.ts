export interface Associazione {
    id: number;
    email: string;
    password: string;
    nome: string;
    dipartimento:string;
    risposte?: number;
    punteggio?: number;
    foto?: string;
}
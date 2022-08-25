export interface Studente {
    matricola: string;
    email: string;
    password: string;
    nome: string;
    cognome: string;
    paese?: string;
    facolta?: string;
    foto?: string;
    bus_tickets?: number;
}
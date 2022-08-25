export interface Ticket {
    id: number;
    mat_studente: string;
    id_associazione_best?: number;
    titolo: string;
    testo: string;
    data_apertura: Date;
}
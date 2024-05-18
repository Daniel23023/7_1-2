package org.generation.italia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Creazione di un mazzo di 40 carte uniche
        ArrayList<Integer> mazzo = new ArrayList<>();
        for (int i = 1; i <= 40; i++) {
            mazzo.add(i);
        }
        // Mescola il mazzo
        Collections.shuffle(mazzo);

        Scanner sc = new Scanner(System.in);
        float punteggio = 0f;
        int indice = 0;
        String risposta = "";

        do {
            int carta = mazzo.get(indice);
            String seme = "";
            int baseSeme = 0;

            // Determina il seme e il valore base
            if (carta >= 1 && carta <= 10) {
                seme = "bastoni";
                baseSeme = 0;
            } else if (carta >= 11 && carta <= 20) {
                seme = "danari";
                baseSeme = 10;
            } else if (carta >= 21 && carta <= 30) {
                seme = "spade";
                baseSeme = 20;
            } else if (carta >= 31 && carta <= 40) {
                seme = "coppe";
                baseSeme = 30;
            }

            // Calcola il valore della carta
            float valoreCarta = carta - baseSeme;
            if (valoreCarta > 7) {
                valoreCarta = 0.5f;
            }

            // Aggiunge il valore della carta al punteggio totale
            punteggio += valoreCarta;

            // Mostra la carta e chiede se l'utente vuole pescare un'altra carta
            System.out.println((int) (carta - baseSeme) + " " + seme);
            System.out.println("Il tuo punteggio attuale è: " + punteggio);
            System.out.println("Vuoi pescare un'altra carta? (sì/no)");
            risposta = sc.nextLine().trim().toLowerCase();

            indice++;

        } while (risposta.equals("sì") && indice < mazzo.size());

        sc.close();
        System.out.println("Il tuo punteggio finale è: " + punteggio);
    }
}

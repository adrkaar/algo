package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {

        if(a.length < 1) throw new NoSuchElementException("Tabellen er tom");

        int m = 0;

        for(int i = 1; i < a.length; i++){
            if(a[m] > a[i]){
                bytt(a, i, m);
            }
            m++;
        }
        return a[a.length - 1];
    }

    //Hjelpe metode fra kompendiet
    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static int ombyttinger(int[] a) {
        if(a.length < 1)
        throw new java.util.NoSuchElementException("Tabellen er tom");
        int m = 0;
        int j = 0;

        for(int i = 1; i <a.length; i++){
            if(a[m] > a[i]){
                bytt(a,i,m);
                j++;
            }
            m++;
        }

        return j;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        for(int i = 1; i < a.length; i++){
            if(a[i - 1] > a[i]){
                throw new IllegalStateException("Tabell er ikke sortert stigende");
            }
        }
        int t = 1; //Teller

        if(a.length == 0){ //Sjekker om arrayet er tomt
            t = 0;          //Setter variabel til 0
        } else {
            for(int i = 0; i < a.length - 1; i++){
                if(a[i] != a[i + 1]){   //Sjekker om plassering før er lik neste plassering
                    t++;                //Hvis ikke, så kjører teller
                }
            }
        }


        return t;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {

        if(a.length < 1) return;

        int v = 0; //Venstre start index
        int h = a.length - 1; //Høyre -> Siste index
        int l = a.length;

        /*
        for(int i = 0; i < a.length; i++){
            while(a[v] % 2 == 0){
                v++;
            }
            while(a[h] % 2 != 0){
                h--;
            }
        }

        while (v <= h && h > 0){ //Hvis h er større en V
            while(a[v] % 2 == 0){ //Så lenge v siden har større verdi enn h og er partall
                bytt(a, v, h);
                v++;
                h--;
            }
            if(a[v] % 2 != 0){
                v++;
            } else {
                v++;
                h--;
            }
        }
        */

        for(int i = 0; i < a.length; i++){
            while((v < l) && (a[v] % 2) != 0 ){ //Finner partall
                v++;
            }
            while((h >= 0) && (a[h] % 2) == 0 ){ //Finner oddetall
                h--;
            }
            while(i < a.length){
                if (v < h){
                    bytt(a, v, h); //Bytter om plassene
                    v++;
                    h--;
                }
                else break;
                while((a[h] % 2) == 0) {
                    h--;
                }
                while((a[v] % 2) != 0) {
                    v++;
                }

            }
        }
        //Sorterer partallene og odde tallene i asc rekkefølge
        quicksort(a, v, l);
        quicksort(a,0, v);
    }


    //Hjelpemetode
    private static int parter(int[] a, int v, int h, int skilleverdi)
    {
        while (true)
        {
            while (v <= h && a[v] < skilleverdi) v++;
            while (v <= h && a[h] >= skilleverdi) h--;

            if (v < h) bytt(a, v++,h--);
            else  return v;
        }
    }

    //Hjelpemetoder hentet fra kompendiet
    private static int sParter(int[] a, int v, int h, int index)
    {
        bytt(a, index, h);
        int pos = parter(a, v, h - 1, a[h]);
        bytt(a, pos, h);
        return pos;
    }

    private static void quicksort0(int[] a, int v, int h)
    {
        if (v >= h) return;
        int k = sParter(a, v, h, (v + h)/2);
        quicksort0(a, v, k - 1);
        quicksort0(a, k + 1, h);
    }

    public static void quicksort(int[] a, int fra, int til) // a[fra:til>
    {
        quicksort0(a, fra, til - 1);
    }


    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new UnsupportedOperationException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1

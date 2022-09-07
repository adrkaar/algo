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
        if(a.length == 0){
            return 0;
        } else if (a.length == 1) {
            return 1;
        }
        int t = 0; //Hjelpevariabel

        for(int i = 0; i < a.length; i++){
            boolean equal = false; //Bool for å sjekke om verdi er sann
            for(int j = 0; j < a.length; j++){
                if(a[i] == a[j]){
                    equal = true;
                    break;
                }
                if(!equal){
                    t++;
                }
            }
        }
        return t;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new UnsupportedOperationException();
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

package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.lang.reflect.Array;
import java.util.Arrays;
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
            return 0;      //Setter variabel til 0
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
        int t = 0; //Hjelpevariabel

        for(int i = 0; i < a.length; i++){
            boolean equal = false; //Bool for å sjekke om to verdier er like
            for(int j = 0; j < i; j++){
                if(a[j] == a[i]){
                    equal = true;
                    break;
                }
            }
            if(!equal){
                t++;
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
        if(a.length > 1){
            char temp = a[a.length - 1]; //Lagrer siste element
            for(int i = a.length - 1; i > 0; --i){
                a[i] = a[i - 1]; //Forskyver elementene mot høyre
            }
            a[0] = temp; //Setter siste element som første
        }
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {

        StringBuilder ut = new StringBuilder();
        int i = 0;
        int j = 0;

        while(s.length() > i && t.length() > j){
            ut.append(s.charAt(i));
            ut.append(t.charAt(j));
            i++;
            j++;

        }
        while(s.length() <= i && t.length() > j){
            ut.append(t.charAt(j));
            j++;
        }
        while(s.length() > i){
            ut.append(s.charAt(i));
            i++;
        }
        return ut.toString();
    }

    /// 7b)
    public static String flett(String... s) {
        int maxLength = 0;

        //Finner største string
        for(int i = 0; i < s.length; i++){
            if(s[i].length() > maxLength){
                maxLength = s[i].length();
            }
        }

        StringBuilder u = new StringBuilder();
        for(int i = 1; maxLength >= i; i++){
            for(int j = 0; s.length - 1 >= j; j++){
                if(i <= s[j].length()){
                    u.append(s[j].charAt(i - 1));
                }
            }
        }
        return u.toString();
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

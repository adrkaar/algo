package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {

        if(a.length < 1) throw new NoSuchElementException("Tabellen er tom");

        int m = 0; //Hjelpevariabel maks

        for(int i = 1; i < a.length; i++){ //Starter på index en, og går gjennom tabellen
            if(a[m] > a[i]){ //Hvis a[m] er større enn a[i]
                bytt(a, i, m); //Hvis ja, bytter de plass
            }
            m++;
        }
        return a[a.length - 1]; //Returnerer den største verdien
    }

    //Hjelpe metode fra kompendiet
    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static int ombyttinger(int[] a) {
        if(a.length < 1) throw new java.util.NoSuchElementException("Tabellen er tom");
        int m = 0; //H
        int j = 0; //Hjelpevariabel for å holde telling på ombytninger

        for(int i = 1; i <a.length; i++){ //itererer gjennom tabellen
            if(a[m] > a[i]){ //Hvis a[m] har større verdi enn a[i]
                bytt(a,i,m); //Bytter plass
                j++;         //Verdien for antall ombyttninger øker
            }
            m++;
        }

        return j;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        for(int i = 1; i < a.length; i++){                                              //Ireterer gjennom tabellen
            if(a[i - 1] > a[i]){                                                        //Hvis første verdi er større en neste
                throw new IllegalStateException("Tabell er ikke sortert stigende");     //Så kastes en exception
            }
        }
        int t = 1; //Hjelpevariabel - teller

        if(a.length == 0){          //Sjekker om tabellen er tom
            return 0;              //Returnerer 0 om tabbelen har kun en verdi
        } else {
            for(int i = 0; i < a.length - 1; i++){  //Hvis tabbel ikke er tom, itererer den gjennom tabellen
                if(a[i] != a[i + 1]){               //Sjekker om plassering før er lik neste plassering
                    t++;                            //Hvis de ikke er like, øker teller
                }
            }
        }

        return t; //Returnerer antall ulike sortert
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int t = 0; //Hjelpevariabel - teller

        for(int i = 0; i < a.length; i++){ //iterer gjennom tabellen
            boolean equal = false;         //Bool for å sjekke om to verdier er ulike
            for(int j = 0; j < i; j++){    //Itererer gjennom a og i samtidig
                if(a[j] == a[i]){          //Hvis de er like settes den bolske verdien til true og fortsetter på neste iterasjon
                    equal = true;
                    break;
                }
            }
            if(!equal){                    //
                t++;
            }
        }
        return t;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {

        if(a.length < 1) return;

        int v = 0;            //Starter på første verdi - venstre
        int h = a.length - 1; //Starter på siste verdi - høyre
        int l = a.length;     //Lengde på tabell

        for(int i = 0; i < a.length; i++){      //itererer gjennom tabellen
            while((v < l) && (a[v] % 2) != 0 ){ //Hvis indeksen for v er mindre en tabell lengden OG det er oddetall
                v++;                            //Øker verdien for hjelpevariabel
            }
            while((h >= 0) && (a[h] % 2) == 0 ){ //Hvis indexen for h er større en eller lik 0 og a[h] er partall
                h--;                             //Minsker verdien for H
            }
            while(i < a.length){    //Bool for å sjekke om at loopen ikke kjører på siste iterasjon
                if (v < h){         //Hvis v verdien er mindre en h
                    bytt(a, v, h);  //Bytter om plassene på v og h
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
        //Sorterer partallene og odde tallene i stigende rekkefølge
        quicksort(a, v, l);
        quicksort(a,0, v);
    }


    //Hjelpemetoder fra kompendiet
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
        if(a.length > 1){                                   //Hvis tabellen er større enn en
            char temp = a[a.length - 1];                    //Lagrer siste element
            for(int i = a.length - 1; i > 0; --i){          //Itererer gjennom tabellen fra høyre til venstre
                a[i] = a[i - 1];                            //Forskyver elementene mot høyre
            }
            a[0] = temp;                                    //Setter siste element som første
        }
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {

        StringBuilder ut = new StringBuilder();      //Lager en stringbuilder med navn ut
        int i = 0;                                  //Hjelpevariabel for string s
        int j = 0;                                  //hjelpevariabel for string t

        while(s.length() > i && t.length() > j){     //Så lenge strengene ikke er tomme, så iterer dem gjennom
            ut.append(s.charAt(i));                 //Legger til verdien i s[i] på ut
            ut.append(t.charAt(j));                 //Legger til verdien i s[j] på ut
            i++;
            j++;

        }
        while(s.length() <= i && t.length() > j){  //Hvis s er større eller lik i lengde  og t er større en j i lengde
            ut.append(t.charAt(j));                //Så legges til verdiene til t[j] på ut.
            j++;
        }
        while(s.length() > i){                      //Hvis s er større enn enn i
            ut.append(s.charAt(i));                 //Legges s[i] på verdien ut
            i++;
        }
        return ut.toString();                       //Returnerer strengen flettet
    }

    /// 7b)
    public static String flett(String... s) {
        int maxLength = 0;                                      //Hjelpe verdi som lagrer den største strenger

        //Finner største string
        for(int i = 0; i < s.length; i++){
            if(s[i].length() > maxLength){
                maxLength = s[i].length();
            }
        }

        StringBuilder u = new StringBuilder();              //Lager en stringbuilder
        //Fletter
        for(int i = 1; maxLength >= i; i++){                //iterer så lenge j har lik eller mindre verdi enn den største strenger
            for(int j = 0; s.length - 1 >= j; j++){         //itererer gjennom s
                if(i <= s[j].length()){                     //Hvis i er større eller lik lengden på på plassering til s[j]
                    u.append(s[j].charAt(i - 1));           //Så legges til verdien på i - 1.
                }
            }
        }
        return u.toString();                                //Returnerer stringen
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

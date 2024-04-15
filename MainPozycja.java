class Pozycja {
    private final String nazwaTowaru;
    private final int ileSztuk;
    private final double cena;

    public Pozycja(String nazwaTowaru, int ileSztuk, double cena) {
        this.nazwaTowaru = nazwaTowaru;
        this.ileSztuk = ileSztuk;
        this.cena = cena;
    }

    public double obliczWartosc() {
        return ileSztuk * cena;
    }

    @Override
    public String toString() {
        return String.format("%-20s %10.2f zł %4d szt. %10.2f zł", nazwaTowaru, cena, ileSztuk, obliczWartosc());
    }
}

class Zamowienie {
    private final Pozycja[] pozycje;
    private int ileDodanych;
    private final int maksRozmiar;

    public Zamowienie() {
        this.maksRozmiar = 10;
        this.pozycje = new Pozycja[maksRozmiar];
    }

    public Zamowienie(int maksRozmiar) {
        this.maksRozmiar = maksRozmiar;
        this.pozycje = new Pozycja[maksRozmiar];
    }

    public void dodajPozycje(Pozycja pozycja) {
        if (ileDodanych < maksRozmiar) {
            pozycje[ileDodanych] = pozycja;
            ileDodanych++;
        } else {
            System.out.println("Przekroczono maksymalną liczbę pozycji w zamówieniu.");
        }
    }

    public double obliczWartosc() {
        double suma = 0;
        for (int i = 0; i < ileDodanych; i++) {
            suma += pozycje[i].obliczWartosc();
        }
        return suma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ileDodanych; i++) {
            sb.append(pozycje[i].toString()).append("\n");
        }
        sb.append(String.format("%-20s %10s zł %4s szt. %10.2f zł", "RAZEM:", "", "", obliczWartosc()));
        return sb.toString();
    }
}

public class MainPozycja {
    public static void main(String[] args) {
        Pozycja pozycja1 = new Pozycja("Cukier", 3, 4.00);
        Pozycja pozycja2 = new Pozycja("Mąka", 2, 3.50);
        Pozycja pozycja3 = new Pozycja("Chleb", 1, 2.00);

        Zamowienie zamowienie = new Zamowienie();
        zamowienie.dodajPozycje(pozycja1);
        zamowienie.dodajPozycje(pozycja2);
        zamowienie.dodajPozycje(pozycja3);

        System.out.println("Zamówienie:");
        System.out.println(zamowienie);
    }
}

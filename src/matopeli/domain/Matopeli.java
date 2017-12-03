package matopeli.domain;

import java.util.Random;

public class Matopeli {

    private int leveys;
    private int korkeus;
    private Mato mato;
    private Omena omena;

    public Matopeli(int x, int y) {
        this.leveys = x;
        this.korkeus = y;
        this.mato = new Mato(this.leveys / 2, this.korkeus / 2, Suunta.ALAS);
        this.omena = new Omena(new Random().nextInt(this.leveys), new Random().nextInt(this.korkeus));
        for (int i = 0; i < this.mato.getPalat().size(); i++) {
            if (this.omena.osuu(mato.getPalat().get(i))) {
                while (this.omena.osuu(mato.getPalat().get(i))){

                    int newX = new Random().nextInt(this.leveys);
                    int newY = new Random().nextInt(this.korkeus);
                    setOmena(new Omena(newX, newY));
                    i = 0;
                }
            }
        }

    }

    public Mato getMato() {
        return this.mato;
    }

    public Omena getOmena() {
        return this.omena;
    }

    @SuppressWarnings("Duplicates")
    public void setOmena(Omena omena) {

        this.omena = omena;
    }

    public void setMato(Mato mato) {
        this.mato = mato;
    }

    public boolean loppu() {
        int x = mato.getPalat().get(mato.getPalat().size() - 1).getX();
        int y = mato.getPalat().get(mato.getPalat().size() - 1).getY();


        if ((x - 1 < 0 || x + 1 > leveys) || (y - 1 < 0 || y + 1 > korkeus)) {
//            System.out.println("x = " + x +
//                    "y = " + y +
//                    "leveys = " + leveys +
//                    "korkeus = " + korkeus);
            return true;
        }


        if (mato.osuuItseensa()) {
            return true;
        }

        return false;
    }

    @SuppressWarnings("Duplicates")
    public void paivita() {


        if (loppu() == false) {
            this.mato.liiku();

        }

        if (this.mato.osuu(this.omena)) {
            this.mato.kasva();

            Omena uusi = new Omena(0, 0);
            boolean setOmena = false;

            while (setOmena == false) {
                setOmena = true;
                int newX = new Random().nextInt(this.leveys);
                int newY = new Random().nextInt(this.korkeus);
                uusi = new Omena(newX, newY);

                for (int i = 0; i < mato.getPalat().size(); i++) {
                    Pala pala = mato.getPalat().get(i);
                    if ((newX == pala.getX() && newY == pala.getY()) || ((newX < 0 || newX > leveys) || (newY < 0 || newY > korkeus))) {
                        setOmena = false;
                    }

                }


            }
            setOmena(uusi);


        }


    }


}

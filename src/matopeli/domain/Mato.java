package matopeli.domain;

import java.util.ArrayList;
import java.util.List;

public class Mato {
    private int x;
    private int y;
    private Suunta suunta;
    private List<Pala> palat;
    private boolean kasva;

    public Mato(int alkuX, int alkuY, Suunta alkusuunta) {
        this.x = alkuX;
        this.y = alkuY;
        this.suunta = alkusuunta;
        this.palat = new ArrayList<>();
        this.palat.add(new Pala(alkuX, alkuY));
        this.kasva = false;
    }


    public Suunta getSuunta() {
        return this.suunta;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    public int getPituus() {
        return this.palat.size();
    }

    public List<Pala> getPalat() {
        return this.palat;
    }

    public void liiku() {
        int x = this.palat.get(this.palat.size() - 1).getX();
        int y = this.palat.get(this.palat.size() - 1).getY();


        switch (this.suunta) {
            case YLOS:

                this.palat.add(new Pala(x, y - 1));
                if (getPituus() > 3 && this.kasva == false) {

                    this.palat.remove(0);
                }
                break;

            case ALAS:

                this.palat.add(new Pala(x, y + 1));
                if (getPituus() > 3 && this.kasva == false) {

                    this.palat.remove(0);
                }

                break;

            case OIKEA:
                this.palat.add(new Pala(x + 1, y));
                if (getPituus() > 3 && this.kasva == false) {

                    this.palat.remove(0);
                }


                break;

            case VASEN:
                this.palat.add(new Pala(x - 1, y));
                if (getPituus() > 3 && this.kasva == false) {

                    this.palat.remove(0);
                }
                break;

        }
        if (this.kasva) {
            this.kasva = false;
        }


    }

    public void kasva() {
        if (getPituus() < 2) {
            return;
        }
        this.kasva = true;

    }


    public boolean osuu(Pala pala) {

        for (int i = 0; i < this.palat.size(); i++) {


            if (pala.osuu(this.palat.get(i))) {
                return true;
            }
        }


        return false;
    }

    public boolean osuuItseensa() {
        for (int i = 0; i < this.palat.size(); i++) {
            Pala listapala = palat.get(i);
//            int y = palat.get(i);

            for (int j = 0; j < this.palat.size(); j++) {
                if (i != j) {
                    if (this.palat.get(j).osuu(listapala)) {
                        return true;
                    }
                }
            }


        }
        return false;
    }


}

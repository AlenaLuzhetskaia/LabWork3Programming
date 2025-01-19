package people;

import location.Place;
import type.Profession;

public class Neznayka extends Shortie {
    private boolean hidden;

    public Neznayka(String name, String sex, float mass, String clothers, Place location, Profession profession) {
        super(name, sex, mass, clothers, location, profession);
        this.hidden = true;
    }

    public void hide() throws exception.NeznaykaException {
        if (hidden) {
            throw new exception.NeznaykaException("Незнайка");
        } else {
            hidden = true;
            System.out.print("Незнайка спрятался");
        }
    }

    public String getOut() {
        if (hidden) {
            hidden = false;
            return " вылезал";
        }
        return "";
    }

    public String say(String voice) {
        return " сказал:" + voice;
    }
}

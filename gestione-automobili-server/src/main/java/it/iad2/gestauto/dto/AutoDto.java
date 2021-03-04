package it.iad2.gestauto.dto;

import it.iad2.gestauto.model.Automobile;

public class AutoDto {

    private Automobile auto;

    public AutoDto() {
    }

    public AutoDto(Automobile auto) {
        this.auto = auto;
    }

    public Automobile getAuto() {
        return auto;
    }

    public void setAuto(Automobile auto) {
        this.auto = auto;
    }

    @Override
    public String toString() {
        return "AutoDto{" + "auto=" + auto + '}';
    }

}

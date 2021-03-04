package it.iad2.gestauto.dto;

import it.iad2.gestauto.model.Automobile;
import java.util.List;

public class ListeAutoDto {

    private List<Automobile> listaAuto;

    public ListeAutoDto() {
    }

    public ListeAutoDto(List<Automobile> listaAuto) {
        this.listaAuto = listaAuto;
    }

    public List<Automobile> getListaAuto() {
        return listaAuto;
    }

    public void setListaAuto(List<Automobile> listaAuto) {
        this.listaAuto = listaAuto;
    }

    @Override
    public String toString() {
        return "ListeAutoDto{" + "listaAuto=" + listaAuto + '}';
    }

}

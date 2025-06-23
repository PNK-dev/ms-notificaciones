package com.upeu.notificaciones.services.models;

import java.util.Map;

public class EmailDTO {
    private String destinatario;
    private String plantilla;

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(String plantilla) {
        this.plantilla = plantilla;
    }
}

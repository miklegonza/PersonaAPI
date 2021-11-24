package co.edu.usbbog.personaapi.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AmigosPK implements Serializable {
    private int persona;
    private int amigo;

    @Column(name = "PERSONA", nullable = false)
    @Id
    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    @Column(name = "AMIGO", nullable = false)
    @Id
    public int getAmigo() {
        return amigo;
    }

    public void setAmigo(int amigo) {
        this.amigo = amigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmigosPK amigosPK = (AmigosPK) o;
        return persona == amigosPK.persona && amigo == amigosPK.amigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(persona, amigo);
    }
}

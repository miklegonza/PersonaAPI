package co.edu.usbbog.personaapi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(AmigosPK.class)
public class Amigos {
    private int persona;
    private int amigo;
    private Persona personaByPersona;
    private Persona personaByAmigo;

    @Id
    @Column(name = "PERSONA", nullable = false)
    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    @Id
    @Column(name = "AMIGO", nullable = false)
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
        Amigos amigos = (Amigos) o;
        return persona == amigos.persona && amigo == amigos.amigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(persona, amigo);
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA", referencedColumnName = "CEDULA", nullable = false)
    public Persona getPersonaByPersona() {
        return personaByPersona;
    }

    public void setPersonaByPersona(Persona personaByPersona) {
        this.personaByPersona = personaByPersona;
    }

    @ManyToOne
    @JoinColumn(name = "AMIGO", referencedColumnName = "CEDULA", nullable = false)
    public Persona getPersonaByAmigo() {
        return personaByAmigo;
    }

    public void setPersonaByAmigo(Persona personaByAmigo) {
        this.personaByAmigo = personaByAmigo;
    }
}

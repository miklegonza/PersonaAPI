package co.edu.usbbog.personaapi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Correo {
    private String email;
    private String servidor;
    private String pass;
    private Persona personaByPropietario;

    @ManyToOne
    @JoinColumn(name = "propietario_cedula")
    private Persona propietario;

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    @Id
    @Column(name = "EMAIL", nullable = false, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "SERVIDOR", nullable = false, length = 50)
    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    @Basic
    @Column(name = "PASS", nullable = false, length = 50)
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Correo correo = (Correo) o;
        return Objects.equals(email, correo.email) && Objects.equals(servidor, correo.servidor) && Objects.equals(pass, correo.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, servidor, pass);
    }

    @ManyToOne
    @JoinColumn(name = "PROPIETARIO", referencedColumnName = "CEDULA", nullable = false)
    public Persona getPersonaByPropietario() {
        return personaByPropietario;
    }

    public void setPersonaByPropietario(Persona personaByPropietario) {
        this.personaByPropietario = personaByPropietario;
    }
}

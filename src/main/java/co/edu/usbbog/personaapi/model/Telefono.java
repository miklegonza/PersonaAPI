package co.edu.usbbog.personaapi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Telefono {
    private int numero;
    private String operador;
    private Integer saldo;
    private Persona personaByPropietario;

    @Id
    @Column(name = "NUMERO", nullable = false)
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "OPERADOR", nullable = false, length = 30)
    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    @Basic
    @Column(name = "SALDO", nullable = true)
    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono = (Telefono) o;
        return numero == telefono.numero && Objects.equals(operador, telefono.operador) && Objects.equals(saldo, telefono.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, operador, saldo);
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

package co.edu.usbbog.personaapi.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(catalog = "persona_db", schema = "persona_db", name = "persona")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
        @NamedQuery(name = "Persona.findByCc", query = "SELECT p FROM Persona p WHERE p.cedula = :cedula"),
        @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
        @NamedQuery(name = "Persona.findByApellido", query = "SELECT p FROM Persona p WHERE p.apellido = :apellido"),
        @NamedQuery(name = "Persona.findByEdad", query = "SELECT p FROM Persona p WHERE p.edad = :edad"),
        @NamedQuery(name = "Persona.findByGenero", query = "SELECT p FROM Persona p WHERE p.genero = :genero")
})
public class Persona {

    @Id
    @Column(nullable = false)
    private int cedula;
    @Basic
    @Column(nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(nullable = false, length = 45)
    private String apellido;
    @Basic
    @Column(nullable = true)
    private Integer edad;
    @Basic
    @Column(nullable = true, length = 10)
    private String genero;
    @JoinTable(
            name = "amigos",
            joinColumns = {
                    @JoinColumn(name = "amigo", referencedColumnName = "CEDULA", nullable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "persona", referencedColumnName = "CEDULA", nullable = false)
            }
    )
    @ManyToMany
    private Collection<Amigos> amigos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "PROPIETARIO")
    private Collection<Correo> correos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "PROPIETARIO")
    private Collection<Telefono> telefonos;

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return cedula == persona.cedula &&
                Objects.equals(nombre, persona.nombre) &&
                Objects.equals(apellido, persona.apellido) &&
                Objects.equals(edad, persona.edad) &&
                Objects.equals(genero, persona.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula, nombre, apellido, edad, genero);
    }

    @OneToMany(mappedBy = "personaByPersona")
    public Collection<Amigos> getAmigos() {
        return amigos;
    }

    public void setAmigos(Collection<Amigos> amigos) {
        this.amigos = amigos;
    }

    @OneToMany(mappedBy = "personaByPropietario")
    public Collection<Correo> getCorreos() {
        return correos;
    }

    public void setCorreos(Collection<Correo> correos) {
        this.correos = correos;
    }

    @OneToMany(mappedBy = "personaByPropietario")
    public Collection<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Collection<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "cedula = " + cedula + ", " +
                "nombre = " + nombre + ", " +
                "apellido = " + apellido + ", " +
                "edad = " + edad + ", " +
                "genero = " + genero + ", " +
                "amigos = " + amigos + ", " +
                "correos = " + correos + ", " +
                "telefonos = " + telefonos + ")";
    }
}

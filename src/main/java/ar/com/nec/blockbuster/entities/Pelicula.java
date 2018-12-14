package ar.com.nec.blockbuster.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Pelicula")
public class Pelicula {

    @Column(name = "nombre")
    private String nombre = "";

    @ManyToOne
    @JoinColumn(name="idGenero", nullable=false)
    private Genero genero;

    @Id
    @GeneratedValue
    @Column(name = "idPelicula")
    private int idPelicula;


    public Pelicula(){}
    public Pelicula(String nombre, Genero genero) {
        this.nombre = nombre;
        this.genero = genero;
    }

    @ManyToMany(mappedBy = "peliculas")
    private Set<Cliente> clientes = new HashSet<>();

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String toString() {
        return "\n\tNombre de pelicula..: "+nombre+"\n\tGenero de pelicula..: "+genero;
    }

}

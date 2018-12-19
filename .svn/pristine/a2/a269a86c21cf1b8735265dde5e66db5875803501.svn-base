package ar.com.nec.blockbuster.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "generos")
public class Genero {

    @Id
    @GeneratedValue
    @Column(name = "idGenero")
    private int idGenero;

    @Column(name = "nombre")
    private String nombre = "";

    @OneToMany(mappedBy="genero")
    private Set<Pelicula> peliculas;

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Genero(){}
    public Genero(String nombre){
        this.nombre=nombre;
    }
}

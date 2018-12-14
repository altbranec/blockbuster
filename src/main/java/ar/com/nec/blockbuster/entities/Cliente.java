package ar.com.nec.blockbuster.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue
    @Column(name = "idCliente")
    private int idCliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "dni")
    private int dni;


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Alquileres",
            joinColumns = { @JoinColumn(name = "idCliente") },
            inverseJoinColumns = { @JoinColumn(name = "idPelicula") }
    )
    private Set<Pelicula> peliculas = new HashSet<>();


    public Cliente(){}
    public Cliente(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void addAlquiler(Pelicula pelicula) { peliculas.add(pelicula);}

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }


    public Set<Pelicula> getAlquileres() {
        return peliculas;
    }


    public String misPeliculas() {
        String result = getAlquileres().stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        return result;
    }
    public String toString() {
        return "Nombre..: "+nombre+"\nDni..: "+dni+"\nLista de peliculas..: "+misPeliculas();
    }



}
package co.edu.ufps.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.entities.Empleado;
import co.edu.ufps.entities.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula,Integer>{
//	List<Pelicula> findByNombre(String pelicula);
}

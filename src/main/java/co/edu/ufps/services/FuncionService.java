package co.edu.ufps.services;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Funcion;
import co.edu.ufps.repositories.FuncionRepository;


@Service
public class FuncionService {

	@Autowired
	FuncionRepository funcionRepository;
	
	 // Listar todas las funciones
	public List<Funcion> list() {
		return funcionRepository.findAll();
	}
	
	 // Crear una nueva función
	public Funcion create(Funcion funcion) {
	    CrudRepository<Funcion, Integer> peliculaRepository;
		// Verificar si la película asociada existe
	    Optional<Pelicula> peliculaExistente = peliculaRepository.findById(funcion.getPelicula().getId());

	    if (peliculaExistente.isPresent()) {
	        // Si la película existe, asociamos la película existente con la función
	        funcion.setPelicula(peliculaExistente.get());
	        return funcionRepository.save(funcion);
	    } else {
	        // Si la película no existe, retornamos un error o una respuesta adecuada
	        throw new RuntimeException("La película no existe.");
	    }
	}


	// Obtener un funcion por ID
	public Optional<Funcion> getById(Integer id) {
		return funcionRepository.findById(id);
	}

	// Actualizar un funcion existente
	public Optional<Funcion> update(Integer id, Funcion funcionDetails) {
		Optional<Funcion> optionalfuncion = funcionRepository.findById(id);
		if (!optionalfuncion.isPresent()) {
			return Optional.empty();
		}

		Funcion funcion = optionalfuncion.get();

		// Actualiza otros campos según sea necesario
		funcion.setHorario(funcion.getHorario());
		funcion.setFecha(funcion.getFecha());
		funcion.setSala(funcion.getSala());

		return Optional.of(funcionRepository.save(funcion));
	}

	// Eliminar un funcion por ID
	public boolean delete(Integer id) {
		if (!funcionRepository.existsById(id)) {
			return false;
		}

		funcionRepository.deleteById(id);
		return true;
	}
	
//	// Obtener funciones por fecha específica
//    public List<Funcion> findByFecha(Date fecha) {
//        return funcionRepository.findByFecha(fecha);
//    }
//    
// // Obtener funciones por horario específico
//    public List<Funcion> findByHorario(Time horario) {
//        return funcionRepository.findByHorario(horario);
//    }
      
    
}

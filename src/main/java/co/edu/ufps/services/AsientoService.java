//package co.edu.ufps.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import co.edu.ufps.entities.Asiento;
//import co.edu.ufps.entities.Boleto;
//import co.edu.ufps.repositories.AsientoRepository;
//import co.edu.ufps.repositories.BoletoRepository;
//
//@Service
//public class AsientoService {
//
//    @Autowired
//    private AsientoRepository asientoRepository;
//
////    @Autowired
////    private BoletoRepository boletoRepository;
//
//    /**
//     * Lista todos los asientos en el sistema.
//     * 
//     * @return Lista de todos los asientos.
//     */
//    public List<Asiento> list() {
//        return asientoRepository.findAll();
//    }
//
//    /**
//     * Crea un nuevo asiento.
//     * 
//     * @param asiento El asiento a crear.
//     * @return El asiento creado.
//     */
//    public Asiento create(Asiento asiento) {
//        return asientoRepository.save(asiento);
//    }
//
//    /**
//     * Obtiene un asiento por su ID.
//     * 
//     * @param id ID del asiento.
//     * @return El asiento, si está presente.
//     */
//    public Optional<Asiento> getById(Integer id) {
//        return asientoRepository.findById(id);
//    }
//
//    /**
//     * Actualiza un asiento existente con los detalles proporcionados.
//     * 
//     * @param id             ID del asiento a actualizar.
//     * @param asientoDetails Detalles actualizados del asiento.
//     * @return El asiento actualizado, si está presente.
//     */
//    public Optional<Asiento> update(Integer id, Asiento asientoDetails) {
//        Optional<Asiento> optionalAsiento = asientoRepository.findById(id);
//        if (!optionalAsiento.isPresent()) {
//            return Optional.empty();
//        }
//
//        Asiento asiento = optionalAsiento.get();
////        asiento.setLetra(asientoDetails.getLetra());
////        asiento.setNumero_asiento(asientoDetails.getNumero_asiento());
////        asiento.setSala(asientoDetails.getSala());
//        asiento.setEstado(asientoDetails.getEstado());
//
//        return Optional.of(asientoRepository.save(asiento));
//    }
//
//    /**
//     * Elimina un asiento por su ID.
//     * 
//     * @param id ID del asiento a eliminar.
//     * @return true si el asiento fue eliminado, false si no existe.
//     */
//    public boolean delete(Integer id) {
//        if (!asientoRepository.existsById(id)) {
//            return false;
//        }
//        asientoRepository.deleteById(id);
//        return true;
//    }
//
////    public Asiento addBoleto(Integer id, Integer boletoId) {
////        Optional<Asiento> asientoOpt = asientoRepository.findById(id);
////        if (asientoOpt.isPresent()) {
////            Asiento asiento = asientoOpt.get();
////            Optional<Boleto> boletoOpt = boletoRepository.findById(boletoId);
////            boletoOpt.ifPresent(asiento::addBoleto);
////            return asientoRepository.save(asiento);
////        }
////        return null;
////    }
//
////    public List<Asiento> findBySala(Integer salaId) {
////        return asientoRepository.findBySalaId(salaId);
////    }
//
//    public List<Asiento> updateEstadoMultiple(List<Integer> ids, String nuevoEstado) {
//        List<Asiento> asientos = asientoRepository.findAllById(ids);
//        asientos.forEach(asiento -> asiento.getEstado().setDescripcion(nuevoEstado));
//        return asientoRepository.saveAll(asientos);
//    }
//
//    public boolean isAvailable(Integer id) {
//        Optional<Asiento> asiento = asientoRepository.findById(id);
//        return asiento.isPresent() && "Disponible".equalsIgnoreCase(asiento.get().getEstado().getDescripcion());
//    }
//
//    public Optional<Asiento> releaseAsiento(Integer id) {
//        Optional<Asiento> asientoOpt = asientoRepository.findById(id);
//        if (asientoOpt.isPresent()) {
//            Asiento asiento = asientoOpt.get();
//            asiento.getEstado().setDescripcion("Disponible");
//            return Optional.of(asientoRepository.save(asiento));
//        }
//        return Optional.empty();
//    }
//
//    
//}
//package co.edu.ufps.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import co.edu.ufps.entities.Boleto;
//import co.edu.ufps.entities.CategoriaBoleto;
//import co.edu.ufps.repositories.BoletoRepository;
//import co.edu.ufps.repositories.CategoriaBoletoRepository;
//
//@Service
//public class CategoriaBoletoService {
//
//    @Autowired
//    private CategoriaBoletoRepository categoriaBoletoRepository;
//
//    @Autowired
//    private BoletoRepository boletoRepository;
//
//    /**
//     * Lista todas las categorías de boletos en el sistema.
//     * 
//     * @return Lista de todas las categorías de boletos.
//     */
//    public List<CategoriaBoleto> list() {
//        return categoriaBoletoRepository.findAll();
//    }
//
//    /**
//     * Crea una nueva categoría de boleto.
//     * 
//     * @param categoriaBoleto La categoría de boleto a crear.
//     * @return La categoría de boleto creada.
//     */
//    public CategoriaBoleto create(CategoriaBoleto categoriaBoleto) {
//        return categoriaBoletoRepository.save(categoriaBoleto);
//    }
//
//    /**
//     * Obtiene una categoría de boleto por su ID.
//     * 
//     * @param id ID de la categoría de boleto.
//     * @return La categoría de boleto, si está presente.
//     */
//    public Optional<CategoriaBoleto> getById(Integer id) {
//        return categoriaBoletoRepository.findById(id);
//    }
//

//    public Optional<CategoriaBoleto> update(Integer id, CategoriaBoleto categoriaBoletoDetails) {
//        Optional<CategoriaBoleto> optionalCategoriaBoleto = categoriaBoletoRepository.findById(id);
//        if (!optionalCategoriaBoleto.isPresent()) {
//            return Optional.empty();
//        }
//
//        CategoriaBoleto categoriaBoleto = optionalCategoriaBoleto.get();
//        categoriaBoleto.setDescripcion(categoriaBoletoDetails.getDescripcion());
//        categoriaBoleto.setPrecio(categoriaBoletoDetails.getPrecio());
//
//        return Optional.of(categoriaBoletoRepository.save(categoriaBoleto));
//    }
//
//    public boolean delete(Integer id) {
//        if (!categoriaBoletoRepository.existsById(id)) {
//            return false;
//        }
//        categoriaBoletoRepository.deleteById(id);
//        return true;
//    }
//

//    public List<Boleto> getBoletosByCategoria(Integer categoriaId) {
//        Optional<CategoriaBoleto> categoriaBoletoOpt = categoriaBoletoRepository.findById(categoriaId);
//        if (categoriaBoletoOpt.isPresent()) {
//            return categoriaBoletoOpt.get().getBoletos();
//        }
//        return List.of(); // Retorna una lista vacía si no se encuentra la categoría
//    }
//
//    public Optional<CategoriaBoleto> addBoletoToCategoria(Integer categoriaId, Boleto boleto) {
//        Optional<CategoriaBoleto> categoriaBoletoOpt = categoriaBoletoRepository.findById(categoriaId);
//        if (categoriaBoletoOpt.isPresent()) {
//            CategoriaBoleto categoriaBoleto = categoriaBoletoOpt.get();
//            boleto.setCategoriaBoleto(categoriaBoleto); // Asociar el boleto con la categoría
//            boletoRepository.save(boleto); // Guardar el boleto
//            categoriaBoleto.getBoletos().add(boleto); // Agregar el boleto a la lista en la categoría
//            return Optional.of(categoriaBoletoRepository.save(categoriaBoleto)); // Guardar la categoría actualizada
//        }
//        return Optional.empty(); // Retorna vacío si no se encuentra la categoría
//    }
//}

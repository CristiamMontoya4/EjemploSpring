package com.example.persistance.crud;

import com.example.persistance.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> { //usa como parametros la taba y tipo de dato para el Id

    //Esto es una forma de hacer la consulta directa y el metodo se puedo nombre de cualquier manera
   // @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);  // se respeta el camelCase, pero en el parentesis se pone como en el atributo de la clase

    // Los query methods tambien soportan los operadores opcionales de las nuevas versiones de java
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}

package com.example.persistance;

import com.example.domain.Product;
import com.example.domain.repository.ProductRepository;
import com.example.persistance.crud.ProductoCrudRepository;
import com.example.persistance.entity.Producto;
import com.example.persistance.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository  //Esta anotación es un estereotipo de spring, indicando que esta clase se encarga de interactuar con la BD, debe ir en la implementación de la interfaz
public class ProductoRepository implements ProductRepository {
    @Autowired //Con esta notación, se le permite a spring crear la estancia de ese objeto
    private ProductoCrudRepository productoCrudRepository;

    @Autowired //solo se puede usar en componentes de spring, en este caso viene de CrudRepositorio, el cual contiene @NoRepositoryBean,
    // que es un esteriotipo de repositorio de spring
    private ProductMapper mapper; // EN el caso de mapper se le indica que es un componente de spring

    @Override
    public List<Product> getAll() {  // el metodo proviene de CrudRepository
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return  mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }

}

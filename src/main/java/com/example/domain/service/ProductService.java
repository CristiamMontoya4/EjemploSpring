package com.example.domain.service;

import com.example.domain.Product;
import com.example.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Esta capa de servicio, sirve como un intermediario entre el controlador y la capa del repositorio

@Service //puede ser component, pero la anotación explica mejor que aquí va la lógica de negocio
public class ProductService {
    @Autowired //Internamente inicializara, esto se puede ya que su implementación de productorepository, si tiene las anotaciones correspondientes
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {   //esperamos un boolean que me confirme la eliminación del producto
        // De esta forma busca el producto y cuando lo encuentre lo elimina, en caso contrario retorna falso
        /*return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);  */

        //De esta forma pregunta si el producto esta presente, en caso de ser verdadero lo elimina y retorna un true, de lo contratio retorna un false
        if (getProduct(productId).isPresent()) {
            productRepository.delete(productId);
            return true;
        }else {
            return false;
        }
    }

}

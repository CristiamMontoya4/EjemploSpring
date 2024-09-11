package com.example.web.controller;

import com.example.domain.Product;
import com.example.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Indica que esta clase hara parte de una Api Rest
@RequestMapping("/products")  //se establece la ruta que recibira las  peticiones que se le hagan
//SI quiere que funcione se debe poner inicialmente /platzi-market/api, que esta en application.properties
public class ProductController {
    @Autowired //se puede usar porque product service tiene relación con notaciones de spring
    private ProductService productService;

    @GetMapping("/all") //permite obetener información
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    //Trae el producto pero la categora como null
    @GetMapping("/{id}") //las llaves indican una vatiable que va a recibir
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId) {  //la notación pathvariable indica que reciba el id de la url para ingresar como parametro para la función
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))// si existe un producto enviara unhttp esattus 200 y los productos
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));  //si no existe un producto devuelve un not found
    }

    //Trae los productos pero el campo categoriy como null
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        final Optional<List<Product>> products = productService.getByCategory(categoryId);

        if (products.isPresent() && !products.get().isEmpty()) {
            return new ResponseEntity<>(products.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/quantity/{quantity}")
    public ResponseEntity<List<Product>> getScarseProducts(@PathVariable("quantity") int quantity) {
        final Optional<List<Product>> products = productService.getScarseProducts(quantity);
        if (products.isPresent() && !products.get().isEmpty()) {
            return new ResponseEntity<>(products.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save") //el postmapping, establece una petición post
    public ResponseEntity<Product> save(@RequestBody Product product) {  //Con el request body, permite leer el body, donde es la información para crear el producto
        //Ejemplo del Json para el body {"name": "Mango2", "categoryId": 1, "price": 2100.0, "stock": 250, "active": true }
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);  //El http status created, indica que el producto fue creado
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId) {
        if(productService.delete(productId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

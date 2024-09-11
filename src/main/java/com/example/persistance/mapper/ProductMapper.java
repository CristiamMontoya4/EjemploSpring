package com.example.persistance.mapper;

import com.example.domain.Product;
import com.example.persistance.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            // cuando vaya a convertir categoria a category, use el category mapper establecido en el mapper
            /*@Mapping(source = "categoria", target = "category")*/
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos); //Internamente MapStruct entiende que se debe comportar de la misma manera, como si se tratara de mappings

    //entiende que debe ignorar el codigo de barras
    @InheritInverseConfiguration
   /* @Mapping(target = "codigoBarras", ignore = true)*/
    Producto toProducto(Product product);

}

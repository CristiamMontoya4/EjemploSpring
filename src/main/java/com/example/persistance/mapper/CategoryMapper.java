package com.example.persistance.mapper;

import com.example.domain.Category;
import com.example.persistance.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"), //me recibe el idCategoria para pasarlo a categoryId
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria); //vamos a convertir una categoria a una category

    @InheritInverseConfiguration  //MapStruct, con esta notación, sabe que debe hacer el mapeo a la inverza
    @Mapping(target = "productos", ignore = true) //En este caso categoria tiene productos, pero category no lo tiene, por eso lo ignoramos
    Categoria toCategoria(Category category);
}

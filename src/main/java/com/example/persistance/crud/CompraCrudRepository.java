package com.example.persistance.crud;

import com.example.persistance.entity.Compra;
import org.springframework.data.repository.CrudRepository;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
}

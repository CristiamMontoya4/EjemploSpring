package com.example.domain.service;

import com.example.domain.Purchase;
import com.example.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository repo;

    public List<Purchase> getAll(){
        return repo.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId){
        return repo.getByClient(clientId);
    }

    public Purchase save(Purchase purchase) {
        return repo.save(purchase);
    }
}

package com.example.demo.services;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.example.demo.entities.ProductEntity;

@Service
public class ProductService {
    private List<ProductEntity> products;

    public ProductService() {
        this.products = new ArrayList<>();

        products.add(new ProductEntity("Base líquida", "Base", 1000.00, 50));
        products.add(new ProductEntity("Sombra de ojos", "Ojos", 150.00, 30));
        products.add(new ProductEntity("Labial", "Labios", 500.00, 15));
    }

    // Obtener todos los productos
    public List<ProductEntity> getAllProducts() {
        return products;
    }

    // Obtener producto por ID
    public Optional<ProductEntity> getProductById(UUID id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    // Crear un nuevo producto
    public ProductEntity createProduct(ProductEntity product) {
        products.add(product);
        return product;
    }

    // Actualizar un producto existente
    public Optional<ProductEntity> updateProduct(UUID id, ProductEntity updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                updatedProduct.setId(id); // Mantener el ID existente
                products.set(i, updatedProduct);
                return Optional.of(updatedProduct);
            }
        }
        return Optional.empty();
    }

    // Eliminar un producto por ID
    public boolean deleteProduct(UUID id) {
        return products.removeIf(p -> p.getId().equals(id));
    }
}

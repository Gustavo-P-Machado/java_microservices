package br.edu.atitus.product_service.dtos;

import br.edu.atitus.product_service.entities.ProductType;

public record ProductDTO(String description,
                         String brand,
                         String model,
                         String currency,
                         String price,
                         String imageUrl,
                         ProductType type
                         ) {
}

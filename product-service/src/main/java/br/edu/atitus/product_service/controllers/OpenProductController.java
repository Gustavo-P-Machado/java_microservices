package br.edu.atitus.product_service.controllers;

import br.edu.atitus.product_service.entities.ProductEntity;
import br.edu.atitus.product_service.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class OpenProductController {

    private final ProductRepository repository;

    public OpenProductController(ProductRepository repository) {
        super();
        this.repository = repository;
    }

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/{idProduct}/{targetCurrency}")
    public ResponseEntity<ProductEntity> getProduct(
            @PathVariable Long idProduct,
            @PathVariable String targetCurrency) throws Exception{

        ProductEntity product = repository.findById(idProduct).
                orElseThrow(() -> new Exception("Produto Não Encontrado"));

        product.setEnvironment("Product-Service running on port: " + serverPort);
        product.setConvertedPrice(product.getPrice()); // MOCK = Apenas para testes

        return ResponseEntity.ok(product);
    }
}

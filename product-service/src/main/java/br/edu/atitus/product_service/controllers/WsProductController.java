package br.edu.atitus.product_service.controllers;

import br.edu.atitus.product_service.dtos.ProductDTO;
import br.edu.atitus.product_service.entities.ProductEntity;
import br.edu.atitus.product_service.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/ws/product")
public class WsProductController {

    private final ProductRepository repository;

    public WsProductController(ProductRepository repository) {
        super();
        this.repository = repository;
    }

    private ProductEntity convertDtoToEntity(ProductDTO dto) {
        var product = new ProductEntity();
        BeanUtils.copyProperties(dto, product);
        return product;
    }

    @PostMapping
    public ResponseEntity<ProductEntity> post(
            @RequestBody ProductDTO dto,
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Email") String userEmail,
            @RequestHeader("X-User-Type") Integer userType) throws Exception {

        //Somente usuários autorizados
        //TODO - Adicionar novo tipo de usuário no AuthService para tipo de vendedor, também autorizado aqui
        if (userType != 0) {
            throw new AuthenticationException("Usuário sem permissão");
        }

        var product = convertDtoToEntity(dto);
        product.setStock(10);

        repository.save(product);

        return ResponseEntity.status(201).body(product);
    }


    @PutMapping("/{idProduct}")
    public ResponseEntity<ProductEntity> put(
            @PathVariable Long idProduct,
            @RequestBody ProductDTO dto,
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Email") String userEmail,
            @RequestHeader("X-User-Type") Integer userType) throws Exception {

        //Somente usuários autorizados
        //TODO - Adicionar novo tipo de usuário no AuthService para tipo de vendedor, também autorizado aqui
        if (userType != 0) {
            throw new AuthenticationException("Usuário sem permissão");
        }

        var product = convertDtoToEntity(dto);
        product.setId(idProduct);
        product.setStock(10);

        repository.save(product);

        return ResponseEntity.status(200).body(product);
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<String> delete(
            @PathVariable Long idProduct,
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("X-User-Email") String userEmail,
            @RequestHeader("X-User-Type") Integer userType) throws Exception {

        //Somente usuários autorizados
        //TODO - Adicionar novo tipo de usuário no AuthService para tipo de vendedor, também autorizado aqui
        if (userType != 0) {
            throw new AuthenticationException("Usuário sem permissão");
        }

        repository.deleteById(idProduct);

        return ResponseEntity.ok("Produto Excluído com sucesso");
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handlerAuth(AuthenticationException e) {
        String message = e.getMessage().replaceAll("[\\r\\n]","");
        return ResponseEntity.status(403).body(message);

    }

}

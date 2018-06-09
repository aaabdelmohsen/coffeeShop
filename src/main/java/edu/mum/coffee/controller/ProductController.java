package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    Response response;

    @PostMapping("create")
    public Response createProduct(@RequestBody Product product) {
        Product productRes = productService.save(product);
        if (productRes != null) {
            response.setErrorCode(200);
            response.setMessage("Success, Product was added with ID: " + productRes.getId());
        } else {
            response.setErrorCode(400);
            response.setMessage("The request did not execute as expected.");
        }
        return response;
    }

    @GetMapping("list")
    public List<Product> listAllProducts() {
        return productService.getAllProduct();
    }

    @PutMapping("update")
    public Response updateProduct(@RequestBody Product product) {
        Product productRes = productService.save(product);
        if (productRes != null) {
            response.setErrorCode(200);
            response.setMessage("Success, Product was updated with ID: " + productRes.getId());
        } else {
            response.setErrorCode(400);
            response.setMessage("The request did not execute as expected.");
        }
        return response;
    }

    @DeleteMapping("delete")
    public Response deleteProduct(@RequestBody Product product) {
        try {
            productService.delete(product);
            response.setErrorCode(200);
            response.setMessage("Success, Product was deleted");
        } catch (Exception ex) {
            response.setErrorCode(400);
            response.setMessage("Something went wrong, try again later.");
        }
        return response;
    }

    @GetMapping("getProductById/{productId}")
    public Product getProductById(@PathVariable int productId) {
        return productService.findById(productId);
    }
}

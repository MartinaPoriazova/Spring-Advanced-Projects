package bg.softuni.errors.web;

import bg.softuni.errors.model.ApiErrorDTO;
import bg.softuni.errors.model.ProductDTO;
import bg.softuni.errors.model.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id) {
        ProductDTO productDTO = getProductDTOById(id);

        if (productDTO == null) {
            throw new ProductNotFoundException(id);
        }

        return ResponseEntity.
                ok(productDTO);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ProductNotFoundException.class})
    public @ResponseBody ApiErrorDTO handleRESTErrors(ProductNotFoundException e) {
        return new ApiErrorDTO(e.getId(), "Product was not found!");
    }


    private ProductDTO getProductDTOById(Long id) {
        return null;
    }
}

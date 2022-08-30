package bg.softuni.errors.web;

import bg.softuni.errors.model.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product")
@Controller
public class ProductController {

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id,
                                 Model model) {
        ProductDTO productDTO = getProductDTOById(id);

        model.addAttribute("name", productDTO.getName());

        return "product";
    }

    private ProductDTO getProductDTOById(Long id) {
        return null;
    }
}

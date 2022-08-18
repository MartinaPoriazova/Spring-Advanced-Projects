package bg.softuni.errors.web;

import bg.softuni.errors.model.ProductDTO;
import bg.softuni.errors.model.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/category")
@Controller
public class CategoryController {

    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable("id") Long id, Model model) {
        ProductDTO productDTO = getProductDTOById(id);

        if (productDTO == null) {
            throw new ProductNotFoundException(id);
        }

        model.addAttribute("name", productDTO.getName());

        return "category";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({ProductNotFoundException.class})
    public ModelAndView onCategoryNotFound(ProductNotFoundException productNotFoundException) {
        ModelAndView modelAndView = new ModelAndView("category-not-found");
        modelAndView.addObject("categoryId", productNotFoundException.getId());

        return modelAndView;
    }

    private ProductDTO getProductDTOById(Long id) {
        return null;
    }
}

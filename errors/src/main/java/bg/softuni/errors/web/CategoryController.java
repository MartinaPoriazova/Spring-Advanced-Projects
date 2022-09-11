package bg.softuni.errors.web;

import bg.softuni.errors.model.CategoryDTO;
import bg.softuni.errors.model.ObjectNotFountException;
import bg.softuni.errors.model.ProductNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/category")
@Controller
public class CategoryController {

    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable("id") Long id,
                                 Model model) {
        CategoryDTO categoryDTO = getCategoryById(id);

        if (categoryDTO == null) {
            throw new ObjectNotFountException(id);
        }

        model.addAttribute("name", categoryDTO.getCategoryName());

        return "category";
    }

    private CategoryDTO getCategoryById(Long id) {
        return null;
    }
}

package bg.softuni.hateoas.web;

import bg.softuni.hateoas.model.dto.OrderDTO;
import bg.softuni.hateoas.model.dto.StudentDTO;
import bg.softuni.hateoas.service.StudentService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDTO>> getStudentById(@PathVariable("id") Long id) {
        var studentOpt = studentService.getStudentById(id);
        if (studentOpt.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        var student = studentOpt.get();

        return ResponseEntity.ok(EntityModel.of(student, getStudentsLinks(student)));
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<CollectionModel<EntityModel<OrderDTO>>> getStudentOrders(@PathVariable("id") Long id) {
        //TODO
        throw new UnsupportedOperationException("Coming soon!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDTO>> updateStudent(
            @PathVariable("id") Long id,
            StudentDTO studentDTO) {

        throw new UnsupportedOperationException("Not important right now!");
    }

    private Link[] getStudentsLinks(StudentDTO studentDTO) {
        List<Link> studentLinks = new ArrayList<>();

        Link selfRel =
                linkTo(methodOn(StudentController.class).getStudentById(studentDTO.getId())).withSelfRel();

        studentLinks.add(selfRel);

        return studentLinks.toArray(studentLinks.toArray(new Link[studentLinks.size()]));
    }
}
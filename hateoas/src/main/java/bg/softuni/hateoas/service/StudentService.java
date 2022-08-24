package bg.softuni.hateoas.service;

import bg.softuni.hateoas.model.dto.OrderDTO;
import bg.softuni.hateoas.model.dto.StudentDTO;
import bg.softuni.hateoas.model.entity.OrderEntity;
import bg.softuni.hateoas.model.entity.StudentEntity;
import bg.softuni.hateoas.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<StudentDTO> getStudentById(Long studentId) {
        return studentRepository.findById(studentId).map(this::map);
    }

    private StudentDTO map(StudentEntity studentEntity) {

        var orders = studentEntity
                .getOrders()
                .stream()
                .map(this::map).toList();

        return new StudentDTO()
                .setId(studentEntity.getId())
                .setName(studentEntity.getName())
                .setAge(studentEntity.getAge())
                .setDeleted(studentEntity.isDeleted())
                .setOrders(orders);
    }

    private OrderDTO map(OrderEntity orderEntity) {
        return new OrderDTO()
                .setId(orderEntity.getId())
                .setStudentId(orderEntity.getStudent().getId())
                .setCourseId(orderEntity.getCourse().getId());
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository
                .findAll()
                .stream()
                .map(this::map)
                .toList();
    }
}

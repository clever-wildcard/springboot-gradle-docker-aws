package com.company.springbootgradledockeraws;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;
    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    private List<Employee> all_employees() {
        return repository.findAll();
    }

    @PostMapping("/employees")
    private Employee addEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @GetMapping("/employees/{id}")
    private Employee oneEmployee(@PathVariable Long id) throws AccountNotFoundException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Error", "Could not find employee " + id);
        return repository.findById(id).orElseThrow(()-> new EmployeeNotFoundException(jsonObject));
    }

    @PutMapping("/employees/replace/{id}")
    private Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return repository.findById(id).map(employee -> {
            employee.setName(newEmployee.getName());
            employee.setRole(newEmployee.getRole());
            return repository.save(employee);
        }).orElseGet(() -> {
            newEmployee.setId(id);
            return repository.save(newEmployee);
        });
    }

    @DeleteMapping("/employees/{id}")
    private String deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("INFO", "Deleted employee record associated with id " + id);
        return String.valueOf(jsonObject);
    }
}

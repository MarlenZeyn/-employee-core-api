package dario.springtest.employeecoreapi.controller;

import dario.springtest.employeecoreapi.model.EmployeeModel;
import dario.springtest.employeecoreapi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<String> createEmployee(@Valid @PathVariable EmployeeModel employeeModel) {
        employeeService.createEmployee(employeeModel);
        return new ResponseEntity<String>("Successfully created", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<EmployeeModel> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public EmployeeModel getEmployeeById(@PathVariable String employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<String> updateEmployeeById(@PathVariable String employeeId,
                                                     @Valid @RequestBody EmployeeModel employeeModel) {
        employeeService.updateEmployeeById(employeeId, employeeModel);
        return new ResponseEntity<String>("Succsesfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return new ResponseEntity<String>("Succesfully deleted", HttpStatus.OK);
    }


}

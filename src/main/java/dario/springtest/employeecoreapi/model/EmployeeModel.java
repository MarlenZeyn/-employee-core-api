package dario.springtest.employeecoreapi.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeModel {
    @NotNull(message = "Id cannot be empty")
    private String employeeId;
    @NotNull(message = "Name cannot be empty")
    private String name;
    @NotNull(message = "Name cannot be empty")
    @Size(min = 2, max = 16, message = "Surname longer than 2 symbols")
    private String surname;
    private String company;
    private String position;
    @Email(message = "Incorrect email")
    private String email;
    private double salary;

}

package dario.springtest.employeecoreapi.service;

import dario.springtest.employeecoreapi.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


@Service
public class EmployeeServiceImpl implements EmployeeService{
    private static final HashMap<String, EmployeeModel> employeeMap = new HashMap<>();

   static {
       EmployeeModel employeeModel = new EmployeeModel(UUID.randomUUID().toString(),"Mara","Zeyn",
               "DAR", "Backend developer", "zmarlen45@gmail.com",
               125000);
       EmployeeModel employeeModel2 = new EmployeeModel(UUID.randomUUID().toString(),"Beka","Niga",
               "Kaspi alo", "operator", "wassapNiggas@gmail.com",
               12500);
       EmployeeModel employeeModel3 = new EmployeeModel(UUID.randomUUID().toString(),"Izim","Izim",
               "Yandex", "driver", "izim2003bor4ik@gmail.com",
               1250);
       employeeMap.put(employeeModel.getEmployeeId(), employeeModel);
       employeeMap.put(employeeModel2.getEmployeeId(), employeeModel2);
       employeeMap.put(employeeModel3.getEmployeeId(), employeeModel3);

   }
    @Override
    public void createEmployee(EmployeeModel employeeModel) {
            employeeModel.setEmployeeId(UUID.randomUUID().toString());
            employeeMap.put(employeeModel.getEmployeeId(), employeeModel);
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
       return new ArrayList<>(employeeMap.values());
    }

    @Override
    public EmployeeModel getEmployeeById(String employeeId) {
        return employeeMap.get(employeeId);
    }

    @Override
    public void updateEmployeeById(String employeeId, EmployeeModel employeeModel) {
       employeeModel.setEmployeeId(employeeId);
       employeeMap.put(employeeId, employeeModel);
    }

    @Override
    public void deleteEmployeeById(String employeeId) {
      employeeMap.remove(employeeId);
    }
}

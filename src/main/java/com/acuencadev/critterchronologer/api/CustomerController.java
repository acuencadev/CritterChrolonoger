package com.acuencadev.critterchronologer.api;

import com.acuencadev.critterchronologer.dto.CustomerDTO;
import com.acuencadev.critterchronologer.model.Customer;
import com.acuencadev.critterchronologer.model.Pet;
import com.acuencadev.critterchronologer.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user/customer")
public class CustomerController {

    private final ModelMapper modelMapper;
    private final CustomerService customerService;

    @Autowired
    public CustomerController(ModelMapper modelMapper, CustomerService customerService) {
        this.modelMapper = modelMapper;
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = dtoToEntity(customerDTO);

        return entityToDto(customerService.save(customer));
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        List<Customer> customers = customerService.getAll();
        for (Customer customer : customers) {
            customerDTOList.add(entityToDto(customer));
        }

        return customerDTOList;
    }

    @GetMapping("/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId){
        Customer customer = customerService.getCustomerByPetId(petId);

        return entityToDto(customer);
    }

    private Customer dtoToEntity(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);

        return customer;
    }

    private CustomerDTO entityToDto(Customer customer) {
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);

        if (customer.getPets() == null) {
            customer.setPets(new ArrayList<>());
        }

        customerDTO.setPetIds(customer.getPets().stream().map(Pet::getId).collect(Collectors.toList()));

        return customerDTO;
    }
}

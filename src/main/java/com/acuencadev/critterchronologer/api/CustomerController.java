package com.acuencadev.critterchronologer.api;

import com.acuencadev.critterchronologer.dto.CustomerDTO;
import com.acuencadev.critterchronologer.model.Customer;
import com.acuencadev.critterchronologer.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

        for (Customer customer : customerService.getAll()) {
            customerDTOList.add(entityToDto(customer));
        }

        return customerDTOList;
    }

    @GetMapping("/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId){
        throw new UnsupportedOperationException();
    }

    private Customer dtoToEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, Customer.class);
    }

    private CustomerDTO entityToDto(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }
}

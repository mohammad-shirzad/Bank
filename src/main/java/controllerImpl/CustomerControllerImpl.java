package controllerImpl;

import controller.CustomerController;
import entity.Customer;
import service.CustomerService;
import util.xmlCollectionUtil.Type1;

import javax.jws.WebService;
import java.util.Date;

@WebService(endpointInterface = "controller.CustomerController")
public class CustomerControllerImpl implements CustomerController {
    private CustomerService customerService;


    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Customer saveCustomer(String fullName, String nationalId,
                                 Date dateOfBirth, String province,
                                 String city, String street,
                                 int number, Type1 cards) {
        Customer customer = customerService.saveCustomer(fullName, nationalId,
                dateOfBirth, province, city, street, number, cards);
        return customer;

    }

    @Override
    public Customer getCustomerByNationalId(String nationalId) {
        Customer customer = customerService.getCustomerByNationalId(nationalId);
        return customer;
    }
}

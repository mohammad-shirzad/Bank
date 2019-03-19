package controller;

import entity.Customer;
import service.CustomerService;
import util.xmlCollectionUtil.Type1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.Set;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CustomerController {

    @WebMethod
    Customer saveCustomer(@WebParam(name = "fullName") String fullName,
                          @WebParam(name = "nationalId") String nationalId,
                          @WebParam(name = "dateOfBirth") Date dateOfBirth,
                          @WebParam(name = "province") String province,
                          @WebParam(name = "city") String city,
                          @WebParam(name = "street") String street,
                          @WebParam(name = "number") int number,
                          @WebParam(name = "cards") Type1 cards);

    @WebMethod
    Customer getCustomerByNationalId(@WebParam(name = "nationalId") String nationalId);
}

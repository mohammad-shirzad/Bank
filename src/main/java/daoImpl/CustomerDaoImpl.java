package daoImpl;

import dao.CustomerDao;
import entity.Customer;

public class CustomerDaoImpl extends AbstractJpaDao<Customer> implements CustomerDao {

    @Override
    public Customer findCustomerByNationalId(String nationalId) {
        return getEntityManager().createQuery("from customer where nationalId = :id", Customer.class)
                .setParameter("id", nationalId).getSingleResult();
    }

    @Override
    public Customer getCustomerByNationalId(String nationalId) {
        return getEntityManager().getReference(Customer.class, nationalId);
    }

}

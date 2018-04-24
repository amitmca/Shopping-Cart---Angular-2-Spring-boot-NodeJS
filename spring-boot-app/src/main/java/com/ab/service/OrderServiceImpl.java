/**
 * 
 * Author: Shaik Fareed
 * 
*
 */
package com.ab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.ab.assembler.OrderModelEntityAssembler;
import com.ab.entity.OrderSequences;
import com.ab.entity.Order;
import com.ab.exception.OrderCreationException;
import com.ab.exception.OrderDeletionException;
import com.ab.exception.OrderLoadException;
import com.ab.model.OrderModel;
import com.ab.repository.OrderRepository;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired private MongoOperations mongo;

    public int getNextSequence(String seqName)
    {
        OrderSequences counter = mongo.findAndModify(
            query(where("_id").is(seqName)),
            new Update().inc("seq",1),
            options().returnNew(true).upsert(true),
            OrderSequences.class);
        return counter.getSeq();
    }
	
	
	/* (non-Javadoc)
	 * @see com.ab.service.CustomerService#saveCustomer(com.ab.entity.Customer)
	 */
	@Override
	public void saveOrder(Order order) throws OrderCreationException {
		try{
			order.setOrderId(getNextSequence("orderSequences"));
			orderRepo.save(order);
		}
		catch(Exception ex){
			throw new OrderCreationException(ex.getMessage(),ex);
		}
	}

	/* (non-Javadoc)
	 * @see com.ab.service.CustomerService#findAllCustomer()
	 */
	@Override
	public List<OrderModel> findAllOrders() throws OrderLoadException {
		List<OrderModel> listOfOrderModel = new ArrayList<>();
		try{
			List<Order> listOfOrder = orderRepo.findAll();
			listOfOrder.forEach(order ->{
				listOfOrderModel.add(OrderModelEntityAssembler.populateModelFromEntity(order));
			});
			
			
		}catch(Exception ex){
			throw new OrderLoadException(ex.getMessage(),ex);
		}
		return listOfOrderModel;
	}

	/* (non-Javadoc)
	 * @see com.ab.service.CustomerService#deleteCustomerById(java.lang.String)
	 */
	@Override
	public void deleteOrderById(String orderId) throws OrderDeletionException{
		try{
			orderRepo.delete(Integer.parseInt(orderId));
		}catch(Exception ex){
			throw new OrderDeletionException(ex.getMessage(),ex);
		}
	}


	/* (non-Javadoc)
	 * @see com.ab.service.CustomerService#findCustomerById(java.lang.String)
	 */
	@Override
	public OrderModel findOrderById(String orderId)  throws OrderLoadException {
		OrderModel orderModel;
		try{
			orderModel = OrderModelEntityAssembler.populateModelFromEntity(orderRepo.findOne(Integer.parseInt(orderId)));
		}catch(Exception ex){
			throw new OrderLoadException(ex.getMessage(),ex);
		}
		
		return orderModel;
	}

}

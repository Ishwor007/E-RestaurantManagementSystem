package com.project.restaurantManagement.Database;




import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import com.project.restaurantManagement.Model.Item;
import com.project.restaurantManagement.Model.ItemCategory;
import com.project.restaurantManagement.Model.OrderItem;
import com.project.restaurantManagement.Model.ServedTables;
import com.project.restaurantManagement.Repository.ItemCategoryRepo;
import com.project.restaurantManagement.Repository.ItemRepo;
import com.project.restaurantManagement.Repository.OrderRepo;
import com.project.restaurantManagement.Repository.ServedRepo;


@Component
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private ItemCategoryRepo itemcategoryrepo;
	@Autowired
	private ItemRepo itemrepo;
	
	@Autowired
	private OrderRepo orderrepo;
	
	@Autowired
	private ServedRepo servedrepo;
	
	@Override
	public void addDataItem(Item item) {
		
		itemrepo.save(item);
	}

	@Override
	public int getItemCategory(String categoryname) {
		ItemCategory ichandling = new ItemCategory();
		List<ItemCategory> ic = itemcategoryrepo.findAll();
	
		
		for(ItemCategory icategory:ic) {
			if(icategory.getPc_name().equalsIgnoreCase(categoryname)) {
				return icategory.getPc_id();
			}
		}
		
		return 0;
	}

	@Override
	public void saveItem(Item item) {
	itemrepo.save(item);	
	}

	@Override
	public ItemCategory getItemCategory(int category_id) {
		return itemcategoryrepo.getOne(category_id);
	}

	@Override
	public Page<Item> findPage(int page, int page_size) {
		Pageable pageable = PageRequest.of(page-1, page_size);
		return itemrepo.findAll(pageable);
	}

	@Override
	public List<ItemCategory> getItemCategory() {
		
		List<ItemCategory> item_c = itemcategoryrepo.findAll();
		return item_c;
	}

	@Override
	public Page<Item> FindPageByName(String cname,int page, int page_size) {
	  int pc_id=0;
		Pageable pageable = PageRequest.of(page-1, page_size);
		List<Item> items = itemrepo.findAll();
		for(Item item:items) {
			if(item.getItem_category().getPc_name().equals(cname)) {
				pc_id=item.getItem_category().getPc_id();
			}
		}
		
		return itemrepo.findAllById(pageable,pc_id);
		
	}

	@Override
	public Item getItem(int id) {
		return itemrepo.getOne(id);
	}

	@Override
	public void saveOrderDetails(OrderItem orderitem) {
		
		orderrepo.save(orderitem);
		
	}

	@Override
	public List<OrderItem> getAllOrderItem() {
		return orderrepo.findAll();
	}

	@Override
	public void serverdItem(int order_id) {
		
		OrderItem order = orderrepo.getOne(order_id);
		ServedTables stables = new ServedTables();
		stables.setOrder_id(order_id);
		stables.setItem(order.getItem());
		stables.setItem_quantity(order.getItem_quantity());
		stables.setOrder_time(order.getOrder_time());
		stables.setTablenumber(order.getTablenumber());
		stables.setTotal_price(order.getTotal_price());
		servedrepo.save(stables);
		orderrepo.deleteById(order_id);
	}

	
	
}

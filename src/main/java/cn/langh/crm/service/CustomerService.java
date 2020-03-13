package cn.langh.crm.service;

import cn.langh.crm.pojo.Customer;
import cn.langh.crm.pojo.QueryVo;
import cn.langh.crm.utils.Page;

public interface CustomerService {
    //通过四个条件查询分页对象
    public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);
    //根据id查询客户
    public Customer selectCustomerById(Integer id);
    //修改客户通过id
    public void updateCustomerById(Customer customer);
    //删除客户通过id
    public void deleteCustomerById(Integer id);
}

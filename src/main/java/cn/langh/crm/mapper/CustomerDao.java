package cn.langh.crm.mapper;

import cn.langh.crm.pojo.Customer;
import cn.langh.crm.pojo.QueryVo;

import java.util.List;

public interface CustomerDao {
    //根据queryVo分页查询数据
    List<Customer> queryCustomerByQueryVo(QueryVo queryVo);
    //根据queryVo查询数据条数
    int queryCountByQueryVo(QueryVo queryVo);
    //根据id查询客户
    public Customer selectCustomerById(Integer id);
    //修改客户通过id
    public void updateCustomerById(Customer customer);
    //删除客户
    public void deleteCustomerById(Integer id);
}

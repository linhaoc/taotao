package cn.langh.crm.service;

import cn.langh.crm.mapper.CustomerDao;
import cn.langh.crm.pojo.Customer;
import cn.langh.crm.pojo.QueryVo;
import cn.langh.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 客户管理
 * */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    //通过四个条件查询分页对象
    public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo){
        Page<Customer> page = new Page<>();
        //每页数
        page.setSize(5);
        queryVo.setSize(5);
        if (null != queryVo ){

            if (null!=queryVo.getCustName() && !"".equals(queryVo.getCustName().trim())){
                queryVo.setCustName(queryVo.getCustName().trim());
            }
            if (null!=queryVo.getCustSource() && !"".equals(queryVo.getCustSource().trim())){
                queryVo.setCustSource(queryVo.getCustSource().trim());
            }
            if (null!=queryVo.getCustIndustry() && !"".equals(queryVo.getCustIndustry().trim())){
                queryVo.setCustIndustry(queryVo.getCustIndustry().trim());
            }
            if (null!=queryVo.getCustLevel() && !"".equals(queryVo.getCustLevel().trim())){
                queryVo.setCustLevel(queryVo.getCustLevel().trim());
            }

            //设置当前页
            page.setPage(queryVo.getPage());
            queryVo.setStart((queryVo.getPage()-1)*queryVo.getSize());
            //设置总条数
            page.setTotal(customerDao.queryCountByQueryVo(queryVo));
            //设置数据结构集
            page.setRows(customerDao.queryCustomerByQueryVo(queryVo));
        }

        return page;
    }
    //通过id查询客户
    @Override
    public Customer selectCustomerById(Integer id) {

        return customerDao.selectCustomerById(id);
    }
    //修改客户通过id
    @Override
    public void updateCustomerById(Customer customer) {
        customerDao.updateCustomerById(customer);
    }
    //删除客户通过id
    public void deleteCustomerById(Integer id){
        customerDao.deleteCustomerById(id);
    }
}

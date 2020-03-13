package cn.langh.crm.controller;

import cn.langh.crm.pojo.BaseDict;
import cn.langh.crm.pojo.Customer;
import cn.langh.crm.pojo.QueryVo;
import cn.langh.crm.service.BaseDictService;
import cn.langh.crm.service.CustomerService;
import cn.langh.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 客户管理
 * */
@Controller
public class CustomerController {
    // 客户来源
    @Value("${CUSTOMER_FROM_TYPE}")
    private String CUSTOMER_FROM_TYPE;
    // 客户行业
    @Value("${CUSTOMER_INDUSTRY_TYPE}")
    private String CUSTOMER_INDUSTRY_TYPE;
    // 客户级别
    @Value("${CUSTOMER_LEVEL_TYPE}")
    private String CUSTOMER_LEVEL_TYPE;

    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private CustomerService customerService;
    //入口
    @RequestMapping(value = "/customer/list")
    public String list(QueryVo queryVo,Model model){
        //客户来源
        List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(CUSTOMER_FROM_TYPE);
        //所属行业
        List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(CUSTOMER_INDUSTRY_TYPE);
        //客户级别
        List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(CUSTOMER_LEVEL_TYPE);
        // 把前端页面需要显示的数据放到模型中
        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);
//        // 分页查询数据
        Page<Customer> page = this.customerService.queryCustomerByQueryVo(queryVo);
//        //把分页查询的结果放到模型中
        model.addAttribute("page",page);
//        // 数据回显
        model.addAttribute("custName", queryVo.getCustName());
        model.addAttribute("custSource", queryVo.getCustSource());
        model.addAttribute("custIndustry", queryVo.getCustIndustry());
        model.addAttribute("custLevel", queryVo.getCustLevel());

        //通过4个条件查询分页对象
        return "customer";
    }
    //去修改页面
    @RequestMapping(value = "/customer/edit.action")
    public @ResponseBody
    Customer edit(Integer id){
        return customerService.selectCustomerById(id);
    }
    //修改保存
    @RequestMapping(value = "/customer/update.action")
    public @ResponseBody
    String update(Customer customer){
        customerService.updateCustomerById(customer);
        return "OK";
    }
    //删除
    @RequestMapping(value = "/customer/delete.action")
    public @ResponseBody
    String delete(Integer id){
        //删除
        customerService.deleteCustomerById(id);
        return "OK";
    }
}

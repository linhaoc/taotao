package cn.langh.crm.service;

import cn.langh.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {
    //查询
    public List<BaseDict> selectBaseDictListByCode(String code);
}

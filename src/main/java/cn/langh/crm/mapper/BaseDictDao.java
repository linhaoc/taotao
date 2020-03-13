package cn.langh.crm.mapper;

import cn.langh.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictDao {
    //查询
    public List<BaseDict> selectBaseDictListByCode(String code);
}

package cn.itcast.service;

import cn.itcast.pojo.Item;

import java.util.List;

public interface ItemService {

    //保存产品
    public void save(Item item);

    //根据条件查询产品
    public List<Item> findAll(Item item);
}

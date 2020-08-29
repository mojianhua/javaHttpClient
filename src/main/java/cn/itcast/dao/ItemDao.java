package cn.itcast.dao;

import cn.itcast.pojo.Item;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<pojo,主键长度>
public interface ItemDao extends JpaRepository<Item,Long> {
}

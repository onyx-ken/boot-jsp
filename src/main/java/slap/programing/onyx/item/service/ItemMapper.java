package slap.programing.onyx.item.service;

import org.apache.ibatis.annotations.Mapper;
import slap.programing.onyx.item.domain.ItemVO;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<ItemVO> itemAllList();
    int saveItem(ItemVO itemVO);
    ItemVO ItemDetail(Long itemId);
    int updateItem(ItemVO itemVO);
    int deleteItem(Long itemId);
}

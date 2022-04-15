package slap.programing.onyx.item;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<ItemVO> itemAllList();
    int saveItem(ItemVO itemVO);
    ItemVO ItemDetail(Long itemId);
    int updateItem(ItemVO itemVO);
}

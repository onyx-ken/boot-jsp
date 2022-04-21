package slap.programing.onyx.item.service;

import slap.programing.onyx.item.domain.ItemVO;

public interface ItemService {

    int saveItem(ItemVO itemVO);
    int updateItem(ItemVO itemVO);
    int deleteItem(Long itemId);
    
}

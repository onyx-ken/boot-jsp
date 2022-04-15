package slap.programing.onyx.item;

public interface ItemService {

    int saveItem(ItemVO itemVO);
    int updateItem(ItemVO itemVO);
    int deleteItem(Long itemId);
    
}

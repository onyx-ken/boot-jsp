package slap.programing.onyx.item.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import slap.programing.onyx.item.domain.ItemVO;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemMapper itemMapper;

    @Override
    public int saveItem(ItemVO itemVO) {
        return itemMapper.saveItem(itemVO);
    }

    @Override
    public int updateItem(ItemVO itemVO) {
        return itemMapper.updateItem(itemVO);
    }

    @Override
    public int deleteItem(Long itemId) {
        return itemMapper.deleteItem(itemId);
    }

}

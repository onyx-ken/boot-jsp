package slap.programing.onyx.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemMapper itemMapper;

    @Override
    public int saveItem(ItemVO itemVO) {
        return itemMapper.saveItem(itemVO);
    }

}

package slap.programing.onyx.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
public class BasicItemController {

    private final ItemMapper itemMapper;
    private final ItemService itemService;

    @GetMapping("/list")
    public String itemList(Model model) {
        List<ItemVO> dataList = itemMapper.itemAllList();
        model.addAttribute("dataList", dataList);
        return "items";
    }


    @GetMapping("/add")
    public String viewAddForm() {

        return "addForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute ItemVO itemVO)  {

        itemService.saveItem(itemVO);

        return "redirect:/item/list";
    }

    @GetMapping("/detail/{itemId}")
    public String detail(@PathVariable() Long itemId, Model model) {

        ItemVO item = itemMapper.ItemDetail(itemId);
        model.addAttribute("item", item);

        return "itemDetail";
    }

}
package slap.programing.onyx.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
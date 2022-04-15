package slap.programing.onyx.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    public String detail(@PathVariable() Long itemId, HttpSession httpSession) {

        ItemVO item = itemMapper.ItemDetail(itemId);
        httpSession.setAttribute("item", item);

        return "itemDetail";
    }

    @GetMapping("/update")
    public String updateView(HttpSession httpSession) {

        ItemVO item = (ItemVO) httpSession.getAttribute("item");

        return "updateForm";
    }

    @PostMapping("/update")
    public String updateItem(@ModelAttribute ItemVO itemVO, Model model) {
        itemService.updateItem(itemVO);
        model.addAttribute("item", itemVO);

        return "itemDetail";
    }

}
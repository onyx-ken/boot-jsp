package slap.programing.onyx.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
    public String viewAddForm(Model model) {

        model.addAttribute("itemVO", new ItemVO());

        return "addForm";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute ItemVO itemVO, BindingResult bindingResult, Model model)  {

        if (itemVO.getItemPrice() != null && itemVO.getItemQty() != null) {
            long resultPrice = itemVO.getItemPrice() * itemVO.getItemQty();
            if (resultPrice < 10000) {
                bindingResult.addError(new ObjectError("itemVO", new String[]
                        {"금액 * 수량의 합은 10000 이상이어야 합니다"}, new Object[]{10000, resultPrice}, null));
            }
        }

        if (bindingResult.hasErrors()) {

            return "addForm";
        }

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

        return "redirect:/item/detail/" + itemVO.getItemId();
    }

    @PostMapping("/delete")
    public String deleteItem(@RequestParam Long itemId) {
        itemService.deleteItem(itemId);

        return "redirect:/item/list";

    }
}
package slap.programing.onyx.item.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import slap.programing.onyx.item.service.ItemMapper;
import slap.programing.onyx.item.service.ItemService;
import slap.programing.onyx.item.domain.ItemVO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
public class BasicItemController {

    private final ItemMapper itemMapper;
    private final ItemService itemService;
    private final ItemValidator itemValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(itemValidator);
    }

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
    public String save(@Valid @ModelAttribute("itemVO") ItemAddDTO itemAddDTO, BindingResult bindingResult, Model model)  {

        if (bindingResult.hasErrors()) {

            return "addForm";
        }

        ItemVO itemVO = new ItemVO();
        itemVO.setItemId(itemAddDTO.getItemId());
        itemVO.setItemName(itemAddDTO.getItemName());
        itemVO.setItemQty(itemAddDTO.getItemQty());
        itemVO.setItemPrice(itemAddDTO.getItemPrice());

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
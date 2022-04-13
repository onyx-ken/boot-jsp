package slap.programing.onyx.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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

    @GetMapping("/list")
    public String itemList(Model model) {
        List<ItemVO> dataList = itemMapper.itemAllList();
        model.addAttribute("dataList", dataList);
        return "items";
    }


    @GetMapping("/add")
    public String addForm(Model model) {

        return "addForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute ItemVO itemVO)  {

        return "redirect:/items";
    }

}

package slap.programing.onyx.item.web;

import lombok.Getter;
import lombok.Setter;
import slap.programing.onyx.item.domain.ItemVO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class ItemUpdateDTO extends ItemVO {
    private Long itemId;
    @NotBlank
    private String itemName;
    @NotNull
    @Min(1000)
    private Long itemPrice;
    @NotNull
    private Integer itemQty;
}

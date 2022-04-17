package slap.programing.onyx.item;

import lombok.Getter;
import lombok.Setter;

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
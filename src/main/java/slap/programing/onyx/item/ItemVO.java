package slap.programing.onyx.item;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ItemVO {

    private Long itemId;
    @NotBlank
    private String itemName;
    @NotNull @Min(1000)
    private Long itemPrice;
    @NotNull @Min(10)
    private Integer itemQty;
}
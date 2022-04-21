package slap.programing.onyx.item.domain;

import lombok.Data;

@Data
public class ItemVO {

    private Long itemId;
    private String itemName;
    private Long itemPrice;
    private Integer itemQty;
}
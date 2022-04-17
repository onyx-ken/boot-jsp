package slap.programing.onyx.item;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ItemVO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ItemVO itemVO = (ItemVO) target;

        if (itemVO.getItemPrice() != null && itemVO.getItemQty() != null) {
            long resultPrice = itemVO.getItemPrice() * itemVO.getItemQty();
            if (resultPrice < 10000) {
                errors.reject("totalPriceMin", new Object[]{10000, resultPrice}, "금액 * 수량의 합은 10000 이상이여야 합니다.");
            }
        }

    }
}

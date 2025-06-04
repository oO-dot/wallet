package skolkovo.wallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor // добавил вместо пустого конструктора иначе ошибка в WSI в методе getBalance не может вернуть wallet.getBalance()
public class BalanceResponse {
    private BigDecimal balance;

}

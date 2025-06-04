package skolkovo.wallet.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import skolkovo.wallet.model.OperationType;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OperationRequest {
    @NotNull
    private UUID walletId;

    @NotNull
    private OperationType operationType;

    @NotNull
    @Positive
    private BigDecimal amount;
}

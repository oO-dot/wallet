package skolkovo.wallet.service;

import skolkovo.wallet.dto.BalanceResponse;
import skolkovo.wallet.dto.OperationRequest;

import java.util.UUID;

public interface WalletService {
    void processOperation(OperationRequest request);
    BalanceResponse getBalance(UUID walletId);
}


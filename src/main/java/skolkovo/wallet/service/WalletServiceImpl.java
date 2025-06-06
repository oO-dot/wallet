package skolkovo.wallet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import skolkovo.wallet.dto.BalanceResponse;
import skolkovo.wallet.dto.OperationRequest;
import skolkovo.wallet.exception.InsufficientFundsException;
import skolkovo.wallet.exception.WalletNotFoundException;
import skolkovo.wallet.model.OperationType;
import skolkovo.wallet.model.Wallet;
import skolkovo.wallet.repository.WalletRepository;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;

    @Override
    @Transactional
    public void processOperation(OperationRequest request) {
        Wallet wallet = walletRepository.findById(request.getWalletId())
                .orElseThrow(() -> new WalletNotFoundException(request.getWalletId()));

        BigDecimal amount = request.getAmount();
        if (OperationType.DEPOSIT == request.getOperationType()) {
            wallet.setBalance(wallet.getBalance().add(amount));
        } else {
            if (wallet.getBalance().compareTo(amount) < 0) {
                throw new InsufficientFundsException();
            }
            wallet.setBalance(wallet.getBalance().subtract(amount));
        }
        walletRepository.save(wallet);
    }

    @Override
    public BalanceResponse getBalance(UUID walletId) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new WalletNotFoundException(walletId));
        return new BalanceResponse(wallet.getBalance());
    }
}
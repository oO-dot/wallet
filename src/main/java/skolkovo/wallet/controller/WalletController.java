package skolkovo.wallet.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skolkovo.wallet.dto.BalanceResponse;
import skolkovo.wallet.dto.OperationRequest;
import skolkovo.wallet.service.WalletService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wallets")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @PatchMapping
    public ResponseEntity<String> processOperation(@Valid @RequestBody OperationRequest request) {
        walletService.processOperation(request);
        return ResponseEntity.ok("Operation completed");
    }

    @GetMapping("/{walletId}")
    public ResponseEntity<BalanceResponse> getBalance(@PathVariable UUID walletId) {
        return ResponseEntity.ok(walletService.getBalance(walletId));
    }
}

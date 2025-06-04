package skolkovo.wallet.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import skolkovo.wallet.dto.BalanceResponse;
import skolkovo.wallet.dto.OperationRequest;
import skolkovo.wallet.model.OperationType;
import skolkovo.wallet.service.WalletService;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WalletControllerTest {

    @Mock
    private WalletService walletService;

    @InjectMocks
    private WalletController walletController;

    @Test
    void processOperation_ValidRequest_CallsServiceAndReturnsOk() {
        // Arrange
        OperationRequest request = new OperationRequest();
        request.setWalletId(UUID.randomUUID());
        request.setOperationType(OperationType.DEPOSIT);
        request.setAmount(BigDecimal.valueOf(100));

        // Act
        ResponseEntity<String> response = walletController.processOperation(request);

        // Assert
        verify(walletService).processOperation(request);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Operation completed", response.getBody());
    }

    @Test
    void getBalance_ValidWalletId_ReturnsCorrectBalance() {
        // Arrange
        UUID walletId = UUID.randomUUID();
        BigDecimal expectedBalance = BigDecimal.valueOf(500);
        BalanceResponse balanceResponse = new BalanceResponse(expectedBalance);

        when(walletService.getBalance(walletId)).thenReturn(balanceResponse);

        // Act
        ResponseEntity<BalanceResponse> response = walletController.getBalance(walletId);

        // Assert
        verify(walletService).getBalance(walletId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedBalance, response.getBody().getBalance());
    }
}
package skolkovo.wallet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;
import org.hibernate.annotations.OptimisticLocking;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@OptimisticLocking
public class Wallet {
    @Id
    private UUID id;

    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    @Version
    private Long version;
}

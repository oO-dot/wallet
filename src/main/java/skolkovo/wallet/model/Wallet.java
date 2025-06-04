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
@OptimisticLocking // механизм, который используется в многопоточных средах и базах данных для предотвращения конфликтов при одновременном доступе к данным
public class Wallet {
    @Id
    private UUID id;

    @Column(nullable = false) // не может принимать null (выбросится exception)
    private BigDecimal balance = BigDecimal.ZERO;

    @Version // используется для определения поля в сущности, которое будет использоваться для оптимистического блокирования
    private Long version;
}

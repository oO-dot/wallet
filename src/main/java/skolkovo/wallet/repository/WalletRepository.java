package skolkovo.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skolkovo.wallet.model.Wallet;

import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {
}

/*
В Spring Data JPA аннотация @Query с JPQL запросом SELECT w FROM Wallet w WHERE w.id = :id используется для определения
 пользовательских методов запроса в репозитории. Эта аннотация позволяет указывать SQL-запросы
 (или в данном случае JPQL, который является Object-Relational Mapping для JPA) для получения данных из базы данных.

Более подробно:
@Query:
Аннотация, используемая для определения пользовательских запросов.

JPQL (Java Persistence Query Language):
Язык запросов, используемый JPA для выполнения запросов в базе данных, отображенных в Java-объекты.

SELECT w FROM Wallet w:
Часть запроса, указывающая, что нужно получить все свойства сущности Wallet (обозначенная как w).

WHERE w.id = :id:
Условие, которое фильтрует результаты, выбирая только Wallet с id, равным значению, передаваемому как параметр :id.

:id:
Параметр, который будет подставлен в запрос во время его выполнения.
Этот запрос позволяет вам легко получить Wallet по идентификатору, используя пользовательский метод в репозитории, который будет использовать этот JPQL запрос для выполнения.
 */
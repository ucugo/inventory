package repositories;

import domain.InventoryUserLoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Ugo on 04/05/2015.
 */
public interface InventoryUserLoginHistoryRepository extends JpaRepository<InventoryUserLoginHistory,Serializable> {
}

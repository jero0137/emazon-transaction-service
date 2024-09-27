package com.emazon.transaction_service.Infrastructure.Output.Jpa.Repository;

import com.emazon.transaction_service.Infrastructure.Output.Jpa.Entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepository extends JpaRepository<SupplyEntity, Long> {
}

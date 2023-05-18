package com.pers.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pers.library.Entity.Burrower;

public interface BurrowerRepository extends JpaRepository<Burrower, Long> {
}



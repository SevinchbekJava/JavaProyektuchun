package com.example.xodim.Been;

import com.example.xodim.Model.Xaridor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XaridorBeen extends JpaRepository<Xaridor,Integer> {
    boolean existsByTelefonRaqam(String telefonRaqam);
    boolean existsById(Integer id);
}

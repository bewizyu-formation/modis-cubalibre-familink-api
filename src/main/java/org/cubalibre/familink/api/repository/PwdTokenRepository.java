package org.cubalibre.familink.api.repository;

import org.cubalibre.familink.api.entite.PwdToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PwdTokenRepository extends JpaRepository<PwdToken, Integer> {

}

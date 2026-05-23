package org.serratec.curso.repository;

import org.serratec.curso.domain.PerfilSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilSocialRepository extends JpaRepository<PerfilSocial, Long> {

}

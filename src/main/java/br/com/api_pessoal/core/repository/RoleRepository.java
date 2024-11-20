package br.com.api_pessoal.core.repository;

import java.util.Optional;

import br.com.api_pessoal.core.models.ERole;
import br.com.api_pessoal.core.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}

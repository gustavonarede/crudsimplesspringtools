package contatos.com.br;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

	public List<Contato> findAll(); // o nome do metodo é a consulta 
	
}

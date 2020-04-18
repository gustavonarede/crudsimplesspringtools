package contatos.com.br;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.stereotype.Service;

@Service
public class ContatoServico {

	 @Autowired
	 ContatoRepository repository;
	 
	 public List<Contato> getAllContatos(){
		 List<Contato> resultado = (List<Contato>)repository.findAll();
		 if(resultado.size()>0) {
			 return resultado;
		 }else {
			 return new ArrayList<Contato>();
		 }
		 


			 
		 }
	 public Contato getContatotoById(Integer id) throws RecordTypeNotSupportedException {
		 Optional<Contato>contato  = repository.findById(id);
		 if(contato.isPresent()) {
			 return contato.get();
		 }else {
			 throw new RecordTypeNotSupportedException("Não exiiste contato nesse id");
		 }
	 }
	 public Contato createOrUpdateContato(Contato contato) {
		 if(contato.getId() == null) {
			 contato = repository.save(contato);
			 return contato;
		 }else {
			 Optional<Contato>contato = repository.findById(contato.getId());
			 if(contato.isPresent()) {
				 Contato newContato = contato.get();
				 newContato.setNome();
				 newContato.setTelefone();
				 newContato.setEmail(email);
				 newContato.setDataNascimento();
				 
				 newContato = repository.save(newContato);
				 
				 return newContato;
			 }else {
				 contato = repository.save(contato);
				 return contato;
			 }
		 }
	 }
	 public void deleteContatoById(Integer id) throws RecordTypeNotSupportedException{
		 Optional<Contato>contato = repository.findById(id);
		 if(contato.isPresent()) {
			 repository.deleteById(id);
		 }else {
			 throw new RecordNotFoundException("Não existe contato");
		 }
	 }
	 
	}

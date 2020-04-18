package contatos.com.br;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/")
public class ContatosControle {
	
	@Autowired
	ContatoServico service;

	@RequestMapping
	public String getAllContatos(Moodel model) {
		List<ContatoEntidade> list = service.getAllContatos();
		model.addAttribute("contatos",list);
		return "list";
	}
//private static final ArrayList<Contato> LISTA_CONTATOS = new ArrayList<>();
	
	
	
	/*@GetMapping("/")
	public String index() {
		return "index";
	}*/
	
	/*@Request("/contatos")
	public String listar(Model model) {
		List<Contato> contatos = service.listar();
		model.addAttribute("contato", contatos);
		return "listar";
	}*/
	
	
	
	
	@RequestMapping(path="/createContatos/novo", method = RequestMethod.POST)
	public String CreateOrUpdate(ContatoEntidade contato) {
		service.createOrUpdateContato(contato);
		
		
		
		//return "formulario";
		return "redirect:/";
	}
	
	
	@RequestMapping(path ="/edit", "/edit/{id}")
	public String editContatoDeId(Model model,@PathVariable("id")Optional<Integer>id) throws RelationNotFoundException {
		if(id.isPresent()) {
			Contato contato = service.
		}
		model.addAttribute("contato", contato);
		return "formulario";
		
	}*/
	
	}


	
	//@GetMapping("/contatos/novo")
	//public String novo() {
		//return "formulario";
	//}*/
//}

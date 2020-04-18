package contatos.com.br;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/contatos")
public class ContatosControle {
	
	@Autowired
	private ContatoServico contatoServico;

	@GetMapping("/home")
	public String index() {
		return "index";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		List<Contato> contatos = contatoServico.findAll();
		model.addAttribute("contatos", contatos);
		return "listar";
	}
	@GetMapping("novo")
	public String novo(Model model) {
		Contato contato = new Contato();
		model.addAttribute("contato", contato);
		return "formulario";
		
	}
	@PostMapping("/salvar")
	public String salvar(@ModelAttribute("conatato")Contato contato, Model model) {
		contatoServico.save(contato);
		List<Contato> contatos = contatoServico.findAll();
		model.addAttribute("contatos", contatos);
		return "listar";
	}
	
	
	@GetMapping("/editar")
	public String editar(@ModelAttribute("id")Integer id, Model model) {
		Optional contato = contatoServico.findById(id);
		model.addAttribute("contatos", contato);
		return "formulario";
	}
	
	
	@GetMapping("/excluir")
	public String excluir(@MOdelAttribute("id")Integer id, Model model) {
		contatoServico.deleteById(id);
		List<Contato>contatos = contatoServico.findAll();
		model.addAttribute("contatos", contatos);
		return "listar";
	}
	@GetMapping("/add")
		public String addContato(Model model) {
			model.addAttribute("contato",new Contato());
			return "formulario";
		}
	
}

	
	//@GetMapping("/contatos/novo")
	//public String novo() {
		//return "formulario";
	//}*/
//}

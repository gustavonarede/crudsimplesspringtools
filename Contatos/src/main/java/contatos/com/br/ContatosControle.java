package contatos.com.br;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContatosControle {
	
	@Autowired // injeta uma instancia de ContatoRepository sem usar new
	public ContatoRepository contatoRepository;

private static final ArrayList<Contato> LISTA_CONTATOS = new ArrayList<>();
	
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/contatos")
	public String listar(Model model) {
		List<Contato> contatos = contatoRepository.findAll();
		model.addAttribute("contatos", contatos);
		return "listar";
	}
	
	
	@GetMapping("/contatos/novo")
	public String novo(Model model) {
		Contato contato = new Contato();
		
		model.addAttribute("contato", contato);
		
		return "formulario";
	}
	
	@PostMapping("/contatos/novo")
	public String salvar(@ModelAttribute("contato") Contato contato ,Model model) {
		
		
		contatoRepository.save(contato);
		
		List<Contato> contatos = contatoRepository.findAll();
		model.addAttribute("contatos", contatos);
		return "listar";
	}
	
	@GetMapping("/contatos/edit")
	public String edit(@ModelAttribute("contato") Contato contato ,Model model) {
		model.addAttribute("contato", contato);
		return "formulario";
		
	}
}
/*private static final ArrayList<Contato> LISTA_CONTATOS = new ArrayList<>();
	/*
	  static { LISTA_CONTATOS.add(new Contato("1", "Maria", "+55 34 00000 0000"));
	  LISTA_CONTATOS.add(new Contato("2", "João", "+55 34 00000 0000"));
	  LISTA_CONTATOS.add(new Contato("3", "Normandes", "+55 34 00000 0000"));
	 LISTA_CONTATOS.add(new Contato("4", "Thiago", "+55 34 00000 0000"));
	  LISTA_CONTATOS.add(new Contato("5", "Alexandre", "+55 34 00000 0000")); }*/
	 

	//List<Contato> contatos = new ArrayList<>();

	//Contato c1 = new Contato(1, "paulo", "123456");
	
	//private List<Contato> adicionar(){
		//contatos.add(c1);
		////return contatos;
//	}

//	@GetMapping("/")
	//public String index() {
		//return "index";
	//}

	//@GetMapping("/contatos")
	//public String listar(Model model) {
	//	List<Contato> contatos = new ArrayList<>();
		//Contato c1 = new Contato("1", "paulo", "123456");
		//Contato c2 = new Contato("2", "Ana", "123456");
		
		//contatos.add(c1);
		//contatos.add(c2);

		//model.addAttribute("contatos", contatos);

		//return "listar";

	//}
	
	//@GetMapping("/contatos/novo")
	//public String novo() {
		//return "formulario";
	//}*/
//}

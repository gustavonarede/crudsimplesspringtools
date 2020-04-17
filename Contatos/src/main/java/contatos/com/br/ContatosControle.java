package contatos.com.br;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/ccontatos"})
public class ContatosControle {
	
	@Autowired // injeta uma instancia de ContatoRepository sem usar new
	public ContatoRepository contatoRepository;

//private static final ArrayList<Contato> LISTA_CONTATOS = new ArrayList<>();
	private ContatosControle repositorio;
	ContatosControle(ContatosControle contatoRepository){
		this.repositorio = contatoRepository;
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	/*@GetMapping("/contatos")
	public String listar(Model model) {
		List<Contato> contatos = contatoRepository.findAll();
		model.addAttribute("contatos", contatos);
		return "listar";
	}*/
	/*@GetMapping
	public List findAll() {
		return repositorio.findAll();
	}*/
	
	@PostMapping
	public Contato create(@RequestBody Contato contato) {
		return repositorio.save(contato);
	}
	
	/*@GetMapping("/contatos/novo")
	public String novo(Model model) {
		Contato contato = new Contato();
		
		model.addAttribute("contato", contato);
		
		return "formulario";
	}*/
	
	/*@PostMapping("/contatos/novo")
	public String salvar(@ModelAttribute("contato") Contato contato ,Model model) {
		
		
		contatoRepository.save(contato);
		
		List<Contato> contatos = contatoRepository.findAll();
		model.addAttribute("contatos", contatos);
		return "listar";
	}*/
	
	/*@GetMapping("/contatos/edit")
	public String edit(@ModelAttribute("contato") Contato contato ,Model model) {
		model.addAttribute("contato", contato);
		return "formulario";
		
	}*/
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("id")Integer id,
			@RequestBody Contato contato) {
		 return repositorio.findById(id)
		           .map(record -> {
		               record.setName(contact.getName());
		               record.setTelefone(contato.getTelefone());
		               record.setdataNascimento(contact.getdataNascimento());
		               Contact updated = repositorio.save(record);
		               return ResponseEntity.ok().body(updated);
		           }).orElse(ResponseEntity.notFound().build());
		}
	}


	
	//@GetMapping("/contatos/novo")
	//public String novo() {
		//return "formulario";
	//}*/
//}

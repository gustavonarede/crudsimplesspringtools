package contatos.com.br;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contatos")
public class ContatoController {
	
	@Autowired
	public ContatoRepository contatoRepository;

	
	@GetMapping("/home")
	public String index() {
		return "index";
	}
	
        @GetMapping("/listar")
        public String listar(Model model){
            List<Contato> contatos = contatoRepository.findAll();
            model.addAttribute("contatos" , contatos);
             return "listar";
        }
        @GetMapping("/novo")
        public String novo(Model model){
            Contato contato = new Contato();
            model.addAttribute("contato", contato);
            return "formulario";
        }
        @PostMapping("/salvar")
        public String salvar(@ModelAttribute("contato") Contato contato, Model model){
            contatoRepository.save(contato);
            List<Contato> contatos = contatoRepository.findAll();
            model.addAttribute("contatos" , contatos);
            return "listar";
        }
        
        @GetMapping("/editar")
        public String editar(@ModelAttribute("id") Integer id, Model model){
            Optional contato = contatoRepository.findById(id);
            model.addAttribute("contato" , contato);
            return "formulario";
        }
        
        @GetMapping("/excluir")
        public String excluir(@ModelAttribute("id") Integer id, Model model){
            contatoRepository.deleteById(id);
            List<Contato> contatos = contatoRepository.findAll();
            model.addAttribute("contatos" , contatos);
            return "listar";
        }
}

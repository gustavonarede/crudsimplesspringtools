package contatos.com.br;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Contato1MvcController {

	@Autowired
	ContatoDeServico servico;
	
	@RequestMapping
	public String getAllContato1(Model model) {
		List<Contato1Entity> list = servico.getAllContato1();
		model.addAttribute("contato",list);
		return "list-contato1";
		
	}
}

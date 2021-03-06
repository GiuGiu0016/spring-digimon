package it.spring.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.spring.model.Allenatore;
import it.spring.model.Digimon;
import it.spring.service.AllenatoreService;
import it.spring.service.DigimonService;

@Controller
public class AllenatoreController {
	
	@Autowired
	private AllenatoreService allenatoreService;
	@Autowired
	private DigimonService digimonService;
	
	@RequestMapping(value= {"/", "/homeA"})
	public ModelAndView home() {
		List<Allenatore> listaAllenatore = allenatoreService.listAll();
		List<Digimon> listaDigimon = digimonService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listaAllenatore", listaAllenatore);
		mav.addObject("digiLista", listaDigimon);
		return mav;
	}
	
	@RequestMapping("/newAllenatore")
	public String newAllenatoreForm(Map<String, Object> model) {
		Allenatore allenatore = new Allenatore();
		model.put("allenatore", allenatore);
		return "aggiungi_allenatore";
	}
	
	@RequestMapping(value = "/saveAllenatore", method = RequestMethod.POST)
	public String saveAllenatore(@ModelAttribute("allenatore") Allenatore allenatore) {
		allenatoreService.save(allenatore);
		return "redirect:/";
	}
	@RequestMapping("/editAllenatore")
	public ModelAndView editAllenatoreForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("modifica_allenatore");
		Allenatore allenatore = allenatoreService.get(id);
		mav.addObject("allenatore", allenatore);
		
		return mav;
	}
	
	@RequestMapping("/deleteAllenatore")
	public String deleteAllenatoreForm(@RequestParam long id) {
		allenatoreService.delete(id);
		return "redirect:/homeA";		
	}

	@RequestMapping("/addDigimon")
	public String addDigimonForm(@RequestParam("idAllenatore")long idAllenatore, Map<String, Object> model) {
		Allenatore allenatore = allenatoreService.get(idAllenatore);
		List<Digimon> listaDigimon = digimonService.listAll();
		model.put("allenatore", allenatore);
		model.put("digimon", listaDigimon);
		return "aggiungi_digimonallenatore";
	}
	
	@RequestMapping(value = "/aggiungiDigimon", method = RequestMethod.POST)
	public String aggiungiAllaListaForm(@RequestParam("idDigimon") long idDigimon, @RequestParam("idAllenatore") long idAllenatore, Map<String, Object> model) {
		Digimon digimon = digimonService.get(idDigimon);
		Allenatore allenatore = allenatoreService.get(idAllenatore);
		allenatore.getListaDigimon().add(digimon);
		digimon.setAllenatore(allenatore);
		List<Digimon> listaDigimon = allenatore.getListaDigimon();
		allenatoreService.save(allenatore);
		digimonService.save(digimon);
		model.put("allenatore", allenatore);
		model.put("digimonAllenatore", listaDigimon);
		return "lista_AD";
	}
	
	
	

}

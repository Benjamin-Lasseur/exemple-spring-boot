package dev.exemple.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.exemple.entite.Exemple;
import dev.exemple.repository.ExempleRepository;

@Controller
@RequestMapping("/accueil")
public class AccueilController {
	@Autowired
	private ExempleRepository exempleRepo;

	@GetMapping
	public ModelAndView afficherAccueil() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("accueil");
		mv.addObject("listeExemples", exempleRepo.findAll());
		return mv;
	}

	@PostConstruct
	public void init() {
		for (int i = 0; i < 5; i++) {
			Exemple e = new Exemple();
			e.setChamp1("Prenom " + i);
			e.setChamp2("Nom " + i);
			exempleRepo.save(e);
		}

	}
}
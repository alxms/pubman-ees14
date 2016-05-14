package com.ees14.controller;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.ees14.entity.Publicacao;
import com.ees14.entity.Usuario;
import com.ees14.service.PublicacaoService;

@Controller
public class PublicacaoController {

	private static final Logger logger = Logger.getLogger(PublicacaoController.class);
	
	public PublicacaoController() {
		System.out.println("PublicacaoController()");
	}
	
	@Autowired
	private PublicacaoService publicacaoService;
	
    @RequestMapping(value = {"getAllPublicacoes", "/"})
    public ModelAndView getAllPublicacoes() {
    	logger.info("Buscando todas as Publicacoes.");
    	
    	ModelAndView model = new ModelAndView("publicacaoList");
        Usuario usuarioBean = new Usuario();
        model.addObject("usuarioBean", usuarioBean);
        
        List<Publicacao> publicacaoList = publicacaoService.getAllPublicacoes();
        model.addObject("publicacaoList", publicacaoList);
        
        return model;
    	
        //List<Publicacao> publicacaoList = publicacaoService.getAllPublicacoes();
        //return new ModelAndView(("publicacaoList", "publicacaoList", publicacaoList);
    }
}

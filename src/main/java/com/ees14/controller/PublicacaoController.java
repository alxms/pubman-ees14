package com.ees14.controller;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.ees14.entity.Publicacao;
import com.ees14.entity.Status;
import com.ees14.entity.Tipo;
import com.ees14.entity.Usuario;
import com.ees14.service.PublicacaoService;
import com.ees14.service.UsuarioService;

@Controller
public class PublicacaoController {

	private static final Logger logger = Logger.getLogger(PublicacaoController.class);
	
	public PublicacaoController() {
		System.out.println("PublicacaoController()");
	}
	
	@Autowired
	private PublicacaoService publicacaoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
    @RequestMapping("createPublicacao")
    public ModelAndView createPublicacao(@ModelAttribute Publicacao publicacao) {
    	logger.info("Criando nova Publicacao. Dados: " + publicacao);
    	
    	ModelAndView model = new ModelAndView("publicacaoForm");
    	model.addObject("publicacaoObject", publicacao);
    	
        return model;
    }
    
    @RequestMapping("editPublicacao")
    public ModelAndView editPublicacao(@RequestParam int id, @ModelAttribute Publicacao publicacao) {
    	logger.info("Atualizando a publicacao Id " + id);
    	publicacao = publicacaoService.getPublicacaoById(id);
    	
    	ModelAndView model = new ModelAndView("publicacaoForm");
    	model.addObject("publicacaoObject", publicacao);
        
    	model.addObject("tipoEnumList", Tipo.values());
    	model.addObject("statusEnumList", Status.values());
    	
    	return model;
    }
    
    @RequestMapping("savePublicacao")
    public ModelAndView savePublicacao(HttpServletRequest request, @ModelAttribute Publicacao publicacao) {
    	logger.info("Salvando publicacao. Dados : " + publicacao);
        if (publicacao.getIdPublicacao() == 0)
        {
        	HttpSession session = request.getSession();
	        int userId = (int) session.getAttribute("usuarioLogadoId");
	        
	        Usuario usuarioLogado = usuarioService.getUsuarioById(userId);
	        
        	Set<Usuario> usuarios = new HashSet<Usuario>();
        	usuarios.add(usuarioLogado);
        	publicacao.setUsuarios(usuarios);
        	
        	publicacaoService.createPublicacao(publicacao);
        } 
        else 
        {
        	publicacaoService.updatePublicacao(publicacao);
        }
        return new ModelAndView("redirect:getAllPublicacoes");
    }
    
    @RequestMapping("deletePublicacao")
    public ModelAndView deletePublicacao(@RequestParam int id) {
    	logger.info("Deletando a Publicacao. Id : "+id);
        publicacaoService.deletePublicacao(id);
        return new ModelAndView("redirect:getAllPublicacoes");
    }
	
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

package com.ees14.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ees14.entity.Usuario;
import com.ees14.service.UsuarioService;

@Controller
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	public LoginController() {
		System.out.println("LoginController()");
	}
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="executeLogin", method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, 
			@ModelAttribute("usuarioBean")Usuario usuario)
	{
		ModelAndView model= null;
		try
		{
			Usuario usuarioBanco = usuarioService.isValidUsuario(usuario.getLogin(), usuario.getSenha());
			if(usuarioBanco != null)
			{
				logger.info("Usuario logado com sucesso.");
				
		    	model = new ModelAndView("redirect:/");
		        
		        HttpSession session = request.getSession();
		        session.setAttribute("usuarioLogadoNome", usuarioBanco.getNome());
		        session.setAttribute("usuarioLogadoId", usuarioBanco.getId());
			}
			else
			{
				model = new ModelAndView("publicacaoList");
				String mensagemErro = "As credenciais informadas estão incorretas.";
				
				model.addObject("mensagemErro", mensagemErro);
			}

		}
		catch(Exception e)
		{
				e.printStackTrace();
		}

		return model;
	}
	
	@RequestMapping("executeLogout")
	public ModelAndView executeLogout(HttpServletRequest request)
	{
		request.getSession().removeAttribute("usuarioLogadoNome");
		request.getSession().removeAttribute("usuarioLogadoId");
		request.getSession().invalidate();
		return new ModelAndView("redirect:/");
	}
	
}

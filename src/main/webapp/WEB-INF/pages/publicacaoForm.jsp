<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pubman - Catálogo de Publicações</title>
    <!-- Bootstrap CSS -->
    <link href="<c:url value="/resources/css/login-dp.css" />" rel="stylesheet"> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>    
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body class=".container-fluid">

	<nav class="navbar navbar-inverse navbar-fixed-top">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>                        
	      </button>
	      <a class="navbar-brand" href="#">PUBMAN</a>
	    </div>
	    <div class="collapse navbar-collapse" id="myNavbar">
	      <ul class="nav navbar-nav navbar-right">
			
			<c:if test="${not empty usuarioLogadoId}">
				<li><p class="navbar-text"><c:out value="${usuarioLogadoNome}"/></p></li>
				<li><a href="executeLogout">Logout</a></li>
			</c:if>

	        <c:if test="${empty usuarioLogadoId}">
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
					<ul id="login-dp" class="dropdown-menu">
						<li>
						 <div class="row">
							<div class="col-md-12">
							 
							 <form:form cssClass="form" method="post" action="executeLogin" modelAttribute="usuarioBean" accept-charset="UTF-8" id="login-nav">
								<div class="form-group">
									 <label class="sr-only" for="exampleInputEmail2">
									 	usuário <form:errors path="login"/>
									 </label>
									 <form:input type="text" cssClass="form-control" id="login" path="login" placeholder="login" required="true" />
								</div>
								<div class="form-group">
									 <label class="sr-only" for="exampleInputPassword2">
									 	senha <form:errors path="senha"/>
									 </label>
									 <form:input type="password" cssClass="form-control" id="senha" path="senha" placeholder="senha" required="true" />
								</div>
								<div class="form-group">
									 <button id="executeLogin" type="submit" class="btn btn-primary btn-block">Login</button>
								</div>
							 </form:form>
							
							</div>
						 </div>
						</li>
					</ul>
		        </li>
	      	</c:if>
	      </ul>
	    </div>
	  </div>
	</nav>

	<div id="top" class="row">
		<br>
		<div class="col-md-6">
			<c:choose>
			<c:when test="${publicacaoObject.idPublicacao > 0}">
				<h2>Editar Publicação</h2>
			</c:when>
			<c:otherwise>
				<h2>Cadastrar Nova Publicação</h2>
			</c:otherwise>
			</c:choose>
       	</div>
	</div> <!-- /#top -->
	
	<div id="main" class="row">
	<br>
	</div> <!-- /#main -->
		<form:form id="publicacaoRegisterForm" cssClass="form-horizontal" modelAttribute="publicacaoObject" method="post" action="savePublicacao">
	    
			<div class="form-group">
		    	<form:label path="titulo" cssClass="control-label col-xs-3">
		    		Título <form:errors path="titulo"/>
		    	</form:label> 
			    <div class="col-xs-6">
			        <form:hidden path="idPublicacao"/>
			        <form:input cssClass="form-control" path="titulo" type="text" placeholder="Digite o título da publicação" required="true"/>
			    </div>
			</div>
			
			<div class="form-group">
			    <form:label path="autores" cssClass="control-label col-xs-3">
			    	Autores <form:errors path="titulo"/>
			    </form:label>
			    <div class="col-xs-6">
			        <form:input cssClass="form-control" path="autores" type="text" placeholder="Digite o nome dos autores" required="true"/>
			    </div>
			</div>
			
			<div class="form-group">
			    <div class="control-label col-xs-3">
			    	<form:label path="tipo">
			    		Tipo
			    	</form:label>
			    </div>
			    <div class="col-xs-3">
					<form:select path="tipo" cssClass="form-control">
					    <!--<c:forEach items="${tipoEnumList}" var="t">
					        <c:choose>
					            <c:when test="${t eq publicacaoObject.tipo}">
					                <option value="${t}" selected="true">${t.value}</option>
					            </c:when>
					            <c:otherwise>
					                <option value="${t}">${t.value}</option>
					            </c:otherwise>
					        </c:choose> 
					    </c:forEach>-->
						<form:options items="${tipoEnumList}" itemLabel="value"/>    
					</form:select>
			    </div>
			</div>
			
			<div class="form-group">
			    <form:label path="internacional" cssClass="control-label col-xs-3">
			    	Alcance
			    </form:label>
			    <div class="col-xs-3">
			    	<form:select path="internacional" cssClass="form-control">
				    	<c:choose>
				            <c:when test="${publicacaoObject.internacional}">
				                <option value="true" selected="true">Internacional</option>
				                <option value="false">Nacional</option>
				            </c:when>
				            <c:otherwise>
				                <option value="true">Internacional</option>
				                <option value="false" selected="true">Nacional</option>
				            </c:otherwise>
				        </c:choose> 
			    	</form:select>
			        <!--<form:radiobutton path="internacional" value="true" label="Internacional"/>
					<form:radiobutton path="internacional" value="false" label="Nacional"/>-->
			    </div>
			</div>
			
			<div class="form-group">
			    <div class="control-label col-xs-3">
			    	<form:label path="ano">
			    		Ano <form:errors path="ano"/>
			    	</form:label>
			    </div>
			    <div class="col-xs-3">
					<form:input cssClass="form-control" path="ano" type="number" placeholder="Digite o ano da publicação" required="true"/>
			    </div>
			</div>			

			<div class="form-group">
			    <div class="control-label col-xs-3">
			    	<form:label path="status">
			    		Status
			    	</form:label>
			    </div>
			    <div class="col-xs-3">
					<form:select path="status" cssClass="form-control">
						<form:options items="${statusEnumList}" itemLabel="value"/>
					</form:select>
			    </div>
			    <div class="col-xs-3">
			    	 <button type="button" class="btn btn-primary" disabled="disabled">Complementar Dados</button>
			    </div>
			</div>
			
			<div class="form-group">
			    <div class="control-label col-xs-3">
			    	<form:label path="link">
			    		Link <form:errors path="link"/>
			    	</form:label>
			    </div>
			    <div class="col-xs-6">
					<form:input cssClass="form-control" path="link" type="url" placeholder="Digite o link para o conteúdo da publicação."/>
			    </div>
			</div>

			<div class="form-group">
			    <div class="control-label col-xs-3">
			    	<form:label path="resumo">
			    		Resumo <form:errors path="resumo"/>
			    	</form:label>
			    </div>
			    <div class="col-xs-6">
					<form:textarea cssClass="form-control" path="resumo" rows="5" maxlength="1024" placeholder="Digite o resumo da publicação."/>
			    </div>
			</div>
			
			<div class="form-group">
			    <div class="row">
				    <div class="col-xs-3">
	                </div>
	                <div class="col-xs-6">
			    		<input type="submit" id="savePublicacao" class="btn btn-primary" value="Ok" />
			    		<a class="btn btn-warning" href="getAllPublicacoes">Cancelar</a>
					</div>
					<div class="col-xs-3">
	                </div>
			    </div>
			</div>
	    
		</form:form>
                
	<div id="bottom" class="row">
	</div>

</body>
</html>
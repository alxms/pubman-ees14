<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pubman - Catálogo de Publicações</title>
    <!-- Bootstrap CSS -->
    <link href="<c:url value="/resources/css/login-dp.css" />" rel="stylesheet"> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container {
            margin: 20px;
        }
    </style>
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
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
				<ul id="login-dp" class="dropdown-menu">
					<li>
					 <div class="row">
						<div class="col-md-12">
						 <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
							<div class="form-group">
								 <label class="sr-only" for="exampleInputEmail2">usuário</label>
								 <input type="text" class="form-control" id="usuario" placeholder="usuário" required>
							</div>
							<div class="form-group">
								 <label class="sr-only" for="exampleInputPassword2">senha</label>
								 <input type="password" class="form-control" id="senha" placeholder="senha" required>
							</div>
							<div class="form-group">
								 <button type="submit" class="btn btn-primary btn-block">Login</button>
							</div>
						 </form>
						</div>
					 </div>
					</li>
				</ul>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>

	<div id="top" class="row">
        <h2>Catálogo de Publicações</h2>
	</div> <!-- /#top -->
	
	<div id="list" class="row">
	    <div class="table-responsive col-md-12">
	        
	        <c:if test="${empty publicacaoList}">
	            Não há publicações cadastradas.
	        </c:if>

	        <c:if test="${not empty publicacaoList}">   
	            <table class="table table-hover" cellspacing="0" cellpadding="0">
	                <!--<thead style="background-color: #bce8f1;">-->
	                <tr>
	                    <th>Título</th>
	                    <th>Autor</th>
	                    <th>Tipo</th>
	                    <th>Alcance</th>
	                    <th>Ano</th>
	                    <th>Status</th>
	                    <th class="actions">Ações</th>
	                </tr>
	                <!-- </thead>  -->
	                <tbody>
	                <c:forEach items="${publicacaoList}" var="pub">
	                    <tr>
	                    	<td><c:out value="${pub.titulo}"/></td>
	                    	<td><c:out value="${pub.autores}"/></td>
	                    	<td><c:out value="${pub.tipo}"/></td>
	                    	<td><c:out value="${pub.internacional}"/></td> 
	                    	<td><c:out value="${pub.ano}"/></td>
	                    	<td><c:out value="${pub.status}"/></td>
	                        <td class="actions">
		                        <a class="btn btn-warning btn-xs" href="edit.html">Editar</a>
		                        <a class="btn btn-danger btn-xs"  href="#" data-toggle="modal" data-target="#delete-modal">Excluir</a>
	                   		</td>
	                    </tr>
	                </c:forEach>
	                </tbody>
	            </table>
	        </c:if>
	    </div>
	</div> <!-- /#list -->
	 
	 <div id="bottom" class="row">
	 
	 </div> <!-- /#bottom -->    

	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
	                <h4 class="modal-title" id="modalLabel">Excluir Item</h4>
	            </div>
	            <div class="modal-body">Deseja realmente excluir este item? </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-primary">Sim</button>
	                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
	            </div>
	        </div>
	    </div>
	</div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>    
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
    <%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
     --%>

</body>
</html>

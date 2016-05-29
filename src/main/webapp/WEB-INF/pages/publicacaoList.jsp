<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pubman - Catálogo de Publicações</title>
    <!-- CSS -->
    <link href="<c:url value="/resources/css/login-dp.css" />" rel="stylesheet"> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
    
    <!-- JS -->
	<script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>  
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript">

		$(document).ready(function() {
			$('#pub-table').DataTable({
			    language: {
			        url: '//cdn.datatables.net/plug-ins/1.10.11/i18n/Portuguese-Brasil.json'
			    },
			    "order": [[ 4, 'asc' ], [ 2, 'asc' ], [ 1, 'asc' ]]
			});
		} );

	</script>
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
        <c:if test="${not empty mensagemErro}">
        	<br>
	        <div class="alert alert-warning">
	        	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Atenção!</strong> <c:out value="${mensagemErro}"/>
			</div>
		</c:if>
		
		<c:if test="${empty mensagemErro}">
			<br>
			<div class="col-md-6">
        		<h2>Catálogo de Publicações</h2>
        	</div>
        	
        	<div class="col-md-3">
        	</div>
        	
        	<div class="col-md-3">
        		<c:if test="${not empty usuarioLogadoId}">
					<a href="createPublicacao" class="btn btn-primary pull-right h2">Nova Publicação</a>
				</c:if>
    		</div>
        </c:if>
	</div> <!-- /#top -->
	
	<div id="list" class="row">
    <hr>
	<br>
	<c:if test="${empty mensagemErro}">
	    <div cssClass="table-responsive col-md-12">
        
	        <c:if test="${empty publicacaoList}">
	            Não há publicações cadastradas.
	        </c:if>

	        <c:if test="${not empty publicacaoList}">  

	            <table id="pub-table" class="display">
	                <thead>
	                <tr>
	                    <th>Título</th>
	                    <th>Autor</th>
	                    <th>Tipo</th>
	                    <th>Alcance</th>
	                    <th>Ano</th>
	                    <th>Status</th>
	                    <c:if test="${not empty usuarioLogadoId}">
	                    	<th class="actions">Ações</th>
	                    </c:if>
	                </tr>
	                </thead>
	                <tbody>
	                <c:forEach items="${publicacaoList}" var="pub">
	                    <tr>
	                    	<td><c:out value="${pub.titulo}"/></td>
	                    	<td><c:out value="${pub.autores}"/></td>
	                    	<td><c:out value="${pub.tipoStr}"/></td>
	                    	<td><c:out value="${pub.alcance}"/></td> 
	                    	<td><c:out value="${pub.ano}"/></td>
	                    	<td><c:out value="${pub.statusStr}"/></td>
	                    	<c:if test="${not empty usuarioLogadoId}">
		                        <td class="actions">
			                        <a class="btn btn-warning btn-xs" href="editPublicacao?id=<c:out value='${pub.idPublicacao}'/>">Editar</a>
			                        <a class="open-dialog btn btn-danger btn-xs"  href="#" data-toggle="modal" data-target="#delete-modal" data-id="<c:out value='${pub.idPublicacao}'/>">Excluir</a>
		                   		</td>
		                   	</c:if>
	                    </tr>
	                </c:forEach>
	                </tbody>
	            </table>

	        </c:if>
	    </div>
	</c:if>
	</div> <!-- /#list -->
	 
	 <div id="bottom" class="row">
		 <div class="col-md-12">
	         <!--
	        <ul class="pagination">
	            <li class="disabled"><a>&lt; Anterior</a></li>
	            <li class="disabled"><a>1</a></li>
	            <li><a href="#">2</a></li>
	            <li><a href="#">3</a></li>
	            <li class="next"><a href="#" rel="next">Próximo &gt;</a></li>
	        </ul> /.pagination -->
	 
	    </div>
	 </div> <!-- /#bottom -->    

	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
	                <h4 class="modal-title" id="modalLabel">Excluir Publicação</h4>
	            </div>
	            <div class="modal-body">Deseja realmente excluir esta publicação? </div>
	            <div class="modal-footer">
	                <a href="#" class="btn btn-primary" id="modal-confirm">Sim</a>
	                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
	            </div>
	        </div>
	    </div>
	</div>

<script type="text/javascript">

	$(document).on("click", 
				   ".open-dialog", 
				   function () 
				   {
	 			   		var publicacaoId = $(this).data('id');
	 					$("#modal-confirm").attr("href", "deletePublicacao?id=" + publicacaoId);
				   });
</script>

</body>
</html>

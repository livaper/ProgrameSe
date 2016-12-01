<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- Esta inclusão abaixo é importante ser mantida por conta da utilização da cláusula c:if -->
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap-theme.min.css" /> 		
		<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="top-border"></div>
			<br><br><br>
		<div class="container">
			<div class="row col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="row">
							<div class="col-sm-6 col-md-10"><h1>Programe-Se</h1>
								<h4>Seja bem vindo(a): ${nomeUsuario}</h4>
							</div>
							<div class="col-sm-6 col-md-2 pull-right"><img src="./resources/bootstrap/img/logoProgrameSe.png" width="100" height="100"></div>
						</div>
						<br>
						
						<c:if test="${inclusao == true && entradaSucesso == true}"> 
							<hr>
							<div class="alert alert-success">Cadastro de Objeto de Aprendizagem Realizado Com Sucesso! : )</div>
							<form method="post" action="authentication">
								<input type="hidden" name="index" value="<%=request.getAttribute("index")%>"/>
								<input type="hidden" name="login" value="<%=request.getAttribute("login")%>"/>
								<input type="hidden" name="senha" value="<%=request.getAttribute("senha")%>"/>
								<input type="hidden" name="nomeUsuario" value="<%=request.getAttribute("nomeUsuario")%>"/>
								<button type="submit" class="btn btn-primary">Voltar</button>
							</form>
						</c:if>
						<c:if test="${inclusao == true && entradaSucesso == false}"> 
							<hr>
							<div class="alert alert-danger">Ocorreu um erro ao tentar realizar o cadastro. Por favor, tente novamente mais tarde.</div>
							<form method="post" action="authentication">
								<input type="hidden" name="index" value="<%=request.getAttribute("index")%>"/>
								<input type="hidden" name="login" value="<%=request.getAttribute("login")%>"/>
								<input type="hidden" name="senha" value="<%=request.getAttribute("senha")%>"/>
								<input type="hidden" name="nomeUsuario" value="<%=request.getAttribute("nomeUsuario")%>"/>
								<button type="submit" class="btn btn-primary">Voltar</button>
							</form>
						</c:if>
						
						<c:if test="${inclusao != true && saida != true}"> 
							<hr>
							<div class="container-fluid">
								<h2>Objetos de Aprendizado em Pensamento Computacional</h2>
								<br>
								<form method="post" action="redirecionaCadastroObjeto" >
									<input type="hidden" name="index" value="<%=request.getAttribute("index")%>"/>
									<input type="hidden" name="login" value="<%=request.getAttribute("login")%>"/>
									<input type="hidden" name="senha" value="<%=request.getAttribute("senha")%>"/>
									<input type="hidden" name="nomeUsuario" value="<%=request.getAttribute("nomeUsuario")%>"/>
									<button type="submit" value="entrada" class="btn btn-primary pull-right" name="entrada" >Cadastrar Objeto de Aprendizado <span class="glyphicon glyphicon-plus"></span></button>									
								</form>
								<br>
							
								<hr>
								<div id="objetos" class="table-responsive">
									<h3>Buscar um objeto </h3><input class="search" placeholder="Buscar objeto"></h3>
									<br><br><br>
									<table class="table table-hover">
										<thead class="table-head-brown">
											<tr>
												<th width="150" style="font-size:20px">Titulo<br></th>
												<th style="font-size:20px">Assuntos Pedagógicos</th>
												<th style="font-size:20px">Conceitos Computacionais</th>
												<th style="font-size:20px">Formas de Abordagem</th>
												<th></th>
											</tr>
										</thead>
										<tbody class="list">
											<c:forEach items="${objetos}" var="objeto">
												<tr>
													<td class="titulo"><a href=/detalheObjeto.jsp?id=${objeto.id}>${objeto.titulo}</a></td>
													
													<td>
														<c:forEach items="${objeto.assuntosPedagogicos}" var="assunto">
															<div class="assunto"><span class="label label-primary">${assunto.titulo}</span></div><br>  
														</c:forEach>
													</td>
													
													<td>
														<c:forEach items="${objeto.areasComputacao}" var="area">
															<div class="area"><span class="label label-info">${area.titulo} </span></div><br>
														</c:forEach>
													</td>
													
													<td>
														<c:forEach items="${objeto.formasAbordagens}" var="forma">
															<div class="forma"><span class="label  label-warning">${forma.titulo}</span></div><br>
														</c:forEach>
																											
													</td>
													
													<td>
														<form action="redirecionaMaisDetalhesObjeto" method="post">
															<input type="hidden" name="login" value="<%=request.getAttribute("login")%>"/>
															<input type="hidden" name="senha" value="<%=request.getAttribute("senha")%>"/>
															<input type="hidden" name="nomeUsuario" value="<%=request.getAttribute("nomeUsuario")%>"/>
															<input type="hidden" name="idObjeto" value="${objeto.id}"/>
															<input type="hidden" name="tituloObjeto" value="${objeto.titulo}"/>
															<input type="hidden" name="objetivoObjeto" value="${objeto.objetivo}"/>
															<input type="hidden" name="quantidadeMinimaObjeto" value="${objeto.quantidadeMinimaPessoas}"/>
															<input type="hidden" name="quantidadeMaximaObjeto" value="${objeto.quantidadeMaximaPessoas}"/>
															<input type="hidden" name="descricaoObjeto" value="${objeto.descricao}"/>
															<input type="hidden" name="feedbackObjeto" value="${objeto.feedback}"/>
															<input type="hidden" name="referenciasObjeto" value="${objeto.referencias}"/>
															
															<button class="btn btn-primary btn-sm">Mais Detalhes  <span class="glyphicon glyphicon-zoom-in"></span></button>
														</form>
													</td>
													
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<hr>
								</div>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	<script src="http://listjs.com/assets/javascripts/list.min.js"></script>
	
	<script>
		var options = {
				  valueNames: [ 'titulo', 'assunto', 'forma', 'area' ]
		};
	
		var userList = new List('objetos', options);
	</script>	
	</body>
</html>

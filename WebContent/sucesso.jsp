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
							<div class="col-sm-6 col-md-10"><h1>Programe Se</h1>
								<h4>Seja bem vindo(a): ${nomeUsuario}</h4>
							</div>
							<div class="col-sm-6 col-md-2 pull-right"><img src="./resources/bootstrap/img/logoProgrameSe.png" width="100" height="100"></div>
						</div>
						<br>
						<form method="post" action="redirecionaCadastroObjeto">
							<input type="hidden" name="index" value="<%=request.getAttribute("index")%>"/>
							<input type="hidden" name="login" value="<%=request.getAttribute("login")%>"/>
							<input type="hidden" name="senha" value="<%=request.getAttribute("senha")%>"/>
							<input type="hidden" name="nomeUsuario" value="<%=request.getAttribute("nomeUsuario")%>"/>
							<button type="submit" value="entrada" class="btn btn-primary" name="entrada" >Registrar Objeto de Aprendizado</button>
						</form>
						
						
						
						
						
						
						
						<c:if test="${inclusao == true && entradaSucesso == true}"> 
							<hr>
							<div class="alert alert-success" role="alert">Entrada Realizada Com Sucesso! : )</div>
							<form method="post" action="authentication">
								<input type="hidden" name="index" value="<%=request.getAttribute("index")%>"/>
								<input type="hidden" name="login" value="<%=request.getAttribute("login")%>"/>
								<input type="hidden" name="senha" value="<%=request.getAttribute("senha")%>"/>
								<input type="hidden" name="nomeUsuario" value="<%=request.getAttribute("nomeUsuario")%>"/>
								<button type="submit" class="btn btn-primary">Voltar</a>
							</form>
						</c:if>
						<c:if test="${inclusao == true && entradaSucesso == false}"> 
							<hr>
							<div class="alert alert-danger" role="alert">Ocorreu um erro ao tentar realizar a entrada. Por favor, tente novamente mais tarde.</div>
							<form method="post" action="authentication">
								<input type="hidden" name="index" value="<%=request.getAttribute("index")%>"/>
								<input type="hidden" name="login" value="<%=request.getAttribute("login")%>"/>
								<input type="hidden" name="senha" value="<%=request.getAttribute("senha")%>"/>
								<input type="hidden" name="nomeUsuario" value="<%=request.getAttribute("nomeUsuario")%>"/>
								<button type="submit" class="btn btn-primary">Voltar</a>
							</form>
						</c:if>
						
						<c:if test="${saida == true && saidaSucesso == true}"> 
							<hr>
							<div class="alert alert-success" role="alert">Saída Realizada Com Sucesso! : )</div>
							<form method="post" action="authentication">
								<input type="hidden" name="index" value="<%=request.getAttribute("index")%>"/>
								<input type="hidden" name="login" value="<%=request.getAttribute("login")%>"/>
								<input type="hidden" name="senha" value="<%=request.getAttribute("senha")%>"/>
								<input type="hidden" name="nomeUsuario" value="<%=request.getAttribute("nomeUsuario")%>"/>
								<button type="submit" class="btn btn-primary">Voltar</a>
							</form>
						</c:if>
						<c:if test="${saida == true && saidaSucesso == false}"> 
							<hr>
							<div class="alert alert-danger" role="alert">Ocorreu um erro ao tentar realizar a saída. Por favor, tente novamente mais tarde.</div>
							<form method="post" action="authentication">
								<input type="hidden" name="index" value="<%=request.getAttribute("index")%>"/>
								<input type="hidden" name="login" value="<%=request.getAttribute("login")%>"/>
								<input type="hidden" name="senha" value="<%=request.getAttribute("senha")%>"/>
								<input type="hidden" name="nomeUsuario" value="<%=request.getAttribute("nomeUsuario")%>"/>
								<button type="submit" class="btn btn-primary">Voltar</a>
							</form>
						</c:if>
						
						<c:if test="${inclusao != true && saida != true}"> 
							<hr>
							<div class="container-fluid">
								<h3>Valor do Patrimônio atual: R$ ${patrimonio}</h3>
								<h3>Materiais disponíveis</h3>
								<div class="table-responsive">
									<table class="table table-condensed">
										<thead class="table-head-brown">
											<tr>
												<th width="150">Almoxarifado</th>
												<th>Setor</th>
												<th>Material</th>
												<th>Fornecedor</th>
												<th width="150">Quantidade Disponível</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${alocacoes}" var="alocacao">
												
												<tr>
													<td>${alocacao.setor.almoxarifado.codigo}</td>
													<td>${alocacao.setor.nome}</td>
													<td>${alocacao.material.descricao}</td>
													<td>${alocacao.fornecedor.nome}</td>
													<td>${alocacao.quantidade}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>

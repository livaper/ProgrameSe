<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Entrada</title>
		<link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap-theme.min.css" />
 		<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		
		<div class="top-border"></div>
		<form method="post" action="cadastroObjeto">
			<input type="hidden" name="index" value="<%=request.getAttribute("index")%>"/>
			<input type="hidden" name="login" value="<%=request.getAttribute("login")%>"/>
			<input type="hidden" name="senha" value="<%=request.getAttribute("senha")%>"/>
			<input type="hidden" name="nomeUsuario" value="<%=request.getAttribute("nomeUsuario")%>"/>
			<br><br><br>
			<div class="container">
				<div class="row col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-sm-6 col-md-10">
									<h1>Programe Se</h1>
								</div>
								<div class="col-sm-6 col-md-2"><img src="./resources/bootstrap/img/logoProgrameSe.png" width="100" height="100"></div>
								<div class="col-sm-6 col-md-10"><h3>Cadastrar Objeto de Aprendizado</h3></div>
								
							</div>
								
							<hr>
								<div class="form-group">
									<div class="row">

										<div class="col-sm-6 col-md-12"><label>Título</label>
											<input required type="text" placeholder="Digite o título do Objeto de Aprendizado" class="form-control margin-top-xs" name="titulo"/>
											<hr>
										</div>
										
										<div class="col-sm-6 col-md-12"><label>Assunto Pedagógico</label><br>
											|<c:forEach items="${assuntos}" var="assuntoPedagogico">
										  		${assuntoPedagogico.titulo} <input type="checkbox" class="checkbox-inline" id="inlineCheckbox1" name="assuntoPedagogicoIds" value="${assuntoPedagogico.id}">  |
											</c:forEach>
											<hr>
										</div>

										<div class="col-sm-6 col-md-12 ">
											<label>Formas de Abordagem</label><br>
											<c:forEach items="${formas}" var="formaAbordagem">
												<input type="checkbox" class="checkbox-inline" id="inlineCheckbox2" name="formaAbordagem" value="${formaAbordagem.id}"> ${formaAbordagem.titulo}
												 <br><br><b>Subabordagens:</b>
												<c:forEach items="${formaAbordagem.formasSubAbordagem}" var="formaSubAbordagem">
													<input type="radio" class="radio-inline" id="inlineCheckbox3" name="formaSubAbordagem" value="${formaSubAbordagem.id}"> ${formaSubAbordagem.titulo}
												</c:forEach>
												<hr>
											</c:forEach>
										</div>

										<div class="col-sm-6 col-md-12"><label>Objetivo</label>
											<input required type="text" placeholder="Digite o objetivo do Objeto de Aprendizado" class="form-control margin-top-xs" name="objetivo"/>
										<hr>
										</div>

										<div class="col-sm-6 col-md-3"><label>Quantidade Mínima de Pessoas</label>
											<input required type="text" class="form-control margin-top-xs" name="quantidadeMinimaPessoas"/>
										</div>

										<div class="col-sm-6 col-md-3"><label>Quantidade Máxima de Pessoas</label>
											<input required type="text" class="form-control margin-top-xs" name="quantidadeMaximaPessoas"/>
										</div>

										<div class="col-sm-6 col-md-6">
										</div>
										
										<div class="col-sm-6 col-md-12">
											<hr>
										</div>
										
										<div class="col-sm-6 col-md-12"><label>Descrição</label>
											<textarea required type="text" placeholder="Descreva aqui a prática" class="form-control margin-top-xs" rows="8" name="descricao"></textarea>
											<hr>
										</div>
										
										<div class="col-sm-6 col-md-12"><label>Feedback</label>
											<textarea required type="text" placeholder="Descreva como foi sua percepção do feedback dado pela turma" class="form-control margin-top-xs" rows="5" name="feedback"></textarea>
											<hr>
										</div>
	
										<div class="col-sm-6 col-md-12"><label>Referências</label>
											<textarea required type="text" placeholder="Coloque aqui as referências que julgar necessário para os alunos acompanharem a prática, bem como as utilizadas na elaboração do material" class="form-control margin-top-xs" rows="4" name="referencias"></textarea>
											<hr>
										</div>
										
									</div>
									<br>
									<button type="submit" class="btn btn-primary pull-right">Salvar</button>
								</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>

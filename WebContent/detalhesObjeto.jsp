<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Programa-Se</title>
		<link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap-theme.min.css" />
 		<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		
		<div class="top-border"></div>
		<form method="post" action="exportarPDF">
			<input type="hidden" name="index" value="<%=request.getAttribute("index")%>"/>
			<input type="hidden" name="login" value="<%=request.getAttribute("login")%>"/>
			<input type="hidden" name="senha" value="<%=request.getAttribute("senha")%>"/>
			<input type="hidden" name="nomeUsuario" value="<%=request.getAttribute("nomeUsuario")%>"/>
			<input type="hidden" name=idObjeto value="<%=request.getAttribute("idObjeto")%>"/>
			
			<br><br><br>
			<div class="container">
				<div class="row col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-sm-6 col-md-10">
									<h1>Programe-Se</h1>
								</div>
								<div class="col-sm-6 col-md-2"><img src="./resources/bootstrap/img/logoProgrameSe.png" width="100" height="100"></div>
								<div class="col-sm-6 col-md-10"></div>
								
							</div>
								
							<hr>
								<div class="form-group">
									<div class="row">

										<div class="col-sm-6 col-md-12">
											<h3>${tituloObjeto}</h3>
											<hr>
										</div>
										<div class="col-sm-6 col-md-12">
											<h4>Autor(a): ${nomeAutor}</h4>
											<hr>
										</div>
										
										<div class="col-sm-6 col-md-12"><label>Assunto Pedagógico</label>:<br>
											<c:forEach items="${assuntosObjeto}" var="assuntoPedagogico">
										  		<span class="label label-primary">${assuntoPedagogico.titulo}  </span>
											</c:forEach>
											<hr>
										</div>
										
										<div class="col-sm-6 col-md-12 ">
											<label>Conceitos de Computação </label>:<br>
											<c:forEach items="${areasObjeto}" var="areaComputacao">
										  		<span class="label label-info">${areaComputacao.titulo}  </span>
											</c:forEach>
											<hr>
										</div>

										<div class="col-sm-6 col-md-12 ">
											<label>Formas de Abordagem</label>:<br>
											<c:forEach items="${formasObjeto}" var="formaAbordagem">
												<span class="label label-warning">${formaAbordagem.titulo} &nbsp&nbsp&nbsp&nbsp</span>
											</c:forEach>
											<hr>
										</div>
										
										<div class="col-sm-6 col-md-12"><label>Objetivo</label>:<br>
											${objetivoObjeto}
										<hr>
										</div>

										<div class="col-sm-6 col-md-3"><label>Quantidade Mínima de Pessoas:</label><br>
											${quantidadeMinimaObjeto}
										</div>

										<div class="col-sm-6 col-md-3"><label>Quantidade Máxima de Pessoas:</label><br>
											${quantidadeMaximaObjeto}
										</div>

										<div class="col-sm-6 col-md-6">
										</div>
										
										<div class="col-sm-6 col-md-12">
											<hr>
										</div>
										
										<div class="col-sm-6 col-md-12"><label>Descrição</label>:<br>
											${descricaoObjeto}
											<hr>
										</div>
										
										<div class="col-sm-6 col-md-12"><label>Feedback</label>:<br>
											${feedbackObjeto}
											<hr>
										</div>
	
										<div class="col-sm-6 col-md-12"><label>Referências</label>:<br>
											${referenciasObjeto}
											<hr>
										</div>
										
									</div>
									<br>
									<button type="submit" class="btn btn-primary pull-right">Exportar para .txt</button>
								</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>

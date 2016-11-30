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
		<form method="post" action="cadastroUsuario">
			<input type="hidden" name="index" value="<%=request.getAttribute("index")%>"/>
			
			<br><br><br>
			<div class="container">
				<div class="row col-md-12">
					<div class="col-md-6 col-md-offset-3">
						<div class="panel panel-default">
							<div class="panel-body">
								<img src="./resources/bootstrap/img/logoProgrameSe.png" width="100" height="100">
								<h3>Programe-Se</h3>
								<c:if test="${loginExistente == true}"> 
									<div class="alert alert-danger" role="alert">Login já existente! Favor escolher outro login.</div>
								</c:if>
								<hr>
									<div class="form-group">
										<label>Login</label>
										<input required type="text" placeholder="Digite um login" class="form-control" name="login"/>
									</div>
									<div class="form-group">
										<label>Senha</label>
										<input required type="password" class="form-control" placeholder="Digite a Senha" name="senha"/>
									</div>
									<div class="form-group">
										<label>Nome</label>
										<input required type="text" class="form-control" placeholder="Digite o seu nome completo" name="nome"/>
									</div>
									<div class="form-group">
										<label>Email</label>
										<input required type="email" class="form-control" placeholder="Digite o seu email" name="email"/>
									</div>
									<div class="form-group">
										<label>Cidade</label>
										<input required type="text" class="form-control" placeholder="Digite sua cidade" name="cidade"/>
									</div>
									<div class="form-group">
										<label>Estado</label>
										<input required type="text" class="form-control" placeholder="Digite seu estado" name="estado"/>
									</div>
									<div class="form-group">
										<label>Perfil</label>
										<select class="form-control margin-top-xs" name="tipo">
											<option selected="selected">Selecione um Perfil...</option>
											<option value="E">Estudante</option>
											 <option value="P">Professor</option>
											 <option value="O">Outros</option>
										</select>
									</div>
									<button type="submit" class="btn btn-primary pull-right" name="cadastro" value="true">Cadastre-se</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>

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
		<form method="post" action="authentication">
			<input type="hidden" name="index" value="<%=request.getAttribute("index")%>"/>
			
			<br><br><br>
			<div class="container">
				<div class="row col-md-12">
					<div class="col-md-6 col-md-offset-3">
						<div class="panel panel-default">
							<div class="panel-body">
								<img src="./resources/bootstrap/img/logoProgrameSe.png" width="100" height="100">
								<h3>Programe-Se</h3>
								<c:if test="${loginInvalido == true}"> 
									<div class="alert alert-danger" role="alert">Nome de usuario ou senha inválidos!</div>
								</c:if>
								<hr>
									<div class="form-group">
										<label>Nome de Usuario</label>
										<input required type="text" placeholder="Digite o nome de usuario" class="form-control" name="login"/>
									</div>
									<div class="form-group">
										<label>Senha</label>
										<input required type="password" class="form-control" placeholder="Digite a Senha" name="senha"/>
									</div>
									<button type="submit" class="btn btn-primary pull-right">Entrar</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Crear Producto</title>
	</head>
	<body>
		<h1>Crear Producto</h1>
		
		<form action="productos" method="POST">
		<input type="hidden" name="opcion" value="guardar">
			<table border="1">
				<tr>
					<td>
						Nombre:
					</td>
					<td>
						<input type="text" name="nombre" size="50">
					</td>
				</tr>
				<tr>
					<td>
						Nombre:
					</td>
					<td>
						<input type="text" name="nombre" size="50">
					</td>
				</tr>
				<tr>
					<td>
						Nombre:
					</td>
					<td>
						<input type="text" name="nombre" size="50">
					</td>
				</tr>
			</table>
			<input type="submit" value="Guardar">
		</form>
	</body>
</html>
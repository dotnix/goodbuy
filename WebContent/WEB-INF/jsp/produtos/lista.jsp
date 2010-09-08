<table>
	<thead>
		<tr>
			<th>Nome</th>
			<th>Descri��o</th>
			<th>Pre�o</th>
			<th colspan="2">Op��es</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${produtoList}" var="produto">
			<tr>
				<td>${produto.nome }</td>
				<td>${produto.descricao }</td>
				<td>${produto.preco }</td>
				<td><a href="<c:url value="/produtos/${produto.id}"/>">Editar</a></td>
				<td>
					<form action="<c:url value="/produtos/${produto.id}"/>" method="POST">
						<button class="link" name="_method" value="DELETE">Remover</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<table>
	<thead>
		<tr>
			<th>Nome</th>
			<th>Descri��o</th>
			<th>Pre�o</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${produtoList}" var="produto">
			<tr>
				<td>${produto.nome }</td>
				<td>${produto.descricao }</td>
				<td>${produto.preco }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
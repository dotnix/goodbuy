<table>
	<thead>
		<tr>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Preço</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${produtoList}" var="produto">
			<tr>
				<td>${produto.nome }</td>
				<td>${produto.descricao }</td>
				<td>${produto.preco }</td>
				<td><a href="edita?id=${produto.id }">Editar</a></td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>
<form action="<c:url value="/produtos/${produto.id}"/>" method="POST">
	<fieldset>
	<legend>Editar Produto</legend>
		<input type="hidden" name="produto.id" value="${produto.id }" />
		
		<label for="nome">Nome:</label>
		<input id="nome" type="text" name="produto.nome" value="${produto.nome }"/>
		
		<label for="descricao">Descri��o:</label>
		<textarea id="descricao" name="produto.descricao">${produto.descricao }</textarea>
		
		<label for="preco">Pre�o:</label>
		<input id="preco" type="text" name="produto.preco" value="${produto.preco }"/>
		
		<button type="submit" name="_method" value="PUT">Enviar</button>
	</fieldset>
</form>

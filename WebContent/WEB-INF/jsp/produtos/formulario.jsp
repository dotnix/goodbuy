<form action="<c:url value="/produtos"/>" method="POST">
	<fieldset>
	<legend>Adicionar Produto</legend>
		<label for="nome">Nome:</label>
		<input id="nome" type="text" name="produto.nome" value="${produto.nome}"/>
		
		<label for="descricao">Descri��o:</label>
		<textarea id="descricao" name="produto.descricao">${produto.descricao}</textarea>
		
		<label for="preco">Pre�o:</label>
		<input id="preco" type="text" name="produto.preco" value="${produto.preco}"/>
		
		<button type="submit">Enviar</button>
	</fieldset>
</form>

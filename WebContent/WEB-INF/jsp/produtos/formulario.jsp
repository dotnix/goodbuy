<form id="produtosForm" action="<c:url value="/produtos"/>" method="POST">
	<fieldset>
	<legend>Adicionar Produto</legend>
		<label for="nome">Nome:</label>
		<input id="nome" id="nome" type="text" name="produto.nome" value="${produto.nome}"/>
		
		<label for="descricao">Descrição:</label>
		<textarea id="descricao" name="produto.descricao">${produto.descricao}</textarea>
		
		<label for="preco">Preço:</label>
		<input id="preco" id="preco" type="text" name="produto.preco" value="${produto.preco}"/>
		
		<button type="submit">Enviar</button>
	</fieldset>
</form>

<script type="text/javascript">
	$('#produtosForm').validate({
	    rules: {
	        "produto.nome": {
	            required: true,
	            minlength: 3
	        },
	        "produto.descricao": {
	            required: true,
	            maxlength: 40
	        },
	        "produto.preco": {
				required: true,
	            min: 0.0
	        }
	    },
	    messages: {
	    	"produto.nome": "O nome é obrigatório",
	    	"produto.descricao":"Informe uma decriação com menos de 40 caracteres",
	    	"produto.preco": "Informe um preço mais que 0"
		}
	});
</script>
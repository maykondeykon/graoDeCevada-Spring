//if($('.focus').lenght > 0){
	$('html, body').animate({
        scrollTop: $('.focus').offset().top - ($(window).height() - $('.focus').outerHeight(true)) / 2
   }, 'fast');	
//}


$('[data-toggle="tooltip"]').tooltip();

$('#confirmaExclusaoModal').on('show.bs.modal', function(event) {
	var botao = $(event.relatedTarget);
	var item = botao.data('item');
	var msg = botao.data('msg');
	var url = botao.data('url-delete');
	
	var modal = $(this);
	var form = modal.find('form');
	form.attr('action',url);
	modal.find('.modal-body span').html(
	'Tem certeza que deseja excluir '+msg+' <strong>'+item+'</strong>?'		
	);
});

$(document).on("click", ".alteraContatoLido", function () {
	var id = $(this).data("contatoid");
	
	$.get( "/contato/lido/"+id+"")
	  .done(function( data ) {
		  location.reload();
	  });
	
});

$('#avaliacaoModal').on('show.bs.modal', function(event) {
	var botao = $(event.relatedTarget);
	var id = botao.data('id');
	var item = botao.data('item');
	var msg = botao.data('msg');
	var url = botao.data('url-delete');
	
	$('.ratingStar').barrating('clear');
	$(this).find('.alert').remove();
	$('#msg').val('');
	
	var modal = $(this);
	var form = modal.find('form');
	var idCerveja = modal.find('#idCerveja');
	var nomeCerveja = modal.find('#nomeCerveja');
	
	
	$(idCerveja).val(id);
	$(nomeCerveja).html(item);
});

$(document).on("click", ".btSalvarAvaliacao", function () {
	var idCerveja = $(this).parent().parent().find('#idCerveja').val();
	var aromaAval = $(this).parent().parent().find('#aromaAval').val();
	var aparenciaAval = $(this).parent().parent().find('#aparenciaAval').val();
	var saborAval = $(this).parent().parent().find('#saborAval').val();
	var sensacaoAval = $(this).parent().parent().find('#sensacaoAval').val();
	var conjuntoAval = $(this).parent().parent().find('#conjuntoAval').val();
	var msgAval = $(this).parent().parent().find('#msg').val();
	
	var alertSuccess = '<div class="alert alert-success" role="alert">Sua avaliação foi recebida com sucesso</div>';
	var modalBody = $(this).parent().parent().find('.modal-body');
	
	var params = {
			idCerveja: idCerveja,
			aromaAval: aromaAval,
			aparenciaAval: aparenciaAval,
			saborAval: saborAval,
			sensacaoAval: sensacaoAval,
			conjuntoAval: conjuntoAval,
			msgAval:msgAval
        };
	
	console.log(params);
	
	$.post( "/cerveja/avalia", params)
	  .done(function( data ) {
	    $(modalBody).prepend(alertSuccess);
	  });
	
});

$(function() {
    $('.ratingStar').barrating({
      theme: 'fontawesome-stars'
    });
 });
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

$(function() {
    $('.ratingStar').barrating({
      theme: 'fontawesome-stars'
    });
 });
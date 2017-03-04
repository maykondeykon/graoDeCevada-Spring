$('html, body').animate({
         scrollTop: $('.focus').offset().top - ($(window).height() - $('.focus').outerHeight(true)) / 2
    }, 'fast');

$('[data-toggle="tooltip"]').tooltip();

$('#confirmaExclusaoModal').on('show.bs.modal', function(event) {
	var botao = $(event.relatedTarget);
	var marca = botao.data('marca');
	var url = botao.data('url-delete');
	
	var modal = $(this);
	var form = modal.find('form');
	form.attr('action',url);
	modal.find('.modal-body span').html(
	'Tem certeza que deseja excluir a cerveja <strong>'+marca+'</strong>?'		
	);
});
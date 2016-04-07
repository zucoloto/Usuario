$(document).ready(function() {

	$('.js-toggle').bind('click', function() {
		$('.js-menu').toggleClass('is-toggled');
		$('.js-conteudo').toggleClass('is-toggled');
		$('.js-footer').toggleClass('is-toggled');
	});

});
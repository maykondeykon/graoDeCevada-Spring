$('html, body').animate({
         scrollTop: $('.focus').offset().top - ($(window).height() - $('.focus').outerHeight(true)) / 2
    }, 'fast');
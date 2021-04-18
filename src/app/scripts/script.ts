$(document).ready(function(){

    $('#menu').click(function(){
        $(this).toggleClass('fa-times');
        $('.navbar').toggleClass('nav-toggle');
    });

    $(window).on('load scroll', function(){
        $(this).removeClass('fa-times');
        $('.navbar').removeClass('nav-toggle');

        if ($(window).scrollTop() > 60){
            $('header .header-2').addClass('header-active');
        }

        else{
            $('header .header-2').removeClass('header-active');
        }
    
    $('section').each(function(){

        let height = $(this).height();
        let top = $(window).scrollTop();
        let offset = $(this).offset().top - 200;
        let id = $(this).attr('id');

        if (top >= offset && top < offset +height){
            $('.navbar ul li a').removeClass('active');
            $('.navbar').find(`href = "#${id}"`).addClass('active');
        }

    });
    
    
    });
});
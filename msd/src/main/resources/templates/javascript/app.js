$(document).ready(function () {

    function showNavbar(toggleId, navId, bodyId, headerId) {
        const toggle = $('#' + toggleId);
        const nav = $('#' + navId);
        const bodypd = $('#' + bodyId);
        const headerpd = $('#' + headerId);

        if (toggle.length && nav.length && bodypd.length && headerpd.length) {
            toggle.on('click', function () {
                nav.toggleClass('show');
                toggle.toggleClass('bx-x');
                bodypd.toggleClass('body-pd');
                headerpd.toggleClass('body-pd');
            });
        }
    }

    // showNavbar('header-toggle', 'nav-bar', 'body-pd', 'header');

    const linkColor = $('.nav_link');

    function colorLink() {
        if (linkColor.length) {
            linkColor.removeClass('active');
            $(this).addClass('active');
        }
    }

    linkColor.on('click', colorLink);

    $('#data-table').DataTable();

});

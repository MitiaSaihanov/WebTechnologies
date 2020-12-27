$(document).ready(function() {
if (Cookies.get('City') != null) {
        $('#myBtn').text(Cookies.get('City'));
    }

    $(".deletbutton").click(function() {
        $.ajax({
                    contentType: 'application/String',
                    url: '/deletProductSession',
                    data: {
                                 "idProduct":   $(this).attr('id')
                                },
                    dataType: 'html',
                     success: function(result) {
                        $('#ContElement').html(result);
                                }
                });
    });
     $(".cellbutton").click(function() {
            $.ajax({
                        contentType: 'application/String',
                        url: '/cellProductSession',
                        dataType: 'html',
                         success: function(result) {
                          $('#ContElement').html(result);
                                    }
                    });
        });
}
)
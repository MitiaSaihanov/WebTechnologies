$(document).ready(function() {
    let cartCounterLabel = document.querySelector('#cart-counter');
    $('#fileter_category').change(function() {
        $.ajax({
            url: "/sortUser",
            method: 'post',
            data: {
                "sortP": $(this).val()
            },
            success: function(result) {
                $('#ContElement').html(result);
            }
        })
    });
    $('#fileter_sort').change(function() {
        $.ajax({
            url: "/orderBy",
            method: 'post',
            data: {
                "filtrP": $(this).val()
            },
            success: function(result) {
                $('#ContElement').html(result);
            }
        });
    });
    $('#fileter_sort').change(function() {
        $.ajax({
            url: "/orderBy",
            method: 'post',
            data: {
                "filtrP": $(this).val()
            },
            success: function(result) {
                $('#ContElement').html(result);
            }
        });
    });
    // Get the modal
    var modal = document.getElementById("myModal");
    // Get the button that opens the modal
    var btn = document.getElementById("myBtn");
    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];
    // When the user clicks the button, open the modal
    $('#filter-city').change(function() {
        Cookies.remove('City');
        Cookies.set('City', $(this).val());
        $('#myBtn').text($(this).val());
        location.reload(false);
    });
    var addData = {};
    $(".btn").click(function() {
        addData["ProductId"] = $(this).attr('id');
        console.log(addData);
        doAjaxAddToCart();
        doCount();
    });
    btn.onclick = function() {
            modal.style.display = "block";
        }
        // When the user clicks on <span> (x), close the modal
    $('#myBtn').onclick = function() {
            modal.style.display = "none";
        }
        // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
    if (Cookies.get('City') == null) {
        var modal1 = document.getElementById("myModal");
        modal1.style.display = "block";
    }
    if (Cookies.get('City') != null) {
        $('#myBtn').text(Cookies.get('City'));
    }


    function doAjaxAddToCart() {
        $.ajax({
            type: 'POST',
            contentType: 'application/String',
            url: '/add',
            data: JSON.stringify(addData),
            dataType: 'html',
            success: function(result) {
                console.log(result);
            }
        });

    }

    function doCount() {
        $.ajax({
            url: '/getCount',
            success: function(data) {
                cartCounterLabel.style.display = 'block';
                cartCounterLabel.innerHTML = data;
            }
        });
    }
});
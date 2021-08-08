var main = {
    init : function () {
        var _this = this;

        $('#btn-get').on('click', function () {
            _this.get();
        });

    },
    get : function () {
        var data = {
            url : $('#url').val()
        };

        $.ajax({
            method: 'POST',
            url: '/shorten',
            data: data,
            dataType: "text"
        }).done(function(data) {
            $('#shortUrl').attr('href',data);
            $('#shortUrl').text(data);
        }).fail(function (error) {
            alert(error.responseText);
        });
    }
}

main.init();
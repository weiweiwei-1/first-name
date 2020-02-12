$(function () {

    /**
     * Some examples of how to use features.
     *
     **/

    var RobaExamle = {
        Message: {
            add: function (message, type) {
                var chat_body = $('.layout .content .chat .chat-body');
                if (chat_body.length > 0) {

                    type = type ? type : '';
                    message = message ? message : 'I did not understand what you said!';

                    $('.layout .content .chat .chat-body .messages').append(`<div class="message-item ` + type + `">
                        <div class="message-avatar">
                            <figure class="avatar" title="` + (type == 'outgoing-message' ? 'Mirabelle Tow' : 'Byrom Guittet') + `">
                                <img src="./dist/media/img/` + (type == 'outgoing-message' ? 'women_avatar5.jpg' : 'man_avatar3.jpg') + `" class="rounded-circle">
                            </figure>
                        </div>
                        <div>
                            <div class="message-content">
                                ` + message + `
                            </div>
                            <div class="time">14:50 PM ` + (type == 'outgoing-message' ? '<i class="ti-double-check"></i>' : '') + `</div>
                        </div>
                    </div>`);

                    setTimeout(function () {
                        chat_body.scrollTop(chat_body.get(0).scrollHeight, -1).niceScroll({
                            cursorcolor: 'rgba(66, 66, 66, 0.20)',
                            cursorwidth: "4px",
                            cursorborder: '0px'
                        }).resize();
                    }, 200);
                }
            }
        }
    };

    setTimeout(function () {
        // $('#disconnected').modal('show');
        // $('#call').modal('show');
        // $('#videoCall').modal('show');
    }, 1000);

    $(document).on('submit', '.layout .content .chat .chat-footer form', function (e) {
        e.preventDefault();

        var input = $(this).find('input[type=text]');
        var message = input.val();

        message = $.trim(message);

        if (message) {
            RobaExamle.Message.add(message, 'outgoing-message');
            input.val('');

            setTimeout(function () {
                RobaExamle.Message.add();
            }, 1000);
        } else {
            input.focus();
        }
    });
});
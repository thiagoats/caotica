$('#delete').on('show.bs.modal', function (event) {
	var button = $(event.relatedTarget);
	var asking = button.data('whateverasking');
	var item = button.data('whateveritem');
	var action = button.data('whateveraction');
	var modal = $(this);
	modal.find('.asking').text(asking);
	modal.find('.item').text(item);
	modal.find('#confirm').attr("href", action);
});

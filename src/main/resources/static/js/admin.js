/**
 *
 */
$(function() {
	if($('.required').val().length == 0) {
		$('#regist').attr('disabled','disabled');
	}
	$('.required').bind('keydown keyup keypress change', function() {
		if($(this).val().length > 0) {
			$('#regist').removeAttr('disabled');
		}else {
			$('#regist').attr('disabled', 'disabled');
		}
	});
});
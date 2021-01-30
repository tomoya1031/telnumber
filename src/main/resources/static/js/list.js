// 電話帳サンプルスクリプト
$(function() {

	// 編集ボタンクリックイベント
	$(document).on('click','.btn-edit',function (e) {
		var user = {};
		$.each($(e.target).closest('tr').children(), function (i, e) {
			switch (i) {
				case 0:
					user.id = $(e).children().val();
				case 1:
					user.userName = $(e).text();
					break;
				case 2:
					user.telNo = $(e).text();
					break;
				case 3:
					user.mailAddr = $(e).text();
					break;
				default:
					break;
			}
		});
		$('#form').find('[name="userName"]').val(user.userName).prop('disabled', false);
		$('#form').find('[name="telNo"]').val(user.telNo).prop('disabled', false);
		$('#form').find('[name="mailAddr"]').val(user.mailAddr).prop('disabled', false);
		$('#form').find('[name="id"]').val(user.id);
	});

	// 削除ボタンクリックイベント
	$(document).on('click','.btn-delete',function (e) {
		$.each($('#table tbody').find('tr'), function (i, e) {
			if ($(e).find('[name="selectRecord"]').prop('checked')) {
				$(e).remove();
			}
		});
	});

	// 保存ボタンクリックイベント
	$(document).on('click','.btn-save',function (e) {
		var user = $('#form').serializeArray();
		$.each($('#form').serializeArray(), function (i, s) {
			user[s.name] = s.value;
		});
		$.each($('#table tbody').find('tr'), function (i, e) {
			if ($(e).find('[name="selectRecord"]').val() == user.id) {
				$(e).children().eq(1).text(user.userName);
				$(e).children().eq(2).text(user.telNo);
				$(e).children().eq(3).text(user.mailAddr);
			}
		});
	});

});
function check(){

	var flag = 0;


	// 設定開始（必須にする項目を設定してください）

	if(document.form.mail.value == ""){ // 「メールアドレス」の入力をチェック

		flag = 1;

	}
	else if(document.form.firstName.value == ""){ // 「姓」の入力をチェック

		flag = 1;

	}
	else if(document.form.lastName.value == ""){ // 「名」の入力をチェック

		flag = 1;

	}
	else if(document.form.password.value == ""){ // 「新パスワード」の入力をチェック

		flag = 1;

	}

	else if(document.form.confirm.value == ""){ // 「新パスワード(確認)」の入力をチェック

		flag = 1;

	}

	// 設定終了


	if(flag){

		window.alert('必須項目に未入力がありました'); // 入力漏れがあれば警告ダイアログを表示
		return false; // 送信を中止

	}
	else{

		return true; // 送信を実行

	}

}

function CheckPassword(confirm){
	// 入力値取得
	var input1 = password.value;
	var input2 = confirm.value;
	// パスワード比較
	if(input1 != input2){
		confirm.setCustomValidity("入力値が一致しません。");
	}else{
		confirm.setCustomValidity('');
	}
}

function check2(){

	var flag = 0;


	// 設定開始（必須にする項目を設定してください）

	if(document.form.password.value == ""){ // 「メールアドレス」の入力をチェック

		flag = 1;

	}
	else if(document.form.newPassword.value == ""){ // 「姓」の入力をチェック

		flag = 1;

	}
	else if(document.form.confirm.value == ""){ // 「名」の入力をチェック

		flag = 1;

	}

	// 設定終了


	if(flag){

		window.alert('必須項目に未入力がありました'); // 入力漏れがあれば警告ダイアログを表示
		return false; // 送信を中止

	}
	else{

		return true; // 送信を実行

	}

}

function CheckPassword2(confirm){
	// 入力値取得
	var input1 = newPassword.value;
	var input2 = confirm.value;
	// パスワード比較
	if(input1 != input2){
		confirm.setCustomValidity("入力値が一致しません。");
	}else{
		confirm.setCustomValidity('');
	}
}
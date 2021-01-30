package jp.co.ridi.teldir.form;

import lombok.Data;

/**
 * 電話帳用フォーム
 */
@Data
public class TelDataForm {

	// ID
	private Long id;

	// ユーザー名
	private String userName;

	// 電話番号
	private String telNo;

	// メールアドレス
	private String mailAddr;
	
	// 一覧画面での行選択チェックボックスの値（削除用ID配列）
	private Long[] selectRecords;

}
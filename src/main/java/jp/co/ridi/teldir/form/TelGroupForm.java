package jp.co.ridi.teldir.form;

import lombok.Data;

/**
 * グループ用フォーム
 */
@Data
public class TelGroupForm {

	// グループID
	private Long groupId;

	// グループ名
	private String groupName;

	// 一覧画面での行選択チェックボックスの値（削除用ID配列）
	private Long[] selectGroupRecords;

}

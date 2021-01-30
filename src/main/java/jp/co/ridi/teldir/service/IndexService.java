package jp.co.ridi.teldir.service;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ridi.teldir.entity.TelData;
import jp.co.ridi.teldir.entity.TelGroup;
import jp.co.ridi.teldir.repository.TelDataRepository;
import jp.co.ridi.teldir.repository.TelGroupRepository;

/**
 * 一覧画面のサービスクラス
 */
@Service
public class IndexService {
	
	/** 電話帳リポジトリークラスのフィールド変数 */
	@Autowired
	private TelDataRepository telDataRepository;
	@Autowired
	private TelGroupRepository telGroupRepository;
	
	/**
	 * 電話帳データリスト検索処理メソッド
	 * 
	 * @return 電話帳データリスト
	 */
	public List<TelData> findTelDataList() {
//		List<TelData> list = new ArrayList<>();
//		TelData d1 = new TelData();
//		d1.setId(1);
//		d1.setUserName("あいうえお");
//		d1.setTelNo("090-1111-1111");
//		d1.setMailAddr("aaaaa@ridi.co.jp");
//		list.add(d1);
//		return list;
		return telDataRepository.findAll();
	}
	
	public List<TelGroup> findTelGroupList() {
		return telGroupRepository.findAll();
	}
	
	/**
	 * 電話帳データ削除処理メソッド
	 * 
	 * @param idArray 電話帳ID（可変長引数）
	 */
	public void deleteTelDataList(Long... idArray) {
		// 下記は条件分岐（if文）のサンプルであり、どれも結果は同じ
		// 引数（パラメータ）.電話帳IDが空（存在しない）かをチェック
		// ifのサンプル1
		// 条件分岐を分けて2段階で実施
//		if (idArray == null) {
//			return;
//		}
//		if (idArray.length == 0) {
//			return;
//		}
		// ifのサンプル2
		// 複合条件のサンプル（A or B）
//		if (idArray == null || idArray.length == 0) {
//			return;
//		}
		// ifのサンプル3
		// ライブラリーを利用したサンプル
		if (ArrayUtils.isEmpty(idArray)) {
			// 空の場合、処理終了（削除対象のIDが存在しないため）
			return;
		}

		// 下記は繰り返し（ループ）処理のサンプルであり、どれも結果は同じ
		// 繰り返し処理のサンプル1
		// インデックス付きループ
		// 配列（コレクション）の長さ（length）を取得し、0からその長さ未満（<）までループする、カウンターはインクリメント（i++、1回転につき変数iに1加算）
//		for (int i = 0; i < idArray.length; i++) {
		    // ここが繰り返し実施される
		    // カウンター（i）を使って、配列から要素（id）を取り出し、電話帳リポジトリー.削除用メソッド（引数が主キー、今回の場合、id）を呼び出す
//			telDataRepository.deleteById(idArray[i]);
//		}
		// 繰り返し処理のサンプル2
		// 拡張for文
		// 配列（コレクション）の要素数分ループする
		// 各要素がループするため、配列からカウンターを使ってidを取得する必要はない
//		for (long id : idArray) {
//			telDataRepository.deleteById(id);
//		}
		// 繰り返し処理のサンプル3
		// forEach（stream api）
		// ラムダ式（->）を使う一番新しい方法
		// 拡張forを1行書きするような書き方ができる
		Arrays.stream(idArray).forEach(id -> telDataRepository.deleteById(id));
	}
	
	public void deleteTelGroupList(Long... groupIdArray) {
		if (ArrayUtils.isEmpty(groupIdArray)) {
			// 空の場合、処理終了（削除対象のIDが存在しないため）
			return;
		}
		Arrays.stream(groupIdArray).forEach(groupId -> telGroupRepository.deleteById(groupId));
	}

}

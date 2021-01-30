package jp.co.ridi.teldir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ridi.teldir.form.TelDataForm;
import jp.co.ridi.teldir.form.TelGroupForm;
import jp.co.ridi.teldir.service.IndexService;

/**
 * 一覧画面（Topページ）のコントローラークラス
 */
@Controller
@RequestMapping("/")
public class IndexController {

	/** 一覧画面のサービスクラスのフィールド変数 */
	@Autowired
	private IndexService service;
	
	/**
	 * 一覧画面表示メソッド
	 * 
	 * @param model Model
	 * @return 一覧画面
	 */
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
    	// 一覧画面用サービス.電話帳データリスト検索処理メソッドを呼び出し、modelに「telDataList」という名前を持つ属性を追加し、
    	// 値に電話帳データリスト検索処理メソッドの戻り値を設定する。
    	// modelは、フレームワーク提供の画面とJava間でデータをやりとりするためのオブジェクト
    	model.addAttribute("telDataList", service.findTelDataList());
    	model.addAttribute("telGroupList", service.findTelGroupList());
    	// 一覧画面（index.html）を返却
        return "index";
    }

    /**
     * 削除処理メソッド
     * 
     * @param form 電話帳用フォーム
     * @param model Model
     * @return 一覧画面リダイレクト
     */
    @RequestMapping(path = "delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute TelDataForm form, Model model) {
    	// 一覧画面用サービス.電話帳データ削除処理メソッドを呼び出す（引数に電話帳用フォーム.削除用ID配列を設定）
    	service.deleteTelDataList(form.getSelectRecords());
    	// 一覧画面表示メソッドにリダイレクト
        return "redirect:/";
    }
    
    @RequestMapping(path = "deleteGroup", method = RequestMethod.POST)
    public String delete(@ModelAttribute TelGroupForm form, Model model) {
    	service.deleteTelGroupList(form.getSelectGroupRecords());
        return "redirect:/";
    }

}

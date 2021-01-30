package jp.co.ridi.teldir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ridi.teldir.dto.EditDto;
import jp.co.ridi.teldir.form.TelDataForm;
import jp.co.ridi.teldir.service.EditService;
import jp.co.ridi.teldir.util.BeanUtil;

@Controller
@RequestMapping("/edit")
public class EditController {

	@Autowired
	private EditService service;

    @RequestMapping(method = RequestMethod.GET)
    public String index(@ModelAttribute TelDataForm form, Model model) {
    	if (form.getId() == null) {
    		return "edit";
    	}
    	model.addAttribute("telDataForm", service.findTelData(form.getId()));
        return "edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute TelDataForm form, Model model) {
    	service.saveTelData(BeanUtil.createProperties(form, EditDto.class));
        return "redirect:/";
    }

}

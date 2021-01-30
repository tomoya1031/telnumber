package jp.co.ridi.teldir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ridi.teldir.dto.EditGroupDto;
import jp.co.ridi.teldir.form.TelGroupForm;
import jp.co.ridi.teldir.service.EditGroupService;
import jp.co.ridi.teldir.util.BeanUtil;

@Controller
@RequestMapping("/editGroup")
public class EditGroupController {

	@Autowired
	private EditGroupService service;

    @RequestMapping(method = RequestMethod.GET)
    public String index(@ModelAttribute TelGroupForm form, Model model) {
    	if (form.getGroupId() == null) {
    		return "editGroup";
    	}
    	model.addAttribute("telGroupForm", service.findTelData(form.getGroupId()));
        return "editGroup";
    }

    @RequestMapping(value = "/saveGroup", method = RequestMethod.POST)
    public String save(@ModelAttribute TelGroupForm form, Model model) {
    	service.saveTelGroup(BeanUtil.createProperties(form, EditGroupDto.class));
        return "redirect:/";
    }

}

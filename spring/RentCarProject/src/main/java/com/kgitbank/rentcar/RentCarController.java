package com.kgitbank.rentcar;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kgitbank.rentcar.dto.CarNameDTO;
import com.kgitbank.rentcar.model.CarNameMapper;

@Controller
public class RentCarController {
	
	@Autowired
	private CarNameMapper carNameMapper;
		
	@RequestMapping(value="/carName_input.do", method=RequestMethod.GET)
	public String carName_input() {
		return "carName/input_carName";
	}
	
	@RequestMapping(value="/carName_input.do", method=RequestMethod.POST)
	public String carName_input_ok(HttpServletRequest req, CarNameDTO dto) {
		int res = carNameMapper.insertCarName(dto);
		if (res>0) {
			req.setAttribute("msg", "��Ʈī ���� ��� ����!! ��Ʈī ����������� �̵��մϴ�.");
			req.setAttribute("url", "carName_list.do");
		}else {
			req.setAttribute("msg", "��Ʈī ���� ��� ����!! ��Ʈī ���� ����������� �̵��մϴ�.");
			req.setAttribute("url", "carName_input.do");
		}
		return "message";
	}
	
	@RequestMapping(value="/carName_list.do")
	public String carName_list(HttpServletRequest req) {
		List<CarNameDTO> list = carNameMapper.listCarName();
		req.setAttribute("listCarName", list);
		return "carName/list_carName";
	}
	
	@RequestMapping(value="/carName_delete.do")
	public String carName_delete(HttpServletRequest req, @RequestParam int num) {
		int res = carNameMapper.deleteCarName(num);
		if (res>0) {
			req.setAttribute("msg", "��Ʈī ���� ����!! ��Ʈī ����������� �̵��մϴ�.");
			req.setAttribute("url", "carName_list.do");
		}else {
			req.setAttribute("msg", "��Ʈī ���� ����!! ��Ʈī ��� �������� �̵��մϴ�.");
			req.setAttribute("url", "carName_list.do");
		}
		return "message";
	}
	
	@RequestMapping(value="/carName_view.do")
	public String carName_getCarName(HttpServletRequest req, @RequestParam int num) {
		CarNameDTO dto = carNameMapper.getCarName(num);
		req.setAttribute("getCarName", dto);
		return "carName/view_carName";
	}
	
	@RequestMapping(value="/carName_update.do")
	public String carName_update(HttpServletRequest req, @RequestParam Map<String, String> map) {
		int res = carNameMapper.updateCarName(map);
		if (res>0) {
			req.setAttribute("msg", "��Ʈī ���� ���� ����!! ��Ʈī ����������� �̵��մϴ�.");
			req.setAttribute("url", "carName_list.do");
		}else {
			req.setAttribute("msg", "��Ʈī ���� ���� ����!! ��Ʈī �󼼺��� �������� �̵��մϴ�.");
			req.setAttribute("url", "carName_input.do");
		}
		return "message";
	}
}

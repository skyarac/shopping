package com.shopping.web.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.entity.Forder;
import com.shopping.entity.Status;
import com.shopping.service.ForderService;
import com.shopping.service.impl.ForderServiceImpl;

@Controller
@RequestMapping("/forder")
public class ForderAction {
	
	private ForderService forderService = new ForderServiceImpl();
	
	@RequestMapping("/forder_list.do")
	public ModelAndView forderList(ModelAndView mv) {
		List<Forder> forders = forderService.listAll();
		mv.addObject("forders", forders);
		mv.setViewName("forder/forder_list");
		return mv;
	}
	
	@RequestMapping(value="/forder_modify.do",method=RequestMethod.GET)
	public ModelAndView forderModify(HttpServletRequest request,ModelAndView mv) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		Forder forder = forderService.getForderByFid(fid);
		mv.addObject("forder", forder);
		mv.setViewName("forder/forder_modify");
		return mv;
	}
	
	@RequestMapping(value="/forder_modify.do",method=RequestMethod.POST)
	public String modifyForder(HttpServletRequest request) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		forderService.updateForderStatus(fid, sid);
		
		return "redirect:forder_list.do";
	}
	
	@RequestMapping("/forder_delete.do")
	public String forderDelete() {
		
		
		return "redirect:forder_list.do";
	}
}

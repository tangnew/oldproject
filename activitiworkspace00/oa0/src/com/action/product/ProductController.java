package com.action.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.action.BaseController;
import com.model.Status;
import com.model.product.Product;
import com.service.product.ProductService;
import com.spring.util.Constant;
import com.spring.util.SpringUtil;

@Controller
@RequestMapping("/productController.do")
public class ProductController extends BaseController {

	@Resource(name = "productService")
	private ProductService productService;

	@RequestMapping(params = "list")
	public ModelAndView listSuccessful(ModelAndView mav) {
		mav.setViewName("jsp/product/list");
		String currentUser = SpringUtil.getCurrentUserName();
		List<Long> statusList = new ArrayList<Long>();
		statusList.add(Status.SUCCESSFUL.getId());
		List<Product> list = productService.listByUserAndStatus(currentUser,
				statusList);
		mav.addObject("products", list);
		return mav;
	}

	@RequestMapping(params = "add")
	public String add() {
		return "jsp/product/add";
	}

	@RequestMapping(params = "update")
	public String update() {
		return "jsp/product/update";
	}

	@RequestMapping(params = "save")
	public String save(ModelAndView mav, Product product) {
		Date now = new Date();
		product.setCreatedTime(now);
		product.setUpdatedTime(now);
		product.setUserName(SpringUtil.getCurrentUserName());
		product.setStatus(Status.NOT_START.getId());
		productService.save(product);
		return "redirect:/productController.do?notStartList";
	}

	@RequestMapping(params = "notStartList")
	public ModelAndView notStartList(ModelAndView mav) {
		mav.setViewName("jsp/product/process/notstartlist");
		String currentUser = SpringUtil.getCurrentUserName();
		List<Long> statusList = new ArrayList<Long>();
		statusList.add(Status.NOT_START.getId());
		List<Product> list = productService.listByUserAndStatus(currentUser,
				statusList);
		mav.addObject("products", list);
		return mav;
	}

	@RequestMapping(params = "startProcess", method = { RequestMethod.GET })
	public String startProcess(ModelAndView mav, long productId) {
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put(Constant.T_USER, SpringUtil.getCurrentUserName());
		vars.put(Constant.AMOUNT, 1000000L);
		Product product = productService.getProductByProductId(productId);
		vars.put(Constant.MODEL, product);

		productService.submitApplyProcess(Constant.PRODUCT_PROCESS, product,
				vars);

		return "redirect:/productController.do?notStartList";
	}

	@RequestMapping(params = "agentsList")
	public ModelAndView agentsList(ModelAndView mav) {
		mav.setViewName("jsp/product/process/agentslist");
		List<Task> list = productService.listAgentsAllTaskByUser();
		mav.addObject("tasks", list);
		return mav;
	}

	@RequestMapping(params = "auditingList")
	public ModelAndView auditingList(ModelAndView mav) {
		mav.setViewName("jsp/product/process/auditinglist");
		List<Product> products = productService.listAssigneeAllTaskByUser();
		mav.addObject("products", products);
		return mav;
	}

	@RequestMapping(params = "dealingList")
	public ModelAndView dealingList(ModelAndView mav) {
		mav.setViewName("jsp/product/process/dealinglist");
		String currentUser = SpringUtil.getCurrentUserName();
		List<Long> statusList = new ArrayList<Long>();
		statusList.add(Status.START.getId());
		statusList.add(Status.AUDIT_ING.getId());
		List<Product> products = productService.listByUserAndStatus(
				currentUser, statusList);
		mav.addObject("products", products);
		return mav;
	}

	@RequestMapping(params = "auditedList")
	public ModelAndView auditedList(ModelAndView mav) {
		mav.setViewName("jsp/product/process/auditedlist");
		String currentUser = SpringUtil.getCurrentUserName();
		List<Long> statusList = new ArrayList<Long>();
		statusList.add(Status.SUCCESSFUL.getId());
		statusList.add(Status.FAIL.getId());
		List<Product> products = productService.listByUserAndStatus(
				currentUser, statusList);
		
		//products=productService.getAuditedTask();
		mav.addObject("products", products);
		return mav;
	}

	@RequestMapping(params = "claimTask")
	public ModelAndView startClaimTask(ModelAndView mav, String taskId) {
		boolean isClaim = productService.isClaimed(taskId);
		if (!isClaim) {
			mav.setViewName("jsp/product/detail");
			productService.claimTaskByUser(taskId);
		}

		mav.setViewName("redirect:/productController.do?agentsList");
		return mav;
	}

	@RequestMapping(params = "aduitTaskDetail")
	public ModelAndView aduitTaskDetail(ModelAndView mav, String taskId) {
		mav.setViewName("jsp/product/detail");
		List<String> transitions = productService.getTransitions(taskId);
		mav.addObject("product", productService.getModelOfTask(taskId));
		mav.addObject("taskId", taskId);
		mav.addObject("transitions", transitions);
		return mav;
	}

	@RequestMapping(params = "dealWithTask")
	public ModelAndView startDealWithTask(ModelAndView mav, String taskId,
			String transition) {
		productService.dealWithTask(taskId, transition);
		mav.setViewName("redirect:/productController.do?auditingList");
		return mav;
	}

}

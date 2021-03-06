package com.ithc.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ithc.bean.Linkman;
import com.ithc.service.LinkmanService;
import com.ithc.util.FastJsonUtil;
import com.ithc.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman> {
	private Linkman linkman = new Linkman();

	@Override
	public Linkman getModel() {

		return linkman;
	}

	private LinkmanService linkmanService;

	public void setLinkmanService(LinkmanService linkmanService) {
		this.linkmanService = linkmanService;
	}

	// 跳转新增联系人
	public String initAddUI() {

		return "initAddUI";
	}

	// 添加联系人
	public String save() {

		linkmanService.save(linkman);

		return initAddUI();
	}

	// 分页查询
	// 利用属性驱动获取当前页
	private Integer pageCode = 1;

	public void setPageCode(Integer pageCode) {

		if (pageCode == null) {
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}

	// 每页显示的数量
	private Integer pageSize = 2;

	public void setPageSize(Integer pageSize) {

		if (pageSize == null) {
			pageSize = 2;
		}
		this.pageSize = pageSize;
	}

	// 分页查询
	public String findByPage() {
		// 用离线条件查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
		if (pageCode == null) {
			pageCode = 1;
		}
		if (pageSize == null) {
			pageSize = 2;
		}

		// 拼接筛选条件
		try {
			if (linkman != null) {

				String lkm_name = linkman.getLkm_name();
				if (!lkm_name.equals("") && lkm_name != null) {
					// select * from linkman where lkm_name like "%"+lkm_nmae+"%"
					criteria.add(Restrictions.like("lkm_name", "%" + lkm_name + "%"));
				}
			}

		} catch (Exception e) {
		}

		// 拼接所属客户
		try {
			Long id = linkman.getCustomer().getCust_id();
			System.out.println(id + "...");
			if (id != null) {
				criteria.add(Restrictions.eq("customer.cust_id", id));
			}

		} catch (Exception e) {
		}

		PageBean<Linkman> page = linkmanService.findByPage(pageCode, pageSize, criteria);

		ValueStack vs = ActionContext.getContext().getValueStack();

		vs.set("page", page);

		return "findByPage";
	}

	// 删除
	public String delete() {
		// 先查询
		Linkman linkman = linkmanService.findById(this.linkman.getLkm_id());

		if (linkman != null) {
			linkmanService.delete(linkman);
			return findByPage();
		}
		return "login";

	}

	// 修改跳转
	public String initUpdate() {

		//linkman = linkmanService.findById(this.linkman.getLkm_id());

		Long id=linkman.getLkm_id();
		if(id !=null){
			 linkman=linkmanService.findById(id);
			if(linkman !=null){
				return "initUpdate";			
			}
		}
		return "login";
	}

	// 修改
	public String update() throws Exception {

	//	System.out.println(linkman);
		linkmanService.update(linkman);
		return "update";

	}

}

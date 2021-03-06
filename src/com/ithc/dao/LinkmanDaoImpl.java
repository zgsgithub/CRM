package com.ithc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ithc.bean.Linkman;
import com.ithc.util.PageBean;
import com.ithc.util.UtilDaoImpl;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.TypeHost;

@SuppressWarnings("all")
public class LinkmanDaoImpl extends UtilDaoImpl<Linkman> implements LinkmanDao {

	/*//保存
	public void save(Linkman linkman) {
		this.getHibernateTemplate().save(linkman);
	}

	//分页查询
	@Override
	public PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		PageBean<Linkman> pageBean = new PageBean<Linkman>();
		//设置当前页
	    pageBean.setPageCode(pageCode);
	  //设置每页显示的数量去求总页数
	  		pageBean.setPageSize(pageSize);
	  		// select count(*)
	  		List<Number> value = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria.setProjection(Projections.rowCount()));
	  		if(value != null ){
	  			//设置总记录数
	  			pageBean.setTotalCount(value.get(0).intValue());
	  		}
	  	    //设置null
			criteria.setProjection(null);
			//设置beanList集合
			List<Linkman> list = (List<Linkman>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode-1) * pageSize, pageSize);
			
			pageBean.setBeanList(list);
			
			return pageBean;
	}

	//删除
	@Override
	public void delete(Linkman linkman) {
		this.getHibernateTemplate().delete(linkman);
	}

	//id查询
	@Override
	public Linkman findById(Long lkm_id) {
		
		List<Linkman> list = (List<Linkman>) this.getHibernateTemplate().find("from Linkman where lkm_id=?", lkm_id);
		if(list != null && list.size() >0){
			return list.get(0);
		}		
		return null;
	}

	//查询所有
	@Override
	public List<Linkman> findByAll() {	
		List<Linkman> linkman = (List<Linkman>) this.getHibernateTemplate().find("from Linkman");
		if(linkman !=null && linkman.size() >0){
			return linkman;
		}
		return null;
	}

	//修改
	@Override
	public void update(Linkman linkman) {
		this.getHibernateTemplate().update(linkman);
	}*/

	
	
	
	
	
	
	
}

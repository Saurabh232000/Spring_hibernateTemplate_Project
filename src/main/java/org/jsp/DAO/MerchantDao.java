package org.jsp.DAO;

import javax.transaction.Transactional;
import java.util.List;

import javax.transaction.Transactional;

import org.jsp.DTO.Merchant;
import org.springframework.orm.hibernate5.HibernateTemplate;
import javax.transaction.Transactional;

public class MerchantDao {
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public int SaveMerchant(Merchant merchant) {

		int save = (int) this.template.save(merchant);
		return save;

	}

	@Transactional
	public void UpdateMerchant(Merchant merchant) {
		this.template.saveOrUpdate(merchant);
	}

	@Transactional
	public String DeleteMerchantById(int id) {
		Merchant find = this.template.get(Merchant.class, id);
		if (find != null) {
			this.template.delete(find);
			return " One Record Deleted Successfully";
		} else {
			return "No Record Found";
		}
	}

	public Merchant findById(int id) {
		Merchant merchant = this.template.get(Merchant.class, id);
		return merchant;
	}

	public List<Merchant> findAll() {
		List<Merchant> loadAll = this.template.loadAll(Merchant.class);
		return loadAll;
	}
//	@Transactional
//	public Merchant SaveMerchant(Merchant merchant) {
//		template.save(merchant);
//		return merchant;
//	}
//
//	@Transactional
//	
//	public Merchant UpdateMerchant(Merchant merchant) {
//		template.update(merchant);
//		return merchant;
//	}
//
//	@Transactional
//	public boolean DeleteMerchant(int id) {
//		Merchant merchant = findById(id);
//		if (merchant != null) {
//			template.delete(merchant);
//			return true;
//		}
//		return false;
//	}
//
//	public Merchant findById(int id) {
//		return template.get(Merchant.class, id);
//	}
//
//	public List<Merchant> findAll() {
//		return template.loadAll(Merchant.class);
//	}
}
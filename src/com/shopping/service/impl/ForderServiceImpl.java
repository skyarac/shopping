package com.shopping.service.impl;

import java.util.List;

import com.shopping.dao.ForderDao;
import com.shopping.dao.impl.ForderDaoImpl;
import com.shopping.entity.Forder;
import com.shopping.entity.Sorder;
import com.shopping.service.ForderService;

public class ForderServiceImpl implements ForderService {
	
	private ForderDao forderDao = new ForderDaoImpl();

	@Override
	public Forder save(Forder forder) {
		return forderDao.save(forder);
	}

	@Override
	public void updateForderStatus(int fid, int sid) {
		forderDao.updateForderStatus(fid, sid);

	}

	@Override
	public List<Forder> listAll() {
		return forderDao.listAll();
	}

	@Override
	public List<Forder> listByStatusId(int statusId) {
		return forderDao.listByStatusId(statusId);
	}

	public Forder addSorder(Forder forder, Sorder sorder) {
		List<Sorder> sorders = forder.getSorders();
		int i = 0;
		for (; i < sorders.size(); i++) {
			if (sorders.get(i).getGoods().getGid() == sorder.getGoods()
					.getGid()) {
				break;
			}
		}
		if (i < sorders.size())
			sorders.get(i).setSnumber(sorders.get(i).getSnumber() + 1);
		else
			sorders.add(sorder);
		forder.setSorders(sorders);
		forder.setFtotal(this.countTotal(forder));
		return forder;
	}

	public Forder updateSorder(Forder forder, int gid, int snumber) {
		for (Sorder temp : forder.getSorders()) {
			if (temp.getGoods().getGid() == gid) {
				temp.setSnumber(snumber);
			}
		}
		forder.setFtotal(this.countTotal(forder));
		return forder;
	}

	public double countTotal(Forder forder) {
		double total = 0.0;
		for (Sorder sorder : forder.getSorders()) {
			total += sorder.getSnumber() * sorder.getSprice();
		}
		return total;
	}

	public Forder deleteSorder(Forder forder, int gid) {
		List<Sorder> sorders = forder.getSorders();
		for (int i = 0; i < sorders.size(); i++) {
			if (sorders.get(i).getGoods().getGid() == gid) {
				sorders.remove(i);
				break;
			}
		}
		forder.setSorders(sorders);
		forder.setFtotal(this.countTotal(forder));
		return forder;
	}

	@Override
	public Forder getForderByFid(int fid) {
		
		return forderDao.getForderByFid(fid);
	}

}

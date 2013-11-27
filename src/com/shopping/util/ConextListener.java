package com.shopping.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.shopping.dao.CategoryDao;
import com.shopping.dao.impl.CategoryDaoImpl;

// tomcate app 
public class ConextListener implements ServletContextListener {

	private CategoryDao categoryDaoImpl = new CategoryDaoImpl();

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		event.getServletContext().setAttribute("categorys",
				categoryDaoImpl.getCategorys(""));
		ShoppingTimerTask shoppingTimer = new ShoppingTimerTask();
		shoppingTimer.setApplication(event.getServletContext());
		new Timer().schedule(shoppingTimer, 0L, 1000 * 60*60*24);
		// 把银行图标存储到application中
		File file = new File(event.getServletContext().getRealPath("/")
				+ "image/bank");
		String[] fileNames = null;
		if (file.isDirectory()) {
			fileNames = file.list(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					String ext = name.substring(name.indexOf(".") + 1);
					if (ext.equals("gif") || ext.equals("jpg"))
						return true;
					else
						return false;
				}
			});
			event.getServletContext().setAttribute("fileNames", fileNames);
		}

	}
}

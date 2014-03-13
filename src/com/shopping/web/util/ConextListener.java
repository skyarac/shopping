package com.shopping.web.util;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.shopping.service.CategoryService;
import com.shopping.service.impl.CategoryServiceImpl;

public class ConextListener implements ServletContextListener {

	private CategoryService categoryService = new CategoryServiceImpl();

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent event) {
		event.getServletContext().setAttribute("categorys",
				categoryService.listByCtype(""));
		ShoppingTimerTask shoppingTimer = new ShoppingTimerTask();
		shoppingTimer.setApplication(event.getServletContext());
		new Timer().schedule(shoppingTimer, 0L, 1000 * 60 * 60 * 24);
		 
		/*File file = new File(event.getServletContext().getRealPath("/")
				+ "image/bank");

		String[] fileNames = null;
		if (file.isDirectory()) {
			fileNames = file.list(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					String ext = name.substring(name.indexOf(".") + 1);
					if (ext.equals("gif") || ext.equals("jpg"))
						return true;
					else
						return false;
				}
			});
			event.getServletContext().setAttribute("fileNames", fileNames);
		}*/

	}
}

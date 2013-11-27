package com.shopping.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.shopping.dao.impl.CategoryDaoImpl;
import com.shopping.dao.impl.GoodsDaoImpl;
import com.shopping.entity.Category;
import com.shopping.entity.Goods;

public class GoodsDaoTest {

	@Test
	public void testSave() {
		Goods goods=new Goods();
		Category category=new Category();
		category.setCid(4);
		goods.setCategory(category);
	//	goods.setGdate(gdate);
		//goods.setGid(gid);
		goods.setGiscommend(true);
		goods.setGisopen(true);
		goods.setGname("java程序设计");
		goods.setGpic("pic_java_01.jpg");
		goods.setGprice(12.5f);
		goods.setGremark("java入门经典作品");
		goods.setGxremark("如果配合Thinking in java就会更好");
		GoodsDao goodsDao=new GoodsDaoImpl();
		goodsDao.save(goods);
		
	}
	@Test
	public void testDelete(){
		GoodsDao goodsDao=new GoodsDaoImpl();
		goodsDao.deleteByGid(29);
	}
    @Test
    public void testGoodsModify(){
    	Goods goods=new Goods();
    	Category category=new Category();
    	category.setCid(7);
    	goods.setCategory(category);
    	goods.setGid(27);
    	goods.setGiscommend(false);
    	goods.setGisopen(false);
    	goods.setGname("大宝SOD蜜");
    	goods.setGpic("dabao_1.jpg");
    	goods.setGprice(12.8f);
    	goods.setGremark("保洁公司");
    	goods.setGxremark("大宝，天天见!");
    	
    	GoodsDao goodsDao=new GoodsDaoImpl();
    	goodsDao.goodsModify(goods);
    }
    @Test
    public void testQueryGiscommendGoods(){
    	List<Goods> goods=new ArrayList<Goods>();
    	List<Category> categorys=new ArrayList<Category>();
    	CategoryDao categoryDao=new CategoryDaoImpl();
    	categorys=categoryDao.getCategorys(true);
    	Goods temp=null;
    	GoodsDao goodsDao=new GoodsDaoImpl();
    	Category category=null;
    	for(int i=0;i<categorys.size();i++){
    		category=categorys.get(i);
    		System.out.println(category.getCtype()+" :");
    		goods=goodsDao.queryGiscommendGoods(category.getCid());
        	Iterator it=goods.iterator();
        	while(it.hasNext()){
        		temp=(Goods)it.next();
        		System.out.println(temp.getGname());
        	}
        	System.out.println("------------");
    	}
    }
    @Test
    public void testQueryGoodsByCid(){
    	List<Goods> goods=new ArrayList<Goods>();
    	Goods temp=null;
    	GoodsDao goodsDao=new GoodsDaoImpl();
    	goods=goodsDao.queryGoodsByCid(1);
    	Iterator it=goods.iterator();
    	while(it.hasNext()){
    		temp=(Goods)it.next();
    		System.out.println(temp.getGid());
    		System.out.println(temp.getGname());
    		System.out.println(temp.getGpic());
    		System.out.println(temp.getGprice());
    		System.out.println(temp.getGremark());
    		System.out.println(temp.getGxremark());
    		System.out.println(temp.getGdate());
    		System.out.println(temp.getCategory().getCid());
    		System.out.println("-----------");
    	}
    }
    @Test
    public void testGetCtypeByCid(){
//    	Category category=new Category();
//    	Goods goods=new Goods();
    }
}

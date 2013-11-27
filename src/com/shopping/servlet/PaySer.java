package com.shopping.servlet;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.dao.ForderDao;
import com.shopping.dao.impl.ForderDaoImpl;
import com.shopping.util.DigestUtil;

public class PaySer extends HttpServlet {

	
	private ForderDao forderImpl=new ForderDaoImpl();
	/**
	 * Constructor of the object.
	 */
	public PaySer() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status = request.getParameter("status");
		if (status.equals("pay")) {
			// 加密的密�?由支付中介提�?
			String keyValue = "w0P75wMZ203fr46r5i70V556WHFa94j14yW5J6vuh4yo3nRl5jsqF3c41677";
			
			String p0_Cmd = formatString("Buy");
			String p1_MerId = formatString("10000940764");
			String p2_Order = formatString(request.getParameter("p2_Order"));
			String p3_Amt = formatString(request.getParameter("p3_Amt"));
			String p4_Cur = formatString("CNY");
			String p5_Pid = "";
			String p6_Pcat = "";
			String p7_Pdesc = "";
			String p8_Url = "http://za00037.u01.netjsp.com/t31/PaySer?status=success";
			String p9_SAF = "0";
			String pa_MP = "";
			String pd_FrpId = formatString(request.getParameter("pd_FrpId"));
			pd_FrpId = pd_FrpId.toUpperCase();
			String pr_NeedResponse = "0";
			String hmac = formatString("");
			// 把明文追加到�?��字符串中,然后加密
			StringBuffer infoBuffer = new StringBuffer();
			infoBuffer.append(p0_Cmd);
			infoBuffer.append(p1_MerId);
			infoBuffer.append(p2_Order);
			infoBuffer.append(p3_Amt);
			infoBuffer.append(p4_Cur);
			infoBuffer.append(p5_Pid);
			infoBuffer.append(p6_Pcat);
			infoBuffer.append(p7_Pdesc);
			infoBuffer.append(p8_Url);
			infoBuffer.append(p9_SAF);
			infoBuffer.append(pa_MP);
			infoBuffer.append(pd_FrpId);
			infoBuffer.append(pr_NeedResponse);
			// 加密后的密文存储到了hmac�?
			hmac = DigestUtil.hmacSign(infoBuffer.toString(), keyValue);
			// 把明文和密文都存储到request.setAttribute�?
			request.setAttribute("p0_Cmd", p0_Cmd);
			request.setAttribute("p1_MerId", p1_MerId);
			request.setAttribute("p2_Order", p2_Order);
			request.setAttribute("p3_Amt", p3_Amt);
			request.setAttribute("p4_Cur", p4_Cur);
			request.setAttribute("p5_Pid", p5_Pid);
			request.setAttribute("p6_Pcat", p6_Pcat);
			request.setAttribute("p7_Pdesc", p7_Pdesc);
			request.setAttribute("p8_Url", p8_Url);
			request.setAttribute("p9_SAF", p9_SAF);
			request.setAttribute("pa_MP", pa_MP);
			request.setAttribute("pd_FrpId", pd_FrpId);
			request.setAttribute("pr_NeedResponse", pr_NeedResponse);
			request.setAttribute("hmac", hmac);
			request.getRequestDispatcher("/users/reqpay.jsp").forward(request,
					response);
		} else if (status.equals("success")) {
			PrintWriter out = response.getWriter();
			String keyValue = "w0P75wMZ203fr46r5i70V556WHFa94j14yW5J6vuh4yo3nRl5jsqF3c41677";
			String r0_Cmd = formatString(request.getParameter("r0_Cmd")); 
			String p1_MerId = "10000940764"; 
			String r1_Code = formatString(request.getParameter("r1_Code"));
			String r2_TrxId = formatString(request.getParameter("r2_TrxId"));
			String r3_Amt = formatString(request.getParameter("r3_Amt"));
			String r4_Cur = formatString(request.getParameter("r4_Cur"));
			String r5_Pid = new String(formatString(
					request.getParameter("r5_Pid")).getBytes("iso-8859-1"),
					"UTF-8");
			String r6_Order = formatString(request.getParameter("r6_Order"));
			String r7_Uid = formatString(request.getParameter("r7_Uid"));
			String r8_MP = new String(formatString(
					request.getParameter("r8_MP")).getBytes("iso-8859-1"),
					"UTF-8");
			String r9_BType = formatString(request.getParameter("r9_BType"));
			String hmac = formatString(request.getParameter("hmac"));
			StringBuffer infoBuffer = new StringBuffer();
			infoBuffer.append(p1_MerId);
			infoBuffer.append(r0_Cmd);
			infoBuffer.append(r1_Code);
			infoBuffer.append(r2_TrxId);
			infoBuffer.append(r3_Amt);
			infoBuffer.append(r4_Cur);
			infoBuffer.append(r5_Pid);
			infoBuffer.append(r6_Order);
			infoBuffer.append(r7_Uid);
			infoBuffer.append(r8_MP);
			infoBuffer.append(r9_BType);
			String md5 = DigestUtil.hmacSign(infoBuffer.toString(), keyValue);
			if (md5.equals(hmac) && r1_Code.equals("1")) {
				//�?支付成功的订单状态改成已支付,并个给用户显示支付成功信�?
				out.print("易宝支付的流水号:" + r2_TrxId + "已支付的订单�?" + r6_Order + "已支付的金额" + r3_Amt);
				forderImpl.updateForderStatus(Integer.parseInt(r6_Order), 2);
			} else {
				out.println("fail !!!!");
			}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	private String formatString(String text) {
		if (text == null) {
			return "";
		}
		return text;
	}
}

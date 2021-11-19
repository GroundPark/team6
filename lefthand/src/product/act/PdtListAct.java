package product.act;

import javax.servlet.http.*;
import product.vo.*;
import java.util.*;
import product.svc.*;
import java.io.*;
import java.net.*;

public class PdtListAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ArrayList<ProductInfo> pdtList = new ArrayList<ProductInfo>();
			
		int cpage = 1, psize = 12, bsize = 10, spage, epage, rcnt, pcnt;		
		if(request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));
		if(request.getParameter("psize") != null)
			psize = Integer.parseInt(request.getParameter("psize"));
		
		
		// 액션
		String keyword, cata, sprice, eprice;
		keyword = request.getParameter("keyword");		
		cata = request.getParameter("cata");			
		sprice = request.getParameter("sprice");	
		eprice = request.getParameter("eprice");		
		
		String where = " where a.pc_id = b.pc_id and a.pi_isview = 'y' ";
		if(!isEmpty(keyword))	where += " and a.pi_name like '%" + keyword + "%' ";
		else keyword = "";
		
		if(!isEmpty(cata))		where += " and b.pc_id = '" + cata + "' ";
		else cata = "";
		
		if(!isEmpty(sprice))	where += " and a.pi_price >= '" + sprice + "' ";
		else sprice = "";
		
		if(!isEmpty(eprice))	where += " and a.pi_price <= '" + eprice + "' ";
		else eprice = "";
		
		
		String sort = request.getParameter("sort");
		if(sort == null || sort.equals(""))		sort = "idd";		
		
		String order = " order by pi_" + sort.substring(0, sort.length() - 1) 
			+ (sort.charAt(sort.length() - 1) == 'a' ? " asc" : " desc");
		
		PdtListSvc pdtListSvc = new PdtListSvc();
		rcnt = pdtListSvc.getPdtCount(where);		
		
		pdtList = pdtListSvc.getPdtList(where, order, cpage, psize);
		
		pcnt = rcnt / psize;
		if(rcnt % psize > 0)	pcnt++;				
		spage = (cpage - 1) / bsize * bsize + 1;	
		epage = spage + bsize - 1;
		if(epage > pcnt)	epage = pcnt;			
		
		PdtPageInfo pdtPageInfo = new PdtPageInfo();
		pdtPageInfo.setCpage(cpage);    pdtPageInfo.setPsize(psize);        pdtPageInfo.setBsize(bsize);
        pdtPageInfo.setSpage(spage);    pdtPageInfo.setEpage(epage);        pdtPageInfo.setRcnt(rcnt);
        pdtPageInfo.setPcnt(pcnt);      pdtPageInfo.setKeyword(keyword);    pdtPageInfo.setCata(cata);
        pdtPageInfo.setSprice(sprice);  pdtPageInfo.setEprice(eprice);    	pdtPageInfo.setSort(sort);
		
        ArrayList<PdtCata> cataList = pdtListSvc.getCataList();
        
        request.setAttribute("pdtPageInfo", pdtPageInfo);
        request.setAttribute("pdtList", pdtList);
        request.setAttribute("cataList", cataList);
        
        ActionForward forward = new ActionForward();
		forward.setPath("/page/product/pdt_list.jsp");
		
		return forward;
	}
	
	private boolean isEmpty(String str) {		
		boolean empty = true;
		if(str != null && !str.equals("")) empty = false;
		return empty;
	}
}

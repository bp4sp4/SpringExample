package com.qwerpark.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qwerpark.spring.ex.database.domain.UsedGoods;
import com.qwerpark.spring.ex.database.service.UsedGoodsService;


// request 와 response 처리 담당
@Controller
public class UsedGoodsController {
	
	@Autowired
	private UsedGoodsService uesdGoodsService;
	
	@RequestMapping("/db/usedgoods/list")
	@ResponseBody
	public List<UsedGoods> uesdGoodsList() {

		// 중고물품 게시글 리스트 얻어 오기
		List<UsedGoods> usedGoodsList = uesdGoodsService.getUsedGoodsList();
		
		return usedGoodsList;
	}

}

package com.qwerpark.spring.ex.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qwerpark.spring.ex.database.domain.UsedGoods;
import com.qwerpark.spring.ex.database.repository.UsedGoodsRepository;

// 로직 (business) 담당
// 데이터를 수정 가공
// 그 외 복잡한 기능 수행
@Service
public class UsedGoodsService {
	
	// Repository 객체 관리를 스프링에게 위임
	@Autowired
	private UsedGoodsRepository usedGoodRepository;

	// 중고 물품 게시글 리턴 기능
	public List<UsedGoods> getUsedGoodsList() {
		// usedGoods 테이블 모든행 조회
		List<UsedGoods> usedGoodsList = usedGoodRepository.selectUsedGoodsList();
		
		return usedGoodsList;
	}
}

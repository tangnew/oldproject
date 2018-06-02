package com.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.product.Product;

public interface ProductMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Product record);

	Product selectByPrimaryKey(Long id);

	List<Product> selectAllByUserNameAndStatus(
			@Param(value = "userName") String userName,
			@Param(value = "status") Long status);

	int updateByPrimaryKey(Product record);

	void updateStatusByProductIdAndStatus(@Param(value = "id") long productId,
			@Param(value = "status") long status);

	List<Product> listByUserAndStatus(
			@Param(value = "userName") String userName,
			@Param(value = "statusList") List<Long> statusList);
}
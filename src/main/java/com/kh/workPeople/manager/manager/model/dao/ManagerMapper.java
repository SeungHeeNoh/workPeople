package com.kh.workPeople.manager.manager.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.workPeople.common.vo.Manager;
import com.kh.workPeople.common.vo.ManagerRole;
import com.kh.workPeople.common.vo.PageInfo;

@Mapper
public interface ManagerMapper {

	int getListCount();

	List<Manager> selectList(PageInfo pi);

	Manager classManager(int imNo);

	int classDeleteManager(@Param("imNo") int imNo, @Param("code") int code);

	int classInsertManager(@Param("imNo") int imNo, @Param("code") int code);

	int createManager(Manager manager);

	int insertManagerRole(ManagerRole managerRole);
	
	int idOverlapCheck(String id);
	
	Manager getManagerByImId(String id);

	
}

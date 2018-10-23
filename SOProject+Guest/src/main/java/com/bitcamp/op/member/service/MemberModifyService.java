package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.model.MemberInfo;

public class MemberModifyService {

	@Autowired
	private JdbcTemplateMemberDao jdbcTemplateMemberDao;

	public MemberInfo getMemberBefore(String id) throws SQLException {

		MemberInfo memberInfo = jdbcTemplateMemberDao.getMemberInfo(id);

		return memberInfo;

	}

	public int getMemberAfter(MemberInfo memberInfo, HttpServletRequest request)
			throws SQLException, IllegalStateException, IOException {

		int resultCnt = 0;

		// 물리적 저장 경로
		String uploadUri = "/uploadfile/userphoto";
		// uploadUri 경로의 시스템 경로
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);

		// DB 저장용 파일 이름, 물리적 저장할때의 이름
		String imgName = "";

		if (!memberInfo.getPhotoFile().isEmpty()) {

			imgName = memberInfo.getUserId() + "_" + memberInfo.getPhotoFile().getOriginalFilename();

			// 물리적 저장
			memberInfo.getPhotoFile().transferTo(new File(dir, imgName));

			// DB 에 저장할 이름 SET
			memberInfo.setUserPhoto(imgName);

		}

		resultCnt = jdbcTemplateMemberDao.ModifyMemberInfo(memberInfo);

		return resultCnt;
	}

}
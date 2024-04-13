package com.bcf.church.services;

import com.bcf.church.entities.Member;
import com.bcf.church.payloads.MemberDto;
import com.bcf.church.payloads.PaginationResponse;

import java.util.List;

public interface MemberService {
    MemberDto createMember(MemberDto memberDto);
    PaginationResponse<MemberDto> getAllMembers(int pageNo, int pageSize, String sortBy);

    MemberDto getMemberById(long id);

    MemberDto updateMember(MemberDto memberDto, long id);

    void deleteMemberById(long id);
}

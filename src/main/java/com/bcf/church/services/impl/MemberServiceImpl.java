package com.bcf.church.services.impl;

import com.bcf.church.entities.Member;
import com.bcf.church.exceptions.ResourceNotFoundException;
import com.bcf.church.payloads.MemberDto;
import com.bcf.church.payloads.PaginationResponse;
import com.bcf.church.repositories.MemberRepository;
import com.bcf.church.services.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MemberServiceImpl(MemberRepository memberRepository, ModelMapper modelMapper){
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public MemberDto createMember(MemberDto memberDto) {

        Member member = mapToEntity(memberDto);

        Member newMember = memberRepository.save(member);

        return mapToDTO(newMember);
    }

    @Override
    public PaginationResponse<MemberDto> getAllMembers(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        Page<Member> members = memberRepository.findAll(pageable);
        List<Member> listOfMember = members.getContent();
        List<MemberDto> content = listOfMember
                .stream()
                .map(this::mapToDTO)
                .toList();

        PaginationResponse<MemberDto> response = new PaginationResponse<>();
        response.setContent(content);
        response.setPageNo(members.getNumber());
        response.setPageSize(members.getSize());
        response.setTotalElements(members.getTotalElements());
        response.setTotalPages(members.getTotalPages());
        response.setLast(members.isLast());

        return response;
    }

    @Override
    public MemberDto getMemberById(long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));
        return mapToDTO(member);
    }

    @Override
    public MemberDto updateMember(MemberDto memberDto, long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));
        member.setBirthday(memberDto.getBirthday());
        member.setFirstName(memberDto.getFirstName());
        member.setMiddleName(memberDto.getMiddleName());
        member.setLastName(memberDto.getLastName());

        Member updateMember = memberRepository.save(member);

        return mapToDTO(updateMember);
    }

    @Override
    public void deleteMemberById(long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));
        memberRepository.delete(member);
    }

    private MemberDto mapToDTO(Member member){
        return modelMapper.map(member, MemberDto.class);
    }

    private Member mapToEntity(MemberDto memberDto){
        return modelMapper.map(memberDto, Member.class);
    }
}

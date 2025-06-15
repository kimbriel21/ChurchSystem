package com.bcf.church.controllers;

import com.bcf.church.payloads.MemberDto;
import com.bcf.church.payloads.PaginationResponse;
import com.bcf.church.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<MemberDto> create(@RequestBody MemberDto memberDto) {
        MemberDto memberDtoRes = memberService.createMember(memberDto);
        return new ResponseEntity<>(memberDtoRes, HttpStatus.CREATED);
    }

    @GetMapping
    public PaginationResponse<MemberDto> index(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy
    ){
        return memberService.getAllMembers(pageNo, pageSize, sortBy);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> show(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDto> edit(@RequestBody MemberDto memberDto,
                                                  @PathVariable(name = "id") long id) {
        MemberDto memberRes = memberService.updateMember(memberDto, id);
        return ResponseEntity.ok(memberRes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id){
        memberService.deleteMemberById(id);
        return ResponseEntity.ok("Member entity deleted successfully");
    }
}

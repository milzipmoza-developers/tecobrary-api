package dev.milzipmoza.tecobrary.api;

public class ApiResponseMessage {

    public static final String NAVER_API_BOOK_SEARCH_SUCCESS = "네이버 api 를 통한 책 검색에 성공하였습니다.";

    public static final String GET_LIBRARY_BOOKS_SUCCESS = "도서 목록 조회에 성공하였습니다.";

    public static final String GET_LIBRARY_BOOK_DETAIL_SUCCESS = "도서 상세 조회에 성공하였습니다.";

    public static final String ENROLL_LIBRARY_BOOK_SUCCESS = "도서 등록에 성공하였습니다.";
    public static final String ENROLL_LIBRARY_BOOK_FAILED = "도서 등록에 실패하였습니다. 사유 : 이미 등록된 ISBN";

    public static final String UPDATE_LIBRARY_BOOK_SUCCESS = "도서 정보를 업데이트 하였습니다.";
    public static final String UPDATE_LIBRARY_BOOK_FAILED = "도서 정보 업데이트에 실패 하였습니다.";

    public static final String DELETE_LIBRARY_BOOK_SUCCESS = "도서 삭제에 성공하였습니다.";

    public static final String LIBRARY_BOOK_NOT_FOUND = "해당하는 도서를 찾을 수 없습니다.";
}

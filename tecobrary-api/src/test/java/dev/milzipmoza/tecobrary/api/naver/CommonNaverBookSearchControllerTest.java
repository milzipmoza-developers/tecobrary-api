package dev.milzipmoza.tecobrary.api.naver;

import dev.milzipmoza.tecobrary.api.naver.facade.NaverBookSearchFacade;
import dev.milzipmoza.tecobrary.core.client.naverapi.dto.NaverBookSearchItemDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static dev.milzipmoza.tecobrary.api.ApiResponseMessage.NAVER_API_BOOK_SEARCH_SUCCESS;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, MockitoExtension.class})
@AutoConfigureRestDocs
class CommonNaverBookSearchControllerTest {

    @Mock
    private NaverBookSearchFacade naverBookSearchFacade;

    @InjectMocks
    private CommonNaverBookSearchController commonNaverBookSearchController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp(RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.standaloneSetup(commonNaverBookSearchController)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    void searchBook() throws Exception {
        given(naverBookSearchFacade.searchBooks(any(), any(), any()))
                .willReturn(Arrays.asList(
                        NaverBookSearchItemDto.builder()
                                .title("제목")
                                .author("작가")
                                .publisher("출판사")
                                .image("https://image.path/book.cover.img")
                                .description("책 요약")
                                .isbn("아이에스비엔")
                                .build(),
                        NaverBookSearchItemDto.builder()
                                .title("제목")
                                .author("작가")
                                .publisher("출판사")
                                .image("https://image.path/book.cover.img")
                                .description("책 요약")
                                .isbn("아이에스비엔")
                                .build()
                ));

        this.mockMvc.perform(get("/admin/naver-api/books")
                .queryParam("keyword", "HELLO WORLD")
                .queryParam("size", "10")
                .queryParam("page", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.message").value(NAVER_API_BOOK_SEARCH_SUCCESS))
                .andExpect(jsonPath("$.serverDateTime").isNotEmpty())
                .andExpect(jsonPath("$.data.items[*]").isNotEmpty())
                .andExpect(jsonPath("$.data.items[*].title").isNotEmpty())
                .andExpect(jsonPath("$.data.items[*].author").isNotEmpty())
                .andExpect(jsonPath("$.data.items[*].publisher").isNotEmpty())
                .andExpect(jsonPath("$.data.items[*].image").isNotEmpty())
                .andExpect(jsonPath("$.data.items[*].description").isNotEmpty())
                .andExpect(jsonPath("$.data.items[*].isbn").isNotEmpty())
                .andDo(document("naver/book-search",
                        responseFields(
                                fieldWithPath("status").description("응답 상태"),
                                fieldWithPath("message").description("응답 메시지"),
                                fieldWithPath("serverDateTime").description("응답 서버 시간"),
                                fieldWithPath("data").description("응답 데이터"),
                                fieldWithPath("data.items[]").description("검색된 책의 목록"),
                                fieldWithPath("data.items[].title").description("검색된 책 제목"),
                                fieldWithPath("data.items[].author").description("검색된 책 작가"),
                                fieldWithPath("data.items[].publisher").description("검색된 책 출판사"),
                                fieldWithPath("data.items[].image").description("검색된 책 이미지"),
                                fieldWithPath("data.items[].description").description("검색된 책 요약"),
                                fieldWithPath("data.items[].isbn").description("검색된 책 ISBN")
                        ))
                );
    }
}
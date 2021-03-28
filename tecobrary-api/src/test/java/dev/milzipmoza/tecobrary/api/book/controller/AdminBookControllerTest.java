package dev.milzipmoza.tecobrary.api.book.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.milzipmoza.tecobrary.api.book.facade.BookFacade;
import dev.milzipmoza.tecobrary.api.book.request.BookEnrollRequest;
import dev.milzipmoza.tecobrary.api.book.response.BookEnrollResponse;
import dev.milzipmoza.tecobrary.core.domain.book.exception.BookAlreadyEnrolledException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static dev.milzipmoza.tecobrary.api.ApiResponseMessage.ENROLL_LIBRARY_BOOK_FAILED;
import static dev.milzipmoza.tecobrary.api.ApiResponseMessage.ENROLL_LIBRARY_BOOK_SUCCESS;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, MockitoExtension.class})
@AutoConfigureRestDocs
class AdminBookControllerTest {

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private BookFacade bookFacade;

    @InjectMocks
    private AdminBookController adminBookController;

    @BeforeEach
    void setUp(RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.standaloneSetup(adminBookController)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    void enroll() throws Exception {
        String content = objectMapper.writeValueAsString(BookEnrollRequest.builder()
                .title("자바 ORM 표준 JPA 프로그래밍")
                .author("김영한")
                .publisher("에이콘")
                .description("JPA 기본서")
                .isbn("1Q2W3E4R 5T6Y7U8I")
                .image("https://book.image/path.jpg")
                .build());

        given(bookFacade.enroll(any()))
                .willReturn(BookEnrollResponse.builder()
                        .id(1L)
                        .title("자바 ORM 표준 JPA 프로그래밍")
                        .author("김영한")
                        .publisher("에이콘")
                        .description("JPA 기본서")
                        .isbn("1Q2W3E4R 5T6Y7U8I")
                        .image("https://book.image/path.jpg")
                        .build());

        this.mockMvc.perform(put("/admin/library-books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.message").value(ENROLL_LIBRARY_BOOK_SUCCESS))
                .andExpect(jsonPath("$.serverDateTime").isNotEmpty())
                .andExpect(jsonPath("$.data.id").isNotEmpty())
                .andExpect(jsonPath("$.data.title").isNotEmpty())
                .andExpect(jsonPath("$.data.author").isNotEmpty())
                .andExpect(jsonPath("$.data.publisher").isNotEmpty())
                .andExpect(jsonPath("$.data.image").isNotEmpty())
                .andExpect(jsonPath("$.data.description").isNotEmpty())
                .andExpect(jsonPath("$.data.isbn").isNotEmpty())
                .andDo(document("library-book/enroll",
                        responseFields(
                                fieldWithPath("status").description("응답 상태"),
                                fieldWithPath("message").description("응답 메시지"),
                                fieldWithPath("serverDateTime").description("응답 서버 시간"),
                                fieldWithPath("data").description("응답 데이터"),
                                fieldWithPath("data.id").description("등록된 책의 id"),
                                fieldWithPath("data.title").description("등록된 책의 제목"),
                                fieldWithPath("data.author").description("등록된 책의 작가"),
                                fieldWithPath("data.publisher").description("등록된 책의 출판사"),
                                fieldWithPath("data.image").description("등록된 책의 이미지"),
                                fieldWithPath("data.description").description("등록된 책의 요약"),
                                fieldWithPath("data.isbn").description("등록된 책의 ISBN")
                        ))
                );
    }

    @Test
    void enrollFailed() throws Exception {
        String content = objectMapper.writeValueAsString(BookEnrollRequest.builder()
                .title("자바 ORM 표준 JPA 프로그래밍")
                .author("김영한")
                .publisher("에이콘")
                .description("JPA 기본서")
                .isbn("1Q2W3E4R 5T6Y7U8I")
                .image("https://book.image/path.jpg")
                .build());

        given(bookFacade.enroll(any()))
                .willThrow(new BookAlreadyEnrolledException());

        this.mockMvc.perform(put("/admin/library-books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value("FAIL"))
                .andExpect(jsonPath("$.message").value(ENROLL_LIBRARY_BOOK_FAILED))
                .andExpect(jsonPath("$.serverDateTime").isNotEmpty())
                .andDo(document("library-book/enroll-failed",
                        responseFields(
                                fieldWithPath("status").description("응답 상태"),
                                fieldWithPath("message").description("응답 메시지"),
                                fieldWithPath("serverDateTime").description("응답 서버 시간")
                        ))
                );
    }
}
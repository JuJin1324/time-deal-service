package com.timedeal.api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    // 사용자 ID를 전달하는 데 사용될 HTTP 헤더 이름
    private static final String USER_ID_HEADER = "X-User-Id";

    // OpenAPI 객체를 정의하는 빈
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                // API 문서의 기본 정보 (제목, 설명, 버전) 설정
                .info(new Info()
                        .title("타임딜 서비스 API")
                        .description("대규모 동시성 테스트를 위한 API (기능 최소화, 엔지니어링 최대화 철학)")
                        .version("v1.0.0"))
                // X-User-Id 헤더를 API 키로 보안 스키마에 추가
                .components(new Components()
                        .addSecuritySchemes(USER_ID_HEADER, new SecurityScheme()
                                .type(SecurityScheme.Type.APIKEY) // API Key 타입
                                .in(SecurityScheme.In.HEADER) // 헤더를 통해 전달
                                .name(USER_ID_HEADER) // 헤더 이름
                                .description("사용자 식별을 위한 ID (예: 1, 2, 100)"))) // 설명
                // 모든 API 요청에 X-User-Id 보안 요구사항 적용
                .addSecurityItem(new SecurityRequirement().addList(USER_ID_HEADER));
    }

    // 모든 API Operation에 X-User-Id 헤더 파라미터를 추가하는 커스터마이저
    @Bean
    public OperationCustomizer globalHeaderCustomizer() {
        return (operation, handlerMethod) -> {
            operation.addParametersItem(new Parameter()
                    .in("header") // 헤더 파라미터
                    .required(true) // 필수 값
                    .description("사용자 식별 ID") // 설명
                    .name(USER_ID_HEADER)); // 파라미터 이름
            return operation;
        };
    }
}

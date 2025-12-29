### **🏃 Sprint 1. 청사진 설계 및 격리된 모듈러 환경 구축**

**Goal:** 프로젝트 철학 확립 후, 그에 맞는 아키텍처 설계 및 환경 셋업

- **ADR 001 작성: 프로젝트 철학 및 아키텍처 결정** (Epic 1)
    - └ **Strategy:** `[Decision First]` "Feature Minimal, Engineering Maximal" 전략 및 모듈러 모놀리스 구조 채택 토론 및 확정.
- **C4 아키텍처 다이어그램 작성** (Epic 1)
    - └ **Strategy:** `[Over-Engineering]` ADR 001의 결정 사항을 Mermaid 코드로 시각화 (Context/Container).
- **핵심 시퀀스 다이어그램 작성** (Epic 1)
    - └ **Strategy:** `[Over-Engineering]` 주문/재고차감 흐름 설계 및 논리적 오류 사전 차단.
- **Git 기반 ADR 프로세스 수립** (Epic 1)
    - └ **Strategy:** `[Over-Engineering]` ADR 템플릿 정의 및 리포지토리 초기화.
- **멀티 모듈 프로젝트 스캐폴딩** (Epic 2)
    - └ **Strategy:** `[Over-Engineering]` ADR 결정에 따라 모듈 간 의존성을 Gradle로 엄격히 제한.
- **ArchUnit 테스트 코드 작성** (Epic 2)
    - └ **Strategy:** `[Over-Engineering]` 설계된 아키텍처 규칙을 코드로 강제.
- **API 스펙(Swagger) 정의** (Epic 1)
    - └ **Strategy:** `[Business YAGNI]` 회원가입 제외, `X-User-Id` 헤더 기반 설계.
- **Onboarding: Project Init & Makefile** (Epic 2)
    - └ **Action:** 프로젝트 루트에 `Makefile` 생성.
    - └ **Command:** `make init` (git hook 설치, 환경변수 설정), `make infra-up` (Docker Compose 실행).
    - └ **Doc:** README 최상단에 "How to Run Infrastructure" 작성.
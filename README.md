# Time-Deal Service ⏳

> **Feature Minimal, Engineering Maximal**  
> 대규모 트래픽 처러, 동시성 이슈 제어, 시스템 회복 탄력성(Resilience) 확보에 집중한 백엔드 엔지니어링 포트폴리오 프로젝트입니다.

---

## 1. WHY: 프로젝트 철학

대부분의 포트폴리오가 "다양한 기능 구현"(예: 회원가입, 장바구니, 관리자 페이지, 추천 시스템 등)에 집중하는 반면,  
**Time-Deal Service**는 정반대의 접근 방식을 취합니다: **"핵심 엔지니어링 문제에 대한 깊이 있는 탐구."**

### 목표 (The Goal)
이 프로젝트의 핵심 목표는 기능이 많은 쇼핑몰을 만드는 것이 아니라, 시스템을 **극한의 상황(대규모 트래픽)**에 노출시키고 그로 인해 발생하는 기술적 난제들(데이터 정합성, 성능, 확장성)을 해결하는 과정을 보여주는 것입니다.

### 해결하고자 하는 과제 (Key Challenges)
- **동시성 제어 (Concurrency Control):** 100개의 한정 수량 상품에 10,000명의 요청이 몰리는 상황을 시뮬레이션하고, DB Lock(Pessimistic/Optimistic) 및 Redis Distributed Lock을 통해 제어합니다.
- **경쟁 상태 해결 (Race Conditions):** 높은 부하 속에서도 재고가 절대 음수가 되지 않도록 데이터 무결성을 보장합니다.
- **아키텍처 진화 (Architecture Evolution):** 초기 동기식(Synchronous) 모놀리스 구조에서, 백프레셔(Backpressure) 처리를 위한 이벤트 기반(Event-Driven) 아키텍처로 진화해 나갑니다.

---

## 2. WHAT: 아키텍처 및 기술 스택

이 프로젝트는 배포의 단순함과 마이크로서비스의 엄격한 경계 분리라는 장점을 결합하기 위해 **모듈러 모놀리스(Modular Monolith)** 구조로 설계되었습니다.

### 시스템 아키텍처 (System Architecture)
- **Modular Monolith:** 비즈니스 도메인(`product`, `order`, `payment`)별로 모듈을 분리했습니다.
- **Hexagonal Architecture:** 헥사고날 아키텍처를 도입하여 비즈니스 로직과 인프라스트럭처를 철저히 격리합니다.
- **Vertical Slicing:** 각 모듈은 자신만의 데이터와 로직을 캡슐화하며, 공통(Common) 모듈을 공유하지 않는 'Share Nothing' 원칙을 지향합니다.

### 기술 스택 (Tech Stack)

| Category | Technology | Reasoning |
|----------|------------|-----------|
| **Language** | Java 21 | 최신 LTS 버전 및 Virtual Threads 활용 가능성 |
| **Framework** | Spring Boot 3.x | 엔터프라이즈 백엔드 표준 |
| **Build** | Gradle (Groovy DSL) | 멀티 모듈 의존성의 엄격한 관리 |
| **Database** | MySQL 8.0 | 모듈별 스키마 논리적 분리 |
| **Cache/Lock** | Redis | 분산 락 구현 및 캐싱 |
| **Testing** | JUnit 5, ArchUnit | 비즈니스 로직 검증 및 아키텍처 규칙 강제 |

---

## 3. HOW: 시작하기 및 문서

### 사전 요구 사항 (Prerequisites)
- JDK 21+
- Docker & Docker Compose

### 설치 및 실행 (Installation & Running)

```bash
# 리포지토리 클론
git clone https://github.com/your-username/time-deal-service.git

# 프로젝트 빌드
./gradlew clean build

# 단위 및 아키텍처 테스트 실행
./gradlew test
```

### 인프라 실행 (Infrastructure)
`Makefile`을 통해 로컬 개발 환경(MySQL, Redis)을 쉽게 구성할 수 있습니다.

```bash
# 프로젝트 초기화 (현재는 placeholder)
make init

# 인프라(MySQL, Redis) 실행
make infra-up

# 인프라 중지
make infra-down
```

### 주요 문서 (Documentation & ADRs)
이 프로젝트는 **ADR (Architecture Decision Record)** 프로세스를 통해 의사결정 과정을 기록합니다.

- [**전략 및 아키텍처**](docs/adr/001-project-strategy-and-architecture.md): 왜 모듈러 모놀리스인가? 왜 공통 모듈을 만들지 않는가?
- [**컨테이너 다이어그램**](docs/diagrams/c4-container-architecture.md): 시스템 전체 구성도
- [**주문 처리 시퀀스**](docs/diagrams/seq-order-critical-path.md): 동기식 주문 처리 프로세스

---
*Created by Jujin*

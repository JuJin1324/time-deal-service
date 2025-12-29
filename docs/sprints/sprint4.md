### **🏃 Sprint 4. 안정성 확보 및 대규모 부하 검증**

**Goal:** 안정성 전략 수립 후, 보호 장치 적용 및 정량적 데이터 확보

- **[NEW] ADR 004 작성: 안정성 및 정합성 보장 전략** (Epic 5)
    - └ **Strategy:** `[Decision First]` "네트워크가 끊겨도 중복 결제는 없다"는 멱등성 전략과 Redis-DB 간 데이터 불일치 해결(Reconciler) 전략 수립.
- **이벤트 기반 결제 처리 리팩토링** (Epic 5)
    - └ **Strategy:** `[Over-Engineering]` ADR 004에 따라 결제 로직을 비동기 이벤트로 분리하여 강결합 제거.
- **[NEW] API 및 이벤트 멱등성(Idempotency) 보장 구현** (Epic 5)
    - └ **Strategy:** `[Over-Engineering]` API 요청의 `Idempotency-Key` 헤더 검증 및 Kafka 메시지 중복 처리 방지 필터 구현.
- **[NEW] 이기종 저장소 간 데이터 정합성 보정기(Reconciler) 구현** (Epic 5)
    - └ **Strategy:** `[Over-Engineering]` Redis 재고와 DB 재고를 주기적으로 비교(Compare)하고, 불일치 시 자동 복구하는 **Self-Healing Batch** 구현.
- **Resilience4j 서킷 브레이커 적용** (Epic 5)
    - └ **Strategy:** `[Over-Engineering]` 장애 전파 차단을 위한 Fail Fast 설정 및 Fallback 로직 구현.
- **k6 부하 테스트 스크립트 작성** (Epic 6)
    - └ **Strategy:** `[Over-Engineering]` 시나리오 기반 대규모 부하 테스트 (평시/피크 상황 가정).
- **모니터링 대시보드 구성** (Epic 6)
    - └ **Strategy:** `[Over-Engineering]` Prometheus + Grafana 시각화 (RPS, Latency, Circuit State).
- **최종 회고 및 블로그 포스팅** (Epic 6)
    - └ **Strategy:** `[Tech Branding]` 프로젝트 전체 회고 및 기술적 의사결정(ADR) 정리.
- **Onboarding: Load Test & Monitoring** (Epic 5)
    - └ **Action:** 부하 테스트와 모니터링을 한방에 띄우는 명령어 추가.
    - └ **Command:** `make load-test` (k6 실행), `make monitor` (Grafana URL 출력).
    - └ **Doc:** "최종 성능 지표 확인 및 동시성 검증 방법" 가이드 작성.
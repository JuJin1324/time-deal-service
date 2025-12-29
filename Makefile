.PHONY: init infra-up infra-down build test clean

init:
	@echo "Initializing project..."
	# 추후 Git Hook 설치 등의 초기화 스크립트 추가 예정
	@echo "Initialization complete."

infra-up:
	@echo "Starting infrastructure..."
	docker compose up -d

infra-down:
	@echo "Stopping infrastructure..."
	docker compose down

build:
	./gradlew clean build

test:
	./gradlew test

clean:
	./gradlew clean

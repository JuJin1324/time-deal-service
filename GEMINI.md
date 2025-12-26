# Time-Deal Service - Engineering Portfolio Project

## 1. Project Overview

**Time-Deal Service** is a backend engineering portfolio project designed to demonstrate advanced capabilities in handling **high-concurrency traffic**, **race conditions**, and **system resilience**.

Unlike typical web application projects, this project adopts a **"Feature Minimal, Engineering Maximal"** strategy:
*   **Minimal Business Logic:** Skips standard features like Auth, Cart, Admin, etc., to focus on the core problem.
*   **Maximal Engineering Depth:** Intentionally exposes the system to raw traffic to solve real-world concurrency issues using DB Locks, Redis Distributed Locks, and Lua Scripts.

## 2. Architecture & Design

### 2.1. Domain-based Modular Monolith
The project is structured as a **Modular Monolith** to combine the simplicity of deployment with the strict boundary enforcement of microservices.
*   **Vertical Slicing:** Code is organized by domain (`product`, `order`, `payment`) rather than technical layers.
*   **No Common Module (Initially):** Adheres to the "Rule of Three" to avoid premature coupling.
*   **Hexagonal Architecture:** Each module uses Ports & Adapters to isolate domain logic from infrastructure.

### 2.2. Critical Path Strategy
*   **Synchronous Processing:** The "Order -> Stock Deduction" critical path is intentionally synchronous to simulate and resolve DB lock contention.
*   **Async Evolution:** Non-critical paths (Payment, Notifications) are slated for refactoring to Event-Driven Architecture (Kafka) in later sprints.

## 3. Technology Stack

*   **Language:** Java
*   **Framework:** Spring Boot
*   **Build System:** Gradle (Multi-module)
*   **Database:** MySQL (Logical separation by schema)
*   **Cache/Lock:** Redis
*   **Architecture patterns:** DDD, Hexagonal Architecture

## 4. Key Documentation

*   **Strategy & Architecture:** `docs/adr/001-project-strategy-and-architecture.md` (MUST READ for context)
*   **Container Diagram:** `docs/diagrams/c4-container-architecture.md`
*   **Sequence Diagram:** `docs/diagrams/seq-order-critical-path.md`

## 5. Development Roadmap

*   **Sprint 1:** Project Initialization & Domain Modeling.
*   **Sprint 2:** Core Business Logic Implementation (Synchronous).
*   **Sprint 3:** Deep Dive into Concurrency Control (Optimistic vs Pessimistic vs Redis Locks).
*   **Sprint 4:** Refactoring to Async/Event-Driven Architecture (Kafka).

## 6. Current Status

*   **Phase:** Initialization / Documentation.
*   **Action:** The project structure is being defined based on the ADRs. No source code exists yet.

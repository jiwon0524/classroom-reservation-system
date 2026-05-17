# 아키텍처 개요

## 선택 구조

```text
reservation-client
  Swing UI
  Controller
  ServerApiClient
        |
        | HTTP
        v
reservation-server
  API Handler
  Application Service
  Domain Policy
  Repository Interface
  File Repository
        |
        v
data/*.yaml
```

## 패키지 책임

| 위치 | 책임 |
|---|---|
| `common/domain` | `Classroom`, `Reservation`, `Role` 같은 핵심 모델 |
| `common/policy` | 체크인, 예약 시간, 정원 50% 같은 순수 정책 |
| `common/protocol` | 클라이언트와 서버가 같이 쓰는 API 경로 |
| `server/api` | HTTP 요청/응답 변환 |
| `server/application` | 예약, 승인, 체크인, 시설 신고 같은 유스케이스 |
| `server/repository` | 저장소 인터페이스 |
| `server/repository/file` | 파일 기반 저장 구현 |
| `server/storage` | 파일 경로, 임시 저장, 백업, 잠금 처리 |
| `client/ui` | Swing 화면 |
| `client/controller` | 화면 이벤트와 API 호출 연결 |
| `client/api` | 서버 HTTP 호출 |

## 팀 분담 제안

| 담당 | 우선 범위 |
|---|---|
| 1명 | 클라이언트 UI와 화면 전환 |
| 1명 | 예약/승인/취소 도메인 정책 |
| 1명 | 서버 API와 파일 저장소 |
| 1명 | 체크인/노쇼, 시설 신고, 테스트/문서 |

## 설계 원칙

- 화면은 서버 저장소를 직접 만지지 않는다.
- 서버 API는 역할 권한과 소유자 검사를 수행한다.
- 예약 충돌 검사는 클라이언트가 아니라 서버에서 최종 수행한다.
- 파일 저장은 임시 파일 작성, 검증, 원본 교체 순서로 구현한다.
- 예약 생성/승인/취소/노쇼 처리는 `roomId + date` 단위로 잠근다.
